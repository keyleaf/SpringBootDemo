package com.banana.foundation.common;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by TJ on 18/3/7.
 */
@Data
public class ResultBase<T> implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 7777729780722369667L;

    private Boolean isSuccess = false;
    private String message;
    private String code;
    private T value;
    private Date dataTime = new Date();


    public ResultBase() {
    }

    public ResultBase(T value) {
        this.isSuccess = true;
        this.value = value;
    }

    public ResultBase(boolean success, String code, String message) {
        this.isSuccess = success;
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
