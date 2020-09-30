package com.zhiyun.sys.shape.service.zhiyunshapeservice.repository;

import com.zhiyun.sys.shape.service.zhiyunshapeservice.bean.MashanMasterPlansEntity;
import com.zhiyun.sys.shape.service.zhiyunshapeservice.bean.PoliLandusingPolygonEntity;
import com.zhiyun.sys.shape.service.zhiyunshapeservice.bean.PolygonDtoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MashanMasterPlansRepository  extends JpaRepository<MashanMasterPlansEntity,String> {

    /**
     * @project
     * @name boolean ST_Contains (geometry geomA, geometry geomB) ;
     * @Description: st_contains 当且仅在B中的所有点都在 A中，并且至少有一个B中的点位于A中。
     */
    @Query(value = "select * from mashan_masterplans a where st_contains(a.the_geom, ST_GeomFromText((:pointStr),4490))" ,nativeQuery = true)
    public List<MashanMasterPlansEntity> searchPolyByPointWithGeo2(@Param("pointStr") String pointStr);

    /**
     * @project
     * @name
     * @Description: ST_Within — Returns true if the geometry A is completely inside geometry B
     */
    @Query(value = "select * from mashan_masterplans a where ST_within(a.the_geom, ST_GeomFromText((:pointStr),4490))" ,nativeQuery = true)
    public List<MashanMasterPlansEntity> searchPolyByPointWithGeo(@Param("pointStr") String pointStr);

    /**
     * @project
     * @name
     * @Description: ST_Within — Returns true if the geometry A is completely inside geometry B
     */
    @Query(value = "select * from mashan_masterplans a where ST_within(a.the_geom,ST_GeomFromText((:polyStr),4490))" ,nativeQuery = true)
    public List<MashanMasterPlansEntity> searchPolyByPolyWithGeo(@Param("polyStr") String polyStr);

}
