package com.adc.databaseConnection.service;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Copyright@http://github.com/guogewudi
 * Author:国宇航
 * Date:2019/9/10
 * Description:
 */
public interface GetTableNameService {
    public List<String> searchTableNames(HttpSession session) throws Exception;
}
