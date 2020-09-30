package com.zhiyun.sys.shape.service.zhiyunshapeservice.bean;


import com.vividsolutions.jts.geom.MultiPolygon;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "poli_land_current_polygon_20200506")
public class PoliLandusingPolygonEntity2 {

    private long fid;

    private MultiPolygon polygon;

    private String  tbbh;

    private String  dlbm;

    private String qsxz;

    private String qsdwmc;

    private String zldwmc;

    private String  gdlx;

    private String tbmj;

    private double tbdlmj;

    private String dlbj;

    private String pzwh;

    private String bgrq;

    private double shapeArea;

    private String dlmc;

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
    @Column(name = "TBBH")
    public String getTbbh() {
        return tbbh;
    }

    public void setTbbh(String tbbh) {
        this.tbbh = tbbh;
    }


    @Column(name="the_geom",columnDefinition = "geometry(MultiPolygon,4490)")
    @Type(type = "jts_geometry")
    public MultiPolygon getPolygon() {
        return polygon;
    }

    public void setPolygon(MultiPolygon polygon) {
        this.polygon = polygon;
    }

    public String getDlbm() {
        return dlbm;
    }

    public void setDlbm(String dlbm) {
        this.dlbm = dlbm;
    }

    public String getQsxz() {
        return qsxz;
    }

    public void setQsxz(String qsxz) {
        this.qsxz = qsxz;
    }

    public String getQsdwmc() {
        return qsdwmc;
    }

    public void setQsdwmc(String qsdwmc) {
        this.qsdwmc = qsdwmc;
    }

    public String getZldwmc() {
        return zldwmc;
    }

    public void setZldwmc(String zldwmc) {
        this.zldwmc = zldwmc;
    }

    public String getGdlx() {
        return gdlx;
    }

    public void setGdlx(String gdlx) {
        this.gdlx = gdlx;
    }

    public String getTbmj() {
        return tbmj;
    }

    public void setTbmj(String tbmj) {
        this.tbmj = tbmj;
    }

    public double getTbdlmj() {
        return tbdlmj;
    }

    public void setTbdlmj(double tbdlmj) {
        this.tbdlmj = tbdlmj;
    }

    public String getDlbj() {
        return dlbj;
    }

    public void setDlbj(String dlbj) {
        this.dlbj = dlbj;
    }

    public String getPzwh() {
        return pzwh;
    }

    public void setPzwh(String pzwh) {
        this.pzwh = pzwh;
    }

    public String getBgrq() {
        return bgrq;
    }

    public void setBgrq(String bgrq) {
        this.bgrq = bgrq;
    }

    public double getShapeArea() {
        return shapeArea;
    }

    public void setShapeArea(double shapeArea) {
        this.shapeArea = shapeArea;
    }

    public String getDlmc() {
        return dlmc;
    }

    public void setDlmc(String dlmc) {
        this.dlmc = dlmc;
    }



}
