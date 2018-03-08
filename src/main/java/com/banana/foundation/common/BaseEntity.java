package com.banana.foundation.common;

import com.banana.foundation.enums.BooleanType;
import lombok.Data;

//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
import java.util.Date;

/**
 * @author jiangbo
 * @version 2017/8/25 13:50
 */
@Data
public class BaseEntity extends Page {

    private static final long serialVersionUID = 1L;

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BooleanType isDeleted;

    private String creator;

    private Date gmtCreated;

    private String modifier;

    private Date gmtModified;

}
