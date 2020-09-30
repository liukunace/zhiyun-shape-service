package com.zhiyun.sys.shape.service.zhiyunshapeservice.controller;

import com.bedatadriven.jackson.datatype.jts.JtsModule;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.zhiyun.sys.shape.service.zhiyunshapeservice.bean.BufferEntity;
import com.zhiyun.sys.shape.service.zhiyunshapeservice.bean.FeatureEntity;
import com.zhiyun.sys.shape.service.zhiyunshapeservice.bean.PolygonDtoEntity;
import com.zhiyun.sys.shape.service.zhiyunshapeservice.bean.PolygonEntity;
import com.zhiyun.sys.shape.service.zhiyunshapeservice.service.PolygonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


/**
 * @Auther: lewk
 * @Date: 20-4-11 17:39
 * @Description: 控制器 video增删改查
 */
@RestController
@RefreshScope
@CrossOrigin
public class PolygonController {
    @Autowired
    private PolygonServiceImpl polygonServiceImpl;


    @GetMapping("test")
    public String getEnvName2(){
        return "haha1111111";
    }

    @RequestMapping("/list")
    public List<PolygonEntity> searchPolygon(){
        return polygonServiceImpl.searchPolygon();
    }

    @RequestMapping(path="/search",method=RequestMethod.GET)
    public List<PolygonEntity> searchVideoPagedInformation( ){
        return  polygonServiceImpl.searchPolygon();
    }

    //searchPolyByPoly

    /**
     * mashan_planning_polygon_202004 a where ST_intersects
     * @param polygon
     * @return
     */
    @RequestMapping(path="/poly",method=RequestMethod.GET)
    public List<PolygonEntity> searchPolygonByPoly(@RequestParam(name = "polygon") String polygon){
        //@RequestParam(name = "polygon") String polygon
        String preStr="Polygon((";
        String postStr="))";
        //String polygon="";
        polygon=preStr+polygon;
        //polygon+="119.76516776128855  35.70848781212183, 119.76628775337608 35.70855030720652,119.76632897357398  35.70837193127791,119.76545524646697  35.70832317877496,119.76541572524881 35.70832097340617,119.76517157641932 35.70846558075502,119.76516776128855 35.70848781212183";
        polygon+=postStr;

        return  polygonServiceImpl.searchPolyByPoly(polygon);
    }


    /**
     * mashan_planning_polygon_202004 a where ST_within
     * @param polygon
     * @return
     */
    @RequestMapping(path="/poly-in",method=RequestMethod.GET)
    public List<PolygonEntity> searchPolygonByPolyWith(@RequestParam(name = "polygon") String polygon){
        String preStr="Polygon((";
        String postStr="))";
        polygon=preStr+polygon;
        polygon+=postStr;
        return  polygonServiceImpl.searchPolyByPolyWith(polygon);
    }

    /**
     * mashan_planning_polygon_202004 a where ST_within
     * @param polygon
     * @return
     */
    @RequestMapping(path="/polygon-in",method=RequestMethod.GET)
    public List<PolygonDtoEntity> searchPolygonByPolyWithGeo(@RequestParam(name = "polygon") String polygon){
        String preStr="Polygon((";
        String postStr="))";
        polygon=preStr+polygon;
        polygon+=postStr;
        return  polygonServiceImpl.searchPolyByPolyWithGeo(polygon);
    }

    /**
     * @polygon 缓冲区geometry坐标串，首尾闭合
     * @distance 缓冲区距离，单位米
     * @Description: 空间服务-缓冲区生成
     */
    @RequestMapping(path="/buffer/poly",method=RequestMethod.GET)
    public BufferEntity bufferPolygon(
            @RequestParam(name = "polygon") String polygon,
            @RequestParam(name = "distance") double distance
    ) throws JsonProcessingException {
        //polygon="119.76516776128855 35.70848781212183,119.76628775337608 35.70855030720652,119.76632897357398 35.70837193127791,119.76545524646697 35.70832317877496,119.76541572524881 35.70832097340617,119.76517157641932 35.70846558075502,119.76516776128855 35.70848781212183";
        String preStr="Polygon((";
        String postStr="))";
        //polygon=preStr+polygon;
       // polygon+=postStr;

        /*
        Coordinate[] coordinates1 = new Coordinate[] {
                new Coordinate(0, 0),
                new Coordinate(0, 1),
                new Coordinate(1, 2),
                new Coordinate(2, 1),
                new Coordinate(2, 0),
                new Coordinate(0, 0), };
       // coordinates1[0]=new Coordinate(0, 0);

         */
        String[] polyArray=polygon.split(",");
        Coordinate[]coordinates1 = new Coordinate[polyArray.length];

        for (int i=0;i<polyArray.length;i++){
            String[] pointArray=polyArray[i].split(" ");
            coordinates1[i]=new Coordinate(Double.valueOf(pointArray[0]), Double.valueOf(pointArray[1]));
        }

        GeometryFactory gf=new GeometryFactory();
        //gf.
        Geometry g1 = gf.createPolygon(coordinates1);

        double degree = distance / (2 * Math.PI * 6371004) * 360;

        System.out.println(degree);

        Geometry g1buffer=g1.buffer(degree);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModules(new JtsModule());
        //objectMapper.writeValueAsString(pe);

        FeatureEntity fe=new FeatureEntity();
        fe.setGeometry(g1buffer);
        fe.setType("Feature");

        ArrayList<FeatureEntity> af=new ArrayList<FeatureEntity>();
        af.add(fe);

        BufferEntity be=new BufferEntity();
        be.setFeatures(af);
        be.setType("FeatureCollection");


        String json =objectMapper.writeValueAsString(be);
        //System.out.println(json);

        //.out.println(g1buffer);

        /*
        {"type":"Feature",
            "properties":{},
            "geometry":{
            "type":"Polygon",
                    "coordinates":[
                        [
                          [106.10595703125,33.33970700424026],
                          [106.32568359375,32.41706632846282],
                          [108.03955078125,32.2313896627376],
                          [108.25927734375,33.15594830078649],
                          [106.10595703125,33.33970700424026]
                        ]
                      ]
        }
        }

         */
        return be;
    }
}
