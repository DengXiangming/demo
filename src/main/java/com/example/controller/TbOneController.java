package com.example.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.entity.TbOne;
import com.example.mapper.select.TbOneMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Bean
 * @since 2019-11-20
 */
@Controller
@RequestMapping("/tbOne")
public class TbOneController {

    @Autowired
    TbOneMapper tbOneMapper;

    @RequestMapping("/getList")
    @ResponseBody
    public List<TbOne> getList(){
        QueryWrapper<TbOne> wrapper = new QueryWrapper<>();
        List<TbOne> list = tbOneMapper.selectList(wrapper);
        return list;
    }

    @RequestMapping("/test")
    @ResponseBody
    public String getTest(){
        return "6666666666";
    }
}

