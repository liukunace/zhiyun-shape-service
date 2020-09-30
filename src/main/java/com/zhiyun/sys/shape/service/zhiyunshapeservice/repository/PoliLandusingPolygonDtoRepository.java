package com.zhiyun.sys.shape.service.zhiyunshapeservice.repository;

import com.zhiyun.sys.shape.service.zhiyunshapeservice.bean.PoliLandusingPolygonEntity;
import com.zhiyun.sys.shape.service.zhiyunshapeservice.bean.PolygonDtoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PoliLandusingPolygonDtoRepository extends JpaRepository<PoliLandusingPolygonEntity,String> {

    @Query(value = "select * from poli_landusing_polygon_20200430 a where st_contains(a.the_geom, ST_GeomFromText((:pointStr),4490))" ,nativeQuery = true)
    public List<PoliLandusingPolygonEntity> searchPolyByPointWithGeo(@Param("pointStr") String pointStr);

    @Query(value = "select * from poli_land_current_polygon_20200506 a where st_contains(a.the_geom, ST_GeomFromText((:pointStr),4490))" ,nativeQuery = true)
    public List<PoliLandusingPolygonEntity> searchPolyByPointWithGeo2(@Param("pointStr") String pointStr);

    @Query(value = "select * from poli_landtotal_planning_polygon_20200506 a where st_contains(a.the_geom, ST_GeomFromText((:pointStr),4490))" ,nativeQuery = true)
    public List<PoliLandusingPolygonEntity> searchPolyByPointWithGeo3(@Param("pointStr") String pointStr);

    @Query(value = "select * from poli_landdetail_planning_polygon_20200508 a where st_contains(a.the_geom, ST_GeomFromText((:pointStr),4490))" ,nativeQuery = true)
    public List<PoliLandusingPolygonEntity> searchPolyByPointWithGeo4(@Param("pointStr") String pointStr);

}
