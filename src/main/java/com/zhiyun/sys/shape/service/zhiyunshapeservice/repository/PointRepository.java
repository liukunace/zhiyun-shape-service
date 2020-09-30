package com.zhiyun.sys.shape.service.zhiyunshapeservice.repository;

import com.vividsolutions.jts.geom.Point;
import com.zhiyun.sys.shape.service.zhiyunshapeservice.bean.PointEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface PointRepository extends JpaRepository<PointEntity,String> {
    //@Query("select p from mashan_point_table as p where equals(p.geom,:point) = TRUE")
    //List<PointEntity> findByPoint(@Param("point") Point point);
}
