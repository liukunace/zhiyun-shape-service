package com.zhiyun.sys.shape.service.zhiyunshapeservice.repository;

import com.zhiyun.sys.shape.service.zhiyunshapeservice.bean.PolygonDtoEntity;
import com.zhiyun.sys.shape.service.zhiyunshapeservice.bean.PolygonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface PolygonRepository extends JpaRepository<PolygonEntity,String> {

    /**
     * @project 视频所属项目
     * @name 视频名称
     * @Description: 分页查询获取视频对象
     */
    @Query(value = "SELECT * from zhiyun_video_list t where t.project like %:project% " + "and t.name like %:name% " ,nativeQuery = true)
    public List<PolygonEntity> searchByPage(@Param("project") String project, @Param("name") String name);

    @Query(value = "select a.xx, a.target_fid , a.refname from mashan_planning_polygon_test1 a where ST_intersects(a.geometry,ST_GeomFromText('Polygon((119.76516776128855  35.70848781212183, 119.76628775337608  35.70855030720652,119.76632897357398  35.70837193127791,119.76545524646697  35.70832317877496,119.76541572524881 35.70832097340617,119.76517157641932 35.70846558075502,119.76516776128855 35.70848781212183))'))" ,nativeQuery = true)
    public List<PolygonEntity> searchPoly2();

    @Query(value = "select 'xx' from public.test_t1" ,nativeQuery = true)
    public List<PolygonEntity> searchPoly();

    @Query(value = "select a.xx, a.target_fid , a.refname from mashan_planning_polygon_202004 a where ST_intersects(a.geometry,ST_GeomFromText(:polyStr))" ,nativeQuery = true)
    public List<PolygonEntity> searchPolyByPoly(@Param("polyStr") String polyStr);

    @Query(value = "select a.xx, a.target_fid , a.refname from mashan_planning_polygon_202004 a where ST_within(a.geometry,ST_GeomFromText(:polyStr))" ,nativeQuery = true)
    public List<PolygonEntity> searchPolyByPolyWith(@Param("polyStr") String polyStr);

    //@Query("SELECT p FROM Person p WHERE LOWER(p.lastName) = LOWER(:lastName)")
    //public List<PolygonEntity> find(@Param("lastName") String lastName);
}
