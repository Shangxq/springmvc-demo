package com.shang.learn.springmvc.helloworld.web;

import com.shang.learn.springmvc.helloworld.domain.DemoObj;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class DemoRestController {
    @RequestMapping(value = "/getjson",produces = {"application/json;charset=UTF-8"})
    public DemoObj getJson(DemoObj obj){
        return new DemoObj(obj.getId()+1,obj.getName()+"shang");
    }
    @RequestMapping(value="/getxml",produces = {"application/xml;charset=UTF-8"})
    public DemoObj getXml(DemoObj obj){
        return new DemoObj(obj.getId()+10,obj.getName()+"xiao");
    }
}
