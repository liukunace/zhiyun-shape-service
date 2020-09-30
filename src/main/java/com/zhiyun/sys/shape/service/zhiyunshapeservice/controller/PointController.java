package com.zhiyun.sys.shape.service.zhiyunshapeservice.controller;

import com.bedatadriven.jackson.datatype.jts.JtsModule;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhiyun.sys.shape.service.zhiyunshapeservice.bean.PointEntity;
import com.zhiyun.sys.shape.service.zhiyunshapeservice.repository.PointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/poi")
public class PointController {

    @Autowired
    PointRepository cityRepository;

    @RequestMapping(path="/add",method= RequestMethod.POST)
    public PointEntity testIn(@RequestBody PointEntity city) throws Exception {
        System.out.println(city.getPoint() + "/" + city.getPoint().getX() + "/" +city.getPoint().getY());
        //city.getPoint().setSRID(4326);//设置空间参考时需要独立设置坐标参考
        PointEntity pe=city;
        //point属性已获取，除坐标外，添加JsonBackReference无法以geojson形式返回到前端json
        System.out.println(pe.getPoint());
        System.out.println("----------------------------------------------------------------------------------");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModules(new JtsModule());
        String json =objectMapper.writeValueAsString(pe);
        System.out.println(json);
        return cityRepository.save(city);
    }

    @RequestMapping(path="/find",method= RequestMethod.GET)
    public List<PointEntity> findall(){
        //System.out.println(city.getPoint() + "/" + city.getPoint().getX() + "/" +city.getPoint().getY());
        List<PointEntity> ls=cityRepository.findAll();
        PointEntity pe=ls.get(0);
        System.out.println(pe.getPoint().getX()+"1111111111111111111111111");
        int sss=pe.getPoint().getSRID();
        System.out.println("坐标参考  ："+sss);
        return ls;
    }
}
