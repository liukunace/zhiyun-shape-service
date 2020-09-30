package com.zhiyun.sys.shape.service.zhiyunshapeservice.controller;


import com.zhiyun.sys.shape.service.zhiyunshapeservice.bean.PoliLandusingPolygonEntity;
import com.zhiyun.sys.shape.service.zhiyunshapeservice.service.PoliLandusingPolygonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: lewk
 * @Date: 20-5-6 10:00
 * @Description: poli土地利用空间操作controller层
 */

@RestController
@RequestMapping("/poli")
public class PoliLandusingController {

    @Autowired
    PoliLandusingPolygonServiceImpl poliLandusingPolygonServiceImpl;

    /**
     * @point 点坐标参数（经度 纬度）：point=119.7819065 35.728267
     * @Description: 空间服务-泊里土地利用点选空间查询
     */
    @RequestMapping(path="/land/search",method=RequestMethod.GET)
    public List<PoliLandusingPolygonEntity> searchPolygonByPolyWithGeo(@RequestParam(name = "point") String point,
                                                                       @RequestParam(name = "typeId") String typeId){
        String preStr="POINT(";
        String postStr=")";
        point=preStr+point;
        point+=postStr;
        if(typeId.equals("PL-1")){
            return  poliLandusingPolygonServiceImpl.searchPolyByPointWithGeo(point);
        }else if(typeId.equals("PL-2")){
            return  poliLandusingPolygonServiceImpl.searchPolyByPointWithGeo2(point);
        }else if(typeId.equals("PL-3")){
            return  poliLandusingPolygonServiceImpl.searchPolyByPointWithGeo3(point);
        }else if(typeId.equals("PL-4")){
            return  poliLandusingPolygonServiceImpl.searchPolyByPointWithGeo4(point);
        }else {
            return  poliLandusingPolygonServiceImpl.searchPolyByPointWithGeo(point);
        }
    }
}
