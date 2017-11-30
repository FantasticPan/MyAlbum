package com.lp.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by 李攀 on 2017/11/24.
 */
@Getter
@Setter
@ToString
public class Image implements Serializable {

    private Integer id;
    private String name;
    private String url;
    private Timestamp date;
    private User user;
}
