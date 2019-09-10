package com.adc.databaseConnection.controller;


import com.adc.common.constants.ResultCodeEnum;
import com.adc.common.exception.ExceptionCast;
import com.adc.common.vo.R;
import com.adc.databaseConnection.entity.DatabaseParamType;
import com.adc.databaseConnection.service.impl.DataBaseConnectionServiceImpl;
import com.adc.databaseConnection.utils.GetDataBaseTypeUtils;
import com.sun.javafx.collections.MappingChange;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright@http://github.com/guogewudi
 * Author:国宇航
 * Date:2019/9/5
 * Description:
 */

@RestController
@CrossOrigin//跨域

@Api("获取连接对象接口，请通过此接口获取连接对象")
public class DataBaseConnectionController {
    @Autowired
    DataBaseConnectionServiceImpl dataBaseConnectionService;


    //连接数据库需要的参数 数据库类型  数据库连接参数  sql语句 sql语句类型
    /**
     *需要传入这四个参数
     *  private String dataBaseType;
        private String connection_name;
        private String database_username;
        private String database_password;
     */
    @PostMapping("/databaseConnect")
    @ApiOperation("获取连接对象（connection）方法")
    public R ConnectingDatabase(
            @ApiParam(name = "databaseParamType", value = "数据库参数类型：包括四个字段（type,url,username,password）", required = true)
            DatabaseParamType databaseParamType, HttpSession session
                                     ) throws Exception {
        String dataBaseType = databaseParamType.getDataBaseType();
        //获取驱动类
        String  driverClassName = GetDataBaseTypeUtils.getDriverClass(dataBaseType);
        String driver_name = driverClassName;
        //获取url
        String connection_name = databaseParamType.getConnection_name();
        //获取数据库用户名密码
        String database_username = databaseParamType.getDatabase_username();
        String database_password = databaseParamType.getDatabase_password();

//        String databaseType = dataBaseType.getType();
        //如果type不符合Utils里获得的type则返回错误
        String type = GetDataBaseTypeUtils.getDriverClass(dataBaseType);

        if(type==null){
            ExceptionCast.cast(ResultCodeEnum.UNKNOWN_TYPE);
        }
        try {

            Connection connection = dataBaseConnectionService.getConnection(driver_name, connection_name, database_username, database_password);
            session.setAttribute("connection",connection);

            //成功将connection对象放入了session域
            return R.ok().message("connection对象成功的放在了session域");
            } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


       //这个接口调用失败了
        return R.error().message("没有获取connection对象");
    }

}
