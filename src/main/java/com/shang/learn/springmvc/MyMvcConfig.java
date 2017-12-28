package com.shang.learn.springmvc;

import com.shang.learn.springmvc.interceptor.DemoInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan
public class MyMvcConfig extends WebMvcConfigurerAdapter {
    //视图解析器
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/classes/views/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }

    //文件解析器
    @Bean
    public MultipartResolver multipartResolver(){
        CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(1000000);
        multipartResolver.setDefaultEncoding("UTF-8");
        multipartResolver.setResolveLazily(true);
        return multipartResolver;
    }

    //自定义拦截器
    @Bean
    public DemoInterceptor demoInterceptor() {
        return new DemoInterceptor();
    }

    //配置静态文件位置
    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
    }

    //配置拦截器
    @Override
    public void addInterceptors(final InterceptorRegistry registry) {
        registry.addInterceptor(demoInterceptor());
    }

    //绑定path和view
    @Override
    public void addViewControllers(final ViewControllerRegistry registry) {
        registry.addViewController("/configIndex").setViewName("/index");
        registry.addViewController("/toUpload").setViewName("/upload");
    }

    //默认忽略后缀名，通过此配置开启匹配后缀名
    @Override
    public void configurePathMatch(final PathMatchConfigurer configurer) {
        configurer.setUseSuffixPatternMatch(false);
    }
}
