package com.zhiyun.sys.shape.service.zhiyunshapeservice.bean;

import com.vividsolutions.jts.geom.Geometry;

public class FeatureEntity {

    private  String  type ;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private Geometry geometry;

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }
}
