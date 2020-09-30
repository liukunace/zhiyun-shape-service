package com.zhiyun.sys.shape.service.zhiyunshapeservice.bean;

import com.vividsolutions.jts.geom.MultiPolygon;
import org.hibernate.annotations.Type;

import javax.persistence.*;

//mashan_masterplans
@Entity
@Table(name = "mashan_masterplans")
public class MashanMasterPlansEntity {

    private long fid;

    private String color;

    private MultiPolygon polygon;

    private double area;

    @Id
    @Column(name = "fid", nullable = false)
    @GeneratedValue
    public long getFid() {
        return fid;
    }

    public void setFid(long fid) {
        this.fid = fid;
    }

    @Basic
    @Column(name = "color")
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Column(name="the_geom",columnDefinition = "geometry(MultiPolygon,4490)")
    @Type(type = "jts_geometry")
    public MultiPolygon getPolygon() {
        return polygon;
    }

    public void setPolygon(MultiPolygon polygon) {
        this.polygon = polygon;
    }

    @Basic
    @Column(name = "area")
    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

}
