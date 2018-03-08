package com.banana.foundation.common;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Transient;
import java.io.Serializable;

/**
 * 分页信息
 * @author jiangbo
 * @version 2017/9/1 17:50
 */
public class Page implements Serializable {

    /** 
     * @Fields serialVersionUID: TODO
     */ 
    private static final long serialVersionUID = 1L;

    // 是否分页
    @JSONField(serialize = false)
    @Transient
    private boolean pageFlag = false;

    // 默认从第一页开始
    @JSONField(serialize = false)
    @Transient
    private int page = 1;

    // 每页10行
    @JSONField(serialize = false)
    @Transient
    private int rows = 20;

    @JSONField(serialize = false)
    @Transient
    @ApiModelProperty(hidden = true)
    private int start;

    // 排序
    @JSONField(serialize = false)
    @Transient
    @ApiModelProperty(hidden = true)
    private String sort;

    // 升序或者降序
    @JSONField(serialize = false)
    @Transient
    @ApiModelProperty(hidden = true)
    private String order;

    @JSONField(serialize = false)
    @Transient
    @ApiModelProperty(hidden = true)
    private String condition;

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public boolean isPageFlag() {
        return pageFlag;
    }

    public void setPageFlag(boolean pageFlag) {
        this.pageFlag = pageFlag;
    }

    /**
     * @return the start
     */
    public int getStart() {
        return (page - 1) * rows;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        if (page <= 0) {
            page = 1;
        }
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        if (rows <= 0) {
            rows = 20;
        }
        this.rows = rows;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
