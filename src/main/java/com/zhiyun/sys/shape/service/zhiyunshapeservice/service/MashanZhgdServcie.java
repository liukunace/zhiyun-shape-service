package com.zhiyun.sys.shape.service.zhiyunshapeservice.service;

import com.zhiyun.sys.shape.service.zhiyunshapeservice.bean.MashanZhgdEntity;
import com.zhiyun.sys.shape.service.zhiyunshapeservice.bean.PoliLandusingPolygonEntity;
import com.zhiyun.sys.shape.service.zhiyunshapeservice.repository.MashanZhgdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: liukun
 * @create: 2020-08-04 21:44
 */
@Service
public class MashanZhgdServcie {
    @Autowired
    private MashanZhgdRepository mashanZhgdRepository;

    public List<MashanZhgdEntity> findByPoint(String pointStr){
        return mashanZhgdRepository.findByPoint(pointStr);
    }
}
