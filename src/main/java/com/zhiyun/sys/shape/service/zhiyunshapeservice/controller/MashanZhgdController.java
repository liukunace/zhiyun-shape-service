package com.zhiyun.sys.shape.service.zhiyunshapeservice.controller;

import com.bedatadriven.jackson.datatype.jts.JtsModule;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhiyun.sys.shape.service.zhiyunshapeservice.bean.MashanZhgdEntity;
import com.zhiyun.sys.shape.service.zhiyunshapeservice.bean.PointEntity;
import com.zhiyun.sys.shape.service.zhiyunshapeservice.repository.PointRepository;
import com.zhiyun.sys.shape.service.zhiyunshapeservice.service.MashanZhgdServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/zhgd")
public class MashanZhgdController {

    @Autowired
    MashanZhgdServcie mashanZhgdServcie;

    @RequestMapping(path="/point",method= RequestMethod.GET)
    public int findall(@RequestParam(name = "point") String point){

        String preStr="POINT(";
        String postStr=")";
        point=preStr+point;
        point+=postStr;

        List<MashanZhgdEntity> ls=mashanZhgdServcie.findByPoint(point);
        int size=ls.size();
        return size;
    }
}
