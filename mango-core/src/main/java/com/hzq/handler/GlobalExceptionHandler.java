package com.hzq.handler;

import com.hzq.dto.ResultBean;
import com.hzq.enums.MangeExceptionEnum;
import com.hzq.exception.MangoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author hzq
 * @ClassName GlobleExceptionHandler
 * @Date 2022/10/27 11:19
 * @Description 全局异常处理
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 处理自定义的业务异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = MangoException.class)
    public ResultBean<String> mangoExceptionHandler(HttpServletRequest req, MangoException e){
        LOGGER.error("发生业务异常！原因是：{}",e.getErrorMsg());
        return new ResultBean<>(e.getErrorCode(),e.getErrorMsg(), "业务异常");
    }


    /**
     * 处理其他异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public ResultBean<String> exceptionHandler(HttpServletRequest req, Exception e){
        LOGGER.error("未知异常！原因是: {}", e);
        return new ResultBean<>(MangeExceptionEnum.INTERNAL_SERVER_ERROR.getCode(),
                                MangeExceptionEnum.INTERNAL_SERVER_ERROR.getDesc(),
                                "未知的系统异常");
    }
}
