package com.adc.common.exception;

import com.adc.common.constants.ResultCode;


/**
 * Copyright@http://github.com/guogewudi
 * Author:国宇航
 * Date:2019/8/22
 * Description:
 */
//自定义异常类型
    //自定义异常继承runtime无侵入性
public class CustomException extends RuntimeException {
    private ResultCode resultCode;
    public CustomException(ResultCode resultCode) {
//异常信息为错误代码+异常信息
        super("错误代码："+resultCode.code()+"错误信息："+resultCode.message());
        this.resultCode = resultCode;
    }
    public Integer getResultCode(){
        return this.resultCode;
    }
}
