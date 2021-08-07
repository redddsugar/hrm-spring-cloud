package com.itsource.hrm.exception;

import com.itsource.hrm.util.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({GlobalException.class})
    public AjaxResult myGlobalHandler(GlobalException e) {
        log.error(e.getMessage());
        return AjaxResult.me().setSuccess(false).setMessage("机构入驻失败->"+e.getMessage());
    }

    @ExceptionHandler({Exception.class})
    public AjaxResult handler(Exception e) {
        log.error(e.getMessage());
        return AjaxResult.me().setSuccess(false).setMessage("系统异常,联系管理员");
    }
}
