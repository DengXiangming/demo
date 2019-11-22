package com.example.conf;

import com.alibaba.druid.pool.DruidDataSource;

import javax.sql.DataSource;

public class DataSourceBuild {
    public static DataSource build(DataSourceProperties dataSourceProperties) {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(dataSourceProperties.getDriverClassName());
        druidDataSource.setUrl(dataSourceProperties.getUrl());
        druidDataSource.setName(dataSourceProperties.getName());
        druidDataSource.setUsername(dataSourceProperties.getUsername());
        druidDataSource.setPassword(dataSourceProperties.getPassword());
        druidDataSource.setMaxActive(15);
        return druidDataSource;
    }
}
