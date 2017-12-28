package com.shang.learn.springmvc.web;

import com.shang.learn.springmvc.domain.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdviceController {
    @RequestMapping("/advice")
    public String getSomething(@ModelAttribute("msg")String msg, DemoObj obj){
        if(obj.getId()==null){
            throw new IllegalArgumentException("参数有误" + msg+"，obj name："+obj.getName());
        }
        return msg;
    }
}
