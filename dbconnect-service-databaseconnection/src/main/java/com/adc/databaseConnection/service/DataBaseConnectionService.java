package com.adc.databaseConnection.service;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Copyright@http://github.com/guogewudi
 * Author:国宇航
 * Date:2019/9/6
 * Description:
 */

public interface DataBaseConnectionService {
    public Connection getConnection(String driver_name, String connection_name,
                                    String database_username, String database_password) throws ClassNotFoundException, SQLException;
}
