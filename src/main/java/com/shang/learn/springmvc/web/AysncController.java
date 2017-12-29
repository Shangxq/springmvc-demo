package com.shang.learn.springmvc.web;

import com.shang.learn.springmvc.service.PushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

@RestController
public class AysncController {
    @Autowired
    PushService service;
    @RequestMapping("/defer")
    public DeferredResult<String> deferredCall(){
        return service.getDeferredResult();
    }
}
