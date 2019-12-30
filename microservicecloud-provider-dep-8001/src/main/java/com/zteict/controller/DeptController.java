package com.zteict.controller;

import com.zteict.entity.Dept;
import com.zteict.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;
    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("/dept/add")
    public @ResponseBody boolean add(){
        Dept dept=new Dept().setDname(new Date().toString()).setDb_source("clouddb01");
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

    @GetMapping("/dept/discovery")
    public @ResponseBody DiscoveryClient discovery(){
        List<String> list=discoveryClient.getServices();
        System.out.println("********"+list);
        List<ServiceInstance> serList=discoveryClient.getInstances("MICROSERVICECLOUD-DEPT");
        for (ServiceInstance element:serList
             ) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri());

        }
        return this.discoveryClient;
    }
}
