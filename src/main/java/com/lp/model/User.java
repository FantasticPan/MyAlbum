package com.lp.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * Created by 李攀 on 2017/11/24.
 */
@Getter
@Setter
@ToString
public class User {

    private Integer id;
    private String username;
    private String password;
    private List<Image> images;

    public User() {}

    public User(Integer id, String username, String password, List<Image> images) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.images = images;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
