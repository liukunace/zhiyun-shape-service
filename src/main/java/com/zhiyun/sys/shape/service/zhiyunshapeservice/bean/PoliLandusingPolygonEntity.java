package com.zhiyun.sys.shape.service.zhiyunshapeservice.bean;


import com.vividsolutions.jts.geom.MultiPolygon;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "poli_landusing_polygon_20200430")
public class PoliLandusingPolygonEntity {

    private long fid;
    private String ysdm;
    private String tbbh;
    private String ghdlmc;
    private String xzqdm;
    private String sm;
    private String color;
    private MultiPolygon polygon;
    private double bsm;
    private double ghdlmj;



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
    @Column(name = "YSDM")
    public String getYsdm() {
        return ysdm;
    }

    public void setYsdm(String ysdm) {
        this.ysdm = ysdm;
    }

    @Basic
    @Column(name = "TBBH")
    public String getTbbh() {
        return tbbh;
    }

    public void setTbbh(String tbbh) {
        this.tbbh = tbbh;
    }

    @Basic
    @Column(name = "GHDLMC")
    public String getGhdlmc() {
        return ghdlmc;
    }

    public void setGhdlmc(String ghdlmc) {
        this.ghdlmc = ghdlmc;
    }

    @Basic
    @Column(name = "XZQDM")
    public String getXzqdm() {
        return xzqdm;
    }

    public void setXzqdm(String xzqdm) {
        this.xzqdm = xzqdm;
    }

    @Basic
    @Column(name = "SM")
    public String getSm() {
        return sm;
    }

    public void setSm(String sm) {
        this.sm = sm;
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
    @Column(name = "BSM")
    public double getBsm() {
        return bsm;
    }

    public void setBsm(double bsm) {
        this.bsm = bsm;
    }

    @Basic
    @Column(name = "GHDLMJ")
    public double getGhdlmj() {
        return ghdlmj;
    }

    public void setGhdlmj(double ghdlmj) {
        this.ghdlmj = ghdlmj;
    }

}
