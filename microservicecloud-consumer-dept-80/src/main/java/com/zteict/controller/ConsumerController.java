package com.zteict.controller;

import com.zteict.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ConsumerController {

    private static final String URL_PRIFIX="http://localhost:8001/";

    @Autowired
    private RestTemplate restTemplate;
    @RequestMapping("/consumer/add")
    public boolean add(){
        Dept dept=new Dept().setDname("环保部");
        return restTemplate.postForObject(URL_PRIFIX + "/dept/add", dept, Boolean.class);
    }

    @RequestMapping("/consumer/get/{id}")
    public Dept get(@PathVariable Long id){
        return restTemplate.getForObject(URL_PRIFIX+"/dept/get/"+id,Dept.class);
    }

    @GetMapping("/consumer/list")
    public List<Dept> list(){
        return restTemplate.getForObject(URL_PRIFIX+"/dept/list",List.class);
    }
}
