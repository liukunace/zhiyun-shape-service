package com.zhiyun.sys.shape.service.zhiyunshapeservice.service;

import com.zhiyun.sys.shape.service.zhiyunshapeservice.bean.PolygonDtoEntity;
import com.zhiyun.sys.shape.service.zhiyunshapeservice.bean.PolygonEntity;
import com.zhiyun.sys.shape.service.zhiyunshapeservice.repository.PoliLandusingPolygonDtoRepository;
import com.zhiyun.sys.shape.service.zhiyunshapeservice.repository.PolygonDtoRepository;
import com.zhiyun.sys.shape.service.zhiyunshapeservice.repository.PolygonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: lewk
 * @Date: 20-3-23 17:00
 * @Description: 空间检索服务层
 */
@Service
public class PolygonServiceImpl {
    @Autowired
    private PolygonRepository polygonRepository;

    @Autowired
    private PolygonDtoRepository polygonDtoRepository;

    @Autowired
    private PoliLandusingPolygonDtoRepository poliLandusingPolygonDtoRepository;


    /**
     * @project 所属项目

     * @Description: 分页视频对象
     */
    public List<PolygonEntity> searchPolygon(){
        List<PolygonEntity> list=polygonRepository.searchPoly2();
        return list;
    }

    //查找
     public List<PolygonEntity> list(){
               return polygonRepository.findAll();
     }


    public List<PolygonEntity> searchPolyByPoly(String str){
        return polygonRepository.searchPolyByPoly(str);
    }


    public List<PolygonEntity> searchPolyByPolyWith(String str){
        return polygonRepository.searchPolyByPolyWith(str);
    }

    public List<PolygonDtoEntity> searchPolyByPolyWithGeo(String str){
        return polygonDtoRepository.searchPolyByPolyWithGeo(str);
    }
}
