package com.zteict.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author Yangpeng
 */
@Data
@NoArgsConstructor
@Accessors(chain=true)

public class Dept implements Serializable {
    private Long  deptno;
    private String  dname;
    /**
     *  来自那个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同数据库
     */
    private String  db_source;

    public Dept(String dname) {
        this.dname = dname;
    }

    public static void main(String[] args){
        Dept d=new Dept();
        d.setDname("张三").setDeptno(Long.valueOf("18"));
        System.out.println(d.toString());
    }
}
