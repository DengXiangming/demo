package com.example.conf;

import org.springframework.beans.factory.annotation.Value;

public class DataSourceProperties {
    String name;
    String url;
    String username;
    String password;
    String driverClassName;


    public String getName() {
        return name;
    }

    @Value("name")
    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    @Value("url")
    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    @Value("username")
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    @Value("password")
    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    @Value("driver-class-name")
    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    @Override
    public String toString() {
        return "DataSourceProperties{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", driverClassName='" + driverClassName + '\'' +
                '}';
    }
}
