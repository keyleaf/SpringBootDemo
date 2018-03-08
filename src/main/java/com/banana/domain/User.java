package com.banana.domain;

import lombok.Data;

/**
 * Created by TJ on 18/3/8.
 */
@Data
public class User {
    private Long id;

    private String accountName;

    private String userName;


    private String password;
}
