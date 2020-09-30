package com.zhiyun.sys.shape.service.zhiyunshapeservice;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


//@SpringBootApplication
//@EnableDiscoveryClient
//@EnableJpaAuditing
public class ServerApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ServerApplication.class);
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(ServerApplication.class).web(WebApplicationType.SERVLET).run(args);
    }

}
