package com.zhiyun.sys.shape.service.zhiyunshapeservice.mapper;

import com.bedatadriven.jackson.datatype.jts.JtsModule;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfig {

    @Bean
    JtsModule jtsModule() {
        return new JtsModule();
    }

//    @Bean
//    public ObjectMapper objectMapper(){
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper().registerModule(new JtsModule());
//        return objectMapper;
//
//    }

}
