package com.example.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.entity.Cv000001;
import com.example.mapper.standard.Cv000001Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 *
 * @author Bean
 * @since 2019-11-20
 */
@Controller
@RequestMapping("/cv000001")
public class Cv000001Controller {

    @Autowired
    Cv000001Mapper cv000001Mapper;

    @RequestMapping("/getList")
    @ResponseBody
    public List<Cv000001> getList(){
        QueryWrapper<Cv000001> wrapper = new QueryWrapper<>();
        List<Cv000001> list = cv000001Mapper.selectList(wrapper);
        return list;
    }
}

