package com.zhiyun.sys.shape.service.zhiyunshapeservice.repository;

import com.zhiyun.sys.shape.service.zhiyunshapeservice.bean.MashanZhgdEntity;
import com.zhiyun.sys.shape.service.zhiyunshapeservice.bean.PointEntity;
import org.opengis.geometry.primitive.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @description:
 * @author: liukun
 * @create: 2020-08-04 21:29
 */
public interface MashanZhgdRepository extends JpaRepository<MashanZhgdEntity,String> {

    //@Query("select p from mashan_point_table as p where equals(p.geom,:point) = TRUE")
    @Query(value = "select  a.fid  from mashan_zhgd_c_20200805 a where ST_intersects(a.the_geom,ST_GeomFromText((:point),4490))" ,nativeQuery = true)
    //select * from mashan_zhgd_c_20200805 a where st_contains(a.the_geom, ST_GeomFromText(('POINT(119.7065 35.28267)'),4490))
    List<MashanZhgdEntity> findByPoint(@Param("point") String point);

}
