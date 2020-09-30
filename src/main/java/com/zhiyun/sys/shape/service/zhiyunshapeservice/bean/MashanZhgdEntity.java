package com.zhiyun.sys.shape.service.zhiyunshapeservice.bean;

import javax.persistence.*;

/**
 * @description:
 * @author: liukun
 * @create: 2020-08-04 21:32
 */

@Entity
@Table(name = "mashan_zhgd_c_20200805")
public class MashanZhgdEntity {

    private String fid;

    @Id
    @Column(name = "fid", nullable = false)
    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }
}
