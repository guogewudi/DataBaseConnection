package com.adc.common.exception;


import com.adc.common.constants.ResultCode;

/**
 * Copyright@http://github.com/guogewudi
 * Author:国宇航
 * Date:2019/8/22
 * Description:
 */
public class ExceptionCast {
    //使用此静态方法抛出自定义异常
    public static void cast(ResultCode resultCode){
        throw new CustomException(resultCode);
    }
}
