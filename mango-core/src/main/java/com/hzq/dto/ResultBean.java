package com.hzq.dto;

import com.hzq.enums.MangeExceptionEnum;
import lombok.*;

import java.io.Serializable;

/**
 * @Author hzq
 * @ClassName ResultBean
 * @Date 2022/10/27 10:42
 * @Description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultBean<T> implements Serializable {

    private static final long serialVersionUID = -3687018867892171211L;

    /**
     * 返回的业务状态码
     */
    private String resultCode = MangeExceptionEnum.SUCCESS.getCode();


    /**
     * 提示信息
     */
    private String resultMsg = MangeExceptionEnum.SUCCESS.getDesc();

    /**
     * 返回的数据
     */
    private T data;

    public ResultBean(String resultCode, String resultMsg) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    public ResultBean(T data) {
        this.data = data;
    }
}
