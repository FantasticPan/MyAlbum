package com.lp.dao;

import com.lp.model.Image;

import java.util.List;

/**
 * Created by 李攀 on 2017/11/24.
 */
public interface ImageDao {

    List<Image> getImageById(Integer userId);

    void addImage(Image image);

    void delById(Integer id);
}
