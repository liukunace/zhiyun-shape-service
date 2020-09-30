package com.zhiyun.sys.shape.service.zhiyunshapeservice.bean;

import com.vividsolutions.jts.geom.Point;
import org.hibernate.annotations.Type;
import javax.persistence.*;

@Entity
@Table(name = "mashan_point_table3")
public class PointEntity {

    private long id;
    private String name;
    private Point point;

    @Id
    @Column(name = "id", nullable = true)
    @GeneratedValue
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    //@JsonBackReference
    @Column(name="point",columnDefinition = "geometry(Point)")//,columnDefinition = "geometry(Point)"  geometry(Point,4326)
    @Type(type = "jts_geometry")
    //@Type(type = "org.hibernate.spatial.GeometryType")
    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }
}
