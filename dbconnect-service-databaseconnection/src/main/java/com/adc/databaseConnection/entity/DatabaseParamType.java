package com.adc.databaseConnection.entity;

import lombok.Data;
import lombok.Getter;

import java.io.Serializable;

/**
 * Copyright@http://github.com/guogewudi
 * Author:国宇航
 * Date:2019/9/5
 * Description:
 */

@Data
@Getter
public class DatabaseParamType implements Serializable {
    private String dataBaseType;

    private String connection_name;
    private String database_username;
    private String database_password;


}
