package com.adc.databaseConnection.utils;

/**
 * Copyright@http://github.com/guogewudi
 * Author:国宇航
 * Date:2019/9/5
 * Description:
 */
public class GetDataBaseTypeUtils {
    public static String getDriverClass(String type){
        if(type.equalsIgnoreCase("mysql")){
            return "com.mysql.jdbc.Driver";
        }
        if(type.equalsIgnoreCase("oracle")){
            return "com.oracle.jdbc.Driver";
        }
        if(type.equalsIgnoreCase("mongodb")){
            return "com.mongodb.jdbc.Driver";
        }
        return null;
    }
}
