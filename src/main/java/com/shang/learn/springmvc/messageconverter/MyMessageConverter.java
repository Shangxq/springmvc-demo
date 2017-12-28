package com.shang.learn.springmvc.messageconverter;

import com.shang.learn.springmvc.domain.DemoObj;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;

public class MyMessageConverter extends AbstractHttpMessageConverter<DemoObj> {

    public MyMessageConverter(){
        super(new MediaType("application","x-shang", Charset.forName("UTF-8")));
    }

    @Override
    protected boolean supports(final Class<?> clazz) {
        return DemoObj.class.isAssignableFrom(clazz);
    }

    //请求中解析对象
    @Override
    protected DemoObj readInternal(final Class<? extends DemoObj> clazz, final HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        String string= StreamUtils.copyToString(inputMessage.getBody(),Charset.forName("UTF-8"));
        String []arr=string.split("-");
        return new DemoObj(new Long(arr[0]),arr[1]);
    }

    //将对象封装成产品
    @Override
    protected void writeInternal(final DemoObj demoObj, final HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        String out="hello:"+demoObj.getId()+"-"+demoObj.getName();
        outputMessage.getBody().write(out.getBytes());
    }
}
