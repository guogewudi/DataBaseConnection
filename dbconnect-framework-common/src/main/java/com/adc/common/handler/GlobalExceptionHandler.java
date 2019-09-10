package com.adc.common.handler;


import com.adc.common.constants.ResultCodeEnum;
import com.adc.common.exception.DBConnectException;
import com.adc.common.vo.R;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice//切面-

public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)//切点
    @ResponseBody//服务器将错误以Json字符串方式给前端
    public R error(Exception e){
        e.printStackTrace();
        return R.error();
        }


    @ExceptionHandler(BadSqlGrammarException.class)//小切点优先
    @ResponseBody
    public  R error(BadSqlGrammarException e){
        e.printStackTrace();
        return R.setResult(ResultCodeEnum.BAD_SQL_GRAMMAR);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)//小切点优先
    @ResponseBody
    public  R error(HttpMessageNotReadableException e){
        e.printStackTrace();
        return R.setResult(ResultCodeEnum.JSON_PARSE_ERROR);
    }



    @ExceptionHandler(DBConnectException.class)
    @ResponseBody
    public R error(DBConnectException e){
        e.printStackTrace();
        return R.error().message(e.getMessage()).code(e.getCode());

    }
}

