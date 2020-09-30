package com.zhiyun.sys.shape.service.zhiyunshapeservice.service;

import com.zhiyun.sys.shape.service.zhiyunshapeservice.bean.PoliLandusingPolygonEntity;
import com.zhiyun.sys.shape.service.zhiyunshapeservice.repository.PoliLandusingPolygonDtoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: lewk
 * @Date: 20-5-6 9:30
 * @Description: 泊里土地利用空间检索服务层
 */
@Service

public class PoliLandusingPolygonServiceImpl {


    @Autowired
    private PoliLandusingPolygonDtoRepository poliLandusingPolygonDtoRepository;

    public List<PoliLandusingPolygonEntity> searchPolyByPointWithGeo(String pointStr){
        return poliLandusingPolygonDtoRepository.searchPolyByPointWithGeo(pointStr);
    }

    public List<PoliLandusingPolygonEntity> searchPolyByPointWithGeo2(String pointStr){
        return poliLandusingPolygonDtoRepository.searchPolyByPointWithGeo2(pointStr);
    }

    public List<PoliLandusingPolygonEntity> searchPolyByPointWithGeo3(String pointStr){
        return poliLandusingPolygonDtoRepository.searchPolyByPointWithGeo3(pointStr);
    }

    public List<PoliLandusingPolygonEntity> searchPolyByPointWithGeo4(String pointStr){
        return poliLandusingPolygonDtoRepository.searchPolyByPointWithGeo4(pointStr);
    }
}
