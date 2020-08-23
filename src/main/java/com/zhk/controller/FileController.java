package com.zhk.controller;

import cn.hutool.core.util.IdUtil;
import com.jlefebure.spring.boot.minio.MinioConfigurationProperties;
import com.jlefebure.spring.boot.minio.MinioException;
import com.jlefebure.spring.boot.minio.MinioService;
import com.zhk.config.Config;
import com.zhk.entity.po.FilePo;
import com.zhk.entity.vo.CommonResultVo;
import com.zhk.service.FileService;
import com.zhk.util.ResultUtil;
import io.minio.MinioClient;
import io.minio.messages.Item;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.InputStreamResource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 文件上传下载控制层
 * @author 赵洪苛
 * @date 2020/8/22 14:52
 * @description 文件上传下载控制层
 */
@Slf4j
@RestController
public class FileController {

    @Resource
    private FileService fileService;

    @Resource
    private MinioService minioService;

    @Resource
    private MinioConfigurationProperties configurationProperties;

    @GetMapping("/file/{courseId}/{teacherId}/{page}/{pageSize}")
    public CommonResultVo getAllFileName(@PathVariable("courseId") Integer courseId, @PathVariable("teacherId") Integer teacherId, @PathVariable("page") Integer page, @PathVariable("pageSize") Integer pageSize) {
        List<FilePo> filePoList = fileService.getFileByCourseAndTeacher(courseId, teacherId, (page - 1) * pageSize, pageSize);
        Map<String, Object> map = new HashMap<>();
        log.info("查询filePo：{}", filePoList);
        map.put("list", filePoList);
        map.put("total", fileService.countByCourseAndTeacher(courseId, teacherId));
        return ResultUtil.success(map);
    }

    @GetMapping("/file/{fileName}")
    public void getFile(@PathVariable("fileName") String fileName, HttpServletResponse response) throws IOException, MinioException {
        log.info("下载文件：{}", fileName);

        InputStream inputStream = minioService.get(Paths.get(fileName));

        response.addHeader("Content-disposition", "attachment;filename=" + fileName);
        response.setContentType(URLConnection.guessContentTypeFromName(fileName));

        IOUtils.copy(inputStream, response.getOutputStream());
        response.flushBuffer();
    }

    @PostMapping("/file")
    public CommonResultVo upload(@RequestParam("file") MultipartFile file, @RequestParam("courseId") Integer courseId, @RequestParam("teacherId") Integer teacherId) {
        String fileName = file.getOriginalFilename();
        String[] split = fileName.split("\\.");
        String newFileName;
        // 若原文件名有后缀，则取出后缀，否则不加后缀
        if (split.length > 1) {
            newFileName = IdUtil.simpleUUID() + "." + split[split.length - 1];
        } else {
            newFileName = IdUtil.simpleUUID();
        }
        Path path = Paths.get(newFileName);
        String url = configurationProperties.getUrl() + "/" + configurationProperties.getBucket() + "/" + newFileName;
        log.info("文件地址：{}", url);
        try {
            minioService.upload(path, file.getInputStream(), file.getContentType());
            FilePo filePo = new FilePo();
            filePo.setCourseId(courseId);
            filePo.setTeacherId(teacherId);
            filePo.setLogicalName(fileName);
            filePo.setMinioName(newFileName);
            filePo.setUrl(url);
            fileService.insert(filePo);
            return ResultUtil.success(url);
        } catch (Exception e) {
            return ResultUtil.error(Config.SERVER_ERROR, "文件上传失败！");
        }
    }

    @DeleteMapping("/file/{fileName}")
    public CommonResultVo deleteFile(@PathVariable("fileName") String fileName) {
        try {
            minioService.remove(Paths.get(fileName));
            return ResultUtil.success("删除成功！");
        } catch (MinioException e) {
            return ResultUtil.error(Config.SERVER_ERROR, "删除失败！");
        }
    }

}
