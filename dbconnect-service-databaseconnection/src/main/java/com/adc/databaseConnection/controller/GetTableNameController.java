package com.adc.databaseConnection.controller;

/**
 * Copyright@http://github.com/guogewudi
 * Author:国宇航
 * Date:2019/9/10
 * Description:
 */

import com.adc.common.vo.R;
import com.adc.databaseConnection.service.impl.GetTableNameServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * List<String> tableNames =dataBaseConnectionService.searchTableNames(driver_name, connection_name, database_username, database_password);
 map.put("tablename",tableNames);
 */
@RestController
public class GetTableNameController {
    @Autowired
    GetTableNameServiceImpl getTableNameService;


    @PostMapping("/getTableName")
    @ApiOperation(value = "查询该数据库所有表名")
    public R  getTableName(HttpSession session) throws Exception {
        //从session获取了list
        List<String> tableNames = getTableNameService.searchTableNames(session);
        return R.ok().data("tableNames",tableNames);

    }
}
