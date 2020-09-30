package com.zhiyun.sys.shape.service.zhiyunshapeservice.bean;

import com.vividsolutions.jts.geom.Geometry;

import java.util.ArrayList;

public class BufferEntity {

    private  String  type ;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private ArrayList<FeatureEntity> features;

    public ArrayList<FeatureEntity> getFeatures() {
        return features;
    }

    public void setFeatures(ArrayList<FeatureEntity> features) {
        this.features = features;
    }
}
