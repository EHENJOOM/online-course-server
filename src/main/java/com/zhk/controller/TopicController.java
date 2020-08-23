package com.zhk.controller;

import com.zhk.entity.po.TopicPo;
import com.zhk.entity.vo.CommonResultVo;
import com.zhk.service.TopicService;
import com.zhk.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author 赵洪苛
 * @date 2020/8/23 18:34
 * @description 主题控制层
 */
@Slf4j
@RestController
public class TopicController {

    @Resource
    private TopicService topicService;

    @GetMapping("/topic/{courseId}")
    public CommonResultVo<List<TopicPo>> getTopicByCourse(@PathVariable("courseId") Integer courseId) {
        List<TopicPo> topicPoList = topicService.getTopicByCourse(courseId);
        log.info("通过courseId查询话题：{}", topicPoList);
        return ResultUtil.success(topicPoList);
    }

    @PostMapping("/topic")
    public CommonResultVo<String> insertTopic(@RequestBody TopicPo topicPo) {
        topicPo = topicService.insert(topicPo);
        if (topicPo.getPublish() == TopicPo.PUBLISHED) {
            topicPo.setPublishTime(new Date());
        }
        log.info("添加话题：{}", topicPo);
        return ResultUtil.success("添加成功！");
    }

    @PutMapping("/topic/publish")
    public CommonResultVo<String> publishTopic(@RequestBody TopicPo topicPo) {
        log.info("发布话题：{}", topicPo);
        topicPo.setPublish(TopicPo.PUBLISHED);
        topicPo.setPublishTime(new Date());
        topicService.update(topicPo);
        return ResultUtil.success("发布成功！");
    }

    @DeleteMapping("/topic/{topicId}")
    public CommonResultVo<String> deleteTopicById(@PathVariable("topicId") Integer id) {
        log.info("删除topic：{}", id);
        topicService.deleteById(id);
        return ResultUtil.success("删除成功！");
    }

}
