package com.shang.learn.springmvc.web;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Map;

@Controller
public class UploadController {
    @Autowired
    MultipartResolver resolver;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody
    String upload(HttpServletRequest request) {
        MultipartHttpServletRequest multipartHttpServletRequest = this.resolver.resolveMultipart(request);
        Map<String, MultipartFile> fileMap = multipartHttpServletRequest.getFileMap();
        System.out.println(fileMap.isEmpty());
        fileMap.forEach((key, file) -> {
            try {
                System.out.println(key);
                FileUtils.writeByteArrayToFile(new File("/home/sxq/learnspring" + File.separator + file.getOriginalFilename()), file.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        return "success";

    }
}
