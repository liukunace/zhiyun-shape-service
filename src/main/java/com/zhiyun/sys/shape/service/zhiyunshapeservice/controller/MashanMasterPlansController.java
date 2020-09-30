package com.zhiyun.sys.shape.service.zhiyunshapeservice.controller;

import com.bedatadriven.jackson.datatype.jts.JtsModule;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.zhiyun.sys.shape.service.zhiyunshapeservice.bean.BufferEntity;
import com.zhiyun.sys.shape.service.zhiyunshapeservice.bean.FeatureEntity;
import com.zhiyun.sys.shape.service.zhiyunshapeservice.bean.MashanMasterPlansEntity;
import com.zhiyun.sys.shape.service.zhiyunshapeservice.bean.PoliLandusingPolygonEntity;
import com.zhiyun.sys.shape.service.zhiyunshapeservice.service.MashanMasterPlansServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: lewk
 * @Date: 20-6-10 16:00
 * @Description: poli土地利用空间操作controller层
 */

@RestController
@RequestMapping("/mas")
public class MashanMasterPlansController {

    @Autowired
    MashanMasterPlansServiceImpl mashanMasterPlansService;

    /**
     * @point 点坐标参数（经度 纬度）：point=119.7819065 35.728267
     * @Description: 空间服务-泊里土地利用点选空间查询
     */
    @RequestMapping(path="/plans/point",method=RequestMethod.GET)
    public List<MashanMasterPlansEntity> searchPolygonByPolyWithGeo(@RequestParam(name = "point") String point){
        String preStr="POINT(";
        String postStr=")";
        point=preStr+point;
        point+=postStr;
        return  mashanMasterPlansService.searchPolyByPointWithGeo(point);
    }

    @RequestMapping(path="/plans/poly",method= RequestMethod.GET)
    public List<MashanMasterPlansEntity> searchPolygonByPoly(@RequestParam(name = "polygon") String polygon){
        //@RequestParam(name = "polygon") String polygon
        String preStr="Polygon((";
        String postStr="))";
        //String polygon="";
        polygon=preStr+polygon;
        //polygon+="119.76516776128855  35.70848781212183, 119.76628775337608 35.70855030720652,119.76632897357398  35.70837193127791,119.76545524646697  35.70832317877496,119.76541572524881 35.70832097340617,119.76517157641932 35.70846558075502,119.76516776128855 35.70848781212183";
        polygon+=postStr;

        return  mashanMasterPlansService.searchPolyByPolyWithGeo(polygon);
    }

    /**
     * @polygon 缓冲区geometry坐标串，首尾闭合
     * @distance 缓冲区距离，单位米
     * @Description: 空间服务-缓冲区生成
     */
    @RequestMapping(path="/plans/circle",method=RequestMethod.GET)
    public List<MashanMasterPlansEntity> bufferPolygon(
            @RequestParam(name = "point") String point,
            @RequestParam(name = "distance") double distance
    )  {
        String[] pointArray=point.split(" ");
        Coordinate coordinates=new Coordinate(Double.valueOf(pointArray[0]), Double.valueOf(pointArray[1]));
        GeometryFactory gf=new GeometryFactory();
        Geometry g1 = gf.createPoint(coordinates);
        double degree = distance / (2 * Math.PI * 6371004) * 360;

        Geometry g1buffer=g1.buffer(degree);
        //System.out.println(g1buffer.toString());
        String polygon=g1buffer.toString();

        return  mashanMasterPlansService.searchPolyByPolyWithGeo(polygon);

    }
    //String wktPoint = "POINT(103.83489981581 33.462715497945)";
    //String wktPoint = "POINT(103.83489981581 33.462715497945)";
    //String wktLine = "LINESTRING(108.32803893589 41.306670233001,99.950999898452 25.84722546391)";
    //String wktPolygon = "POLYGON((100.02715479879 32.168082192159,102.76873121104 37.194305614622,107.0334056301 34.909658604412,105.96723702534 30.949603786713,100.02715479879 32.168082192159))";
    //String wktPolygon1 = "POLYGON((96.219409781775 32.777321394882,96.219409781775 40.240501628236,104.82491352023001 40.240501628236,104.82491352023001 32.777321394882,96.219409781775 32.777321394882))";

}
