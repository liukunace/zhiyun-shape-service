package com.zhiyun.sys.shape.service.zhiyunshapeservice.service;

import com.zhiyun.sys.shape.service.zhiyunshapeservice.bean.MashanMasterPlansEntity;
import com.zhiyun.sys.shape.service.zhiyunshapeservice.repository.MashanMasterPlansRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: lewk
 * @Date: 20-6-10 16:30
 * @Description: 马山土地利用空间检索服务层
 */
@Service
public class MashanMasterPlansServiceImpl {
    @Autowired
    private MashanMasterPlansRepository mashanMasterPlansRepository;

    public List<MashanMasterPlansEntity> searchPolyByPolyWithGeo(String pointStr){
        return mashanMasterPlansRepository.searchPolyByPolyWithGeo(pointStr);
    }

    public List<MashanMasterPlansEntity> searchPolyByPointWithGeo(String pointStr){
        return mashanMasterPlansRepository.searchPolyByPointWithGeo2(pointStr);
    }
}
