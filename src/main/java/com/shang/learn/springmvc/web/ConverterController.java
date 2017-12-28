package com.shang.learn.springmvc.web;

import com.shang.learn.springmvc.domain.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ConverterController {
    @RequestMapping(value = "/convert",produces = {"application/x-shang"})
    public @ResponseBody
    DemoObj convert(@RequestBody DemoObj demoObj){
        return demoObj;
    }
}
