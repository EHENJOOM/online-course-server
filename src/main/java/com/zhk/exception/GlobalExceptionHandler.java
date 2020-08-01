package com.zhk.exception;

import com.zhk.entity.vo.CommonResultVo;
import com.zhk.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 赵洪苛
 * @date 2020/8/1 15:37
 * @description 全局异常处理器
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public CommonResultVo handle(Exception e) {
        log.error("发生错误，错误信息：{}", e.getMessage());
        return ResultUtil.exception(e.getMessage(), null);
    }

}
