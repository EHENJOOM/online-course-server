package com.zhk.controller;

import com.zhk.entity.po.AnswerPo;
import com.zhk.entity.vo.CommonResultVo;
import com.zhk.service.AnswerService;
import com.zhk.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 赵洪苛
 * @date 2020/8/23 22:32
 * @description 答疑控制层
 */
@Slf4j
@RestController
public class AnswerController {

    @Resource
    private AnswerService answerService;

    @GetMapping("/answer/{topicId}")
    public CommonResultVo<List<AnswerPo>> getAnswerBiTopic(@PathVariable("topicId") Integer topicId) {
        List<AnswerPo> answerPoList = answerService.getAnswerByTopic(topicId);
        log.info("通过话题ID查询答疑消息：{}", topicId);
        return ResultUtil.success(answerPoList);
    }

}
