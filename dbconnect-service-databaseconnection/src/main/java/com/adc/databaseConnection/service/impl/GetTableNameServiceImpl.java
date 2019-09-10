package com.adc.databaseConnection.service.impl;

import com.adc.databaseConnection.service.GetTableNameService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright@http://github.com/guogewudi
 * Author:国宇航
 * Date:2019/9/10
 * Description:
 */

@Service
public class GetTableNameServiceImpl implements GetTableNameService {


    public List<String> searchTableNames(HttpSession session) throws Exception
    {

        Connection connection = (Connection) session.getAttribute("connection");
        List<String> list = new ArrayList<String>();

        Statement statement = connection.createStatement();
        String sql = "show tables";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            System.out.println(resultSet.getString(1));
            list.add(resultSet.getString(1)+"  ");
        }
        System.out.println(list);
        return list;
    }

}
