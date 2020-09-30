package com.zhiyun.sys.shape.service.zhiyunshapeservice.repository;

import com.zhiyun.sys.shape.service.zhiyunshapeservice.bean.PolygonDtoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PolygonDtoRepository extends JpaRepository<PolygonDtoEntity,String> {

    /**
     * @project 视频所属项目
     * @name 视频名称
     * @Description: 分页查询获取视频对象
     */
    @Query(value = "select a.xx, a.target_fid , a.refname ,a.geometry from mashan_planning_polygon_202004 a where ST_within(a.geometry,ST_GeomFromText(:polyStr))" ,nativeQuery = true)
    public List<PolygonDtoEntity> searchPolyByPolyWithGeo(@Param("polyStr") String polyStr);

}
