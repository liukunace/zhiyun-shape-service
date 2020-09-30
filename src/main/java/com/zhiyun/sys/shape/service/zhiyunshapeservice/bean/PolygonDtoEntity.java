package com.zhiyun.sys.shape.service.zhiyunshapeservice.bean;


import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.Polygon;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "mashan_planning_polygon_202004")
public class PolygonDtoEntity {

    private String xx;
    private long targetFid;
    private String refName;

    private Polygon geometry;

    //java.math.BigInteger

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


    @Column(name="geometry",columnDefinition = "geometry(Polygon)")//,columnDefinition = "geometry(Point)"  geometry(Point,4326)
    @Type(type = "jts_geometry")
    public Polygon getGeometry() {
        return geometry;
    }

    public void setGeometry(Polygon geometry) {
        this.geometry = geometry;
    }
}
