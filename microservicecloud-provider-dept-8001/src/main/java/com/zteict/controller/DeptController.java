package com.zteict.controller;

import com.zteict.entity.Dept;
import com.zteict.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @PostMapping("/dept/add")
    public @ResponseBody boolean add(){
        Dept dept=new Dept().setDname("美女部").setDb_source("clouddb01");
        return deptService.add(dept);
    }

    @GetMapping("/dept/get/{id}")
    public @ResponseBody Dept get(@PathVariable("id") Long id){
        return deptService.get(id);
    }

    @GetMapping("/dept/list")
    public @ResponseBody List<Dept> list(){
        return deptService.list();
    }
}
