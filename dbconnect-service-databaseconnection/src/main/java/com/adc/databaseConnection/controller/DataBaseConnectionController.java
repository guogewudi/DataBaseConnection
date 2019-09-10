package com.adc.databaseConnection.controller;


import com.adc.databaseConnection.entity.DatabaseParamType;
import com.adc.databaseConnection.service.impl.DataBaseConnectionServiceImpl;
import com.adc.databaseConnection.utils.GetDataBaseTypeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.SQLException;
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
public class DataBaseConnectionController {
    @Autowired
    DataBaseConnectionServiceImpl dataBaseConnectionService;

    @PostMapping("/databaseConnect")
    //连接数据库需要的参数 数据库类型  数据库连接参数  sql语句 sql语句类型
    public String ConnectingDatabase(Map<String,Object> map,
                                     DatabaseParamType databaseParamType,
                                     HttpSession session
                                     ) throws Exception {


        String dataBaseType = databaseParamType.getDataBaseType();
        //获取驱动类
        String  driverClassName = GetDataBaseTypeUtils.getDriverClass(dataBaseType);
        databaseParamType.setDriver_name(driverClassName);
        String driver_name = databaseParamType.getDriver_name();
        //获取url
        String connection_name = databaseParamType.getConnection_name();
        //获取数据库用户名密码
        String database_username = databaseParamType.getDatabase_username();
        String database_password = databaseParamType.getDatabase_password();

//        String databaseType = dataBaseType.getType();
        //如果type不符合Utils里获得的type则返回错误
        String type = GetDataBaseTypeUtils.getDriverClass(dataBaseType);
        if(type==null){
            System.out.println("参数为空");
            return "redirect:/databaseConnect";
        }
        try {
            Connection connection = dataBaseConnectionService.getConnection(driver_name, connection_name, database_username, database_password);
            session.setAttribute("connection",connection);
            List<String> tableNames =dataBaseConnectionService.searchTableNames(driver_name, connection_name, database_username, database_password);
            System.out.println("连接成功");
            map.put("tablename",tableNames);

            return "tablename";
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        System.out.println("失败了");
        return "redirect:/databaseConnect";
    }

}
