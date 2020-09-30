package com.zhiyun.sys.shape.service.zhiyunshapeservice.bean;


import javax.persistence.*;

@Entity
@Table(name = "mashan_planning_polygon_test1")
public class PolygonEntity {

    private String xx;
    private long targetFid;
    private String refName;

    @Id
    @Column(name = "xx", nullable = false)
    @GeneratedValue
    public String getXx() {
        return xx;
    }

    public void setXx(String xx) {
        this.xx = xx;
    }

    @Basic
    @Column(name = "target_fid")
    public long getTargetFid() {
        return targetFid;
    }

    public void setTargetFid(long targetFid) {
        this.targetFid = targetFid;
    }

    @Basic
    @Column(name = "refname")
    public String getRefName() {
        return refName;
    }

    public void setRefName(String refName) {
        this.refName = refName;
    }


//    @Basic
//    @Column(name = "geometry", columnDefinition="Geometry")
//    //ResultSet 中找不到栏位名称 geometry。
//    //@Type(type = "jts_geometry")
//    public Geometry getGeometry() {
//        return geometry;
//    }
//
//    public void setGeometry(Geometry geometry) {
//        this.geometry = geometry;
//    }




}
