package com.adc.databaseConnection.service.impl;


import com.adc.databaseConnection.service.DataBaseConnectionService;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright@http://github.com/guogewudi
 * Author:国宇航
 * Date:2019/9/6
 * Description:
 */
@Service
public class DataBaseConnectionServiceImpl implements DataBaseConnectionService {

    /**
     * 获得connection对象的函数
     *
     * @param driver_name
     * @param connection_name
     * @param database_username
     * @param database_password
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public Connection getConnection(String driver_name,String connection_name,
                                    String database_username, String database_password) throws ClassNotFoundException, SQLException {


       Class.forName(driver_name);
       Connection connection = DriverManager.getConnection( connection_name, database_username,
               database_password);
       System.out.println("获得了connection对象");
       return connection;
       }

    /**
     * 查询所有表名的函数
     * @param driver_name
     * @param connection_name
     * @param database_username
     * @param database_password
     * @return
     * @throws Exception
     */
    public List<String> searchTableNames(String driver_name,String connection_name,
                                         String database_username, String database_password) throws Exception
    {

      Connection connection = this.getConnection(driver_name,connection_name,
               database_username,database_password);
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
