package com.adc.common.constants;

import lombok.Getter;

@Getter
public enum  ResultCodeEnum implements ResultCode {

    SUCCESS(true, 20000,"成功"),
    FAIL(false,11111,"操作失败！"),
    INVALIDPARAM(false,10003,"非法参数！"),
    UNKNOWN_REASON(false, 20001, "未知错误"),
    UNKNOWN_TYPE(false, 20021, "未知数据库类型"),
    BAD_SQL_GRAMMAR(false, 21001, "sql语法错误"),
    JSON_PARSE_ERROR(false, 21002, "json解析异常"),
    PARAM_ERROR(false, 21003, "参数不正确"),
    FILE_UPLOAD_ERROR(false, 21004, "文件上传错误"),
    EXCEL_DATA_IMPORT_ERROR(false, 21005, "Excel数据导入错误");

    private Boolean success;
    private Integer code;
    private String message;

    @Override
    public boolean success() {
        return success;
    }
    @Override
    public int code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }
    private ResultCodeEnum(Boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
        }
}
