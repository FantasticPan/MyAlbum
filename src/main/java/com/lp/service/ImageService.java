package com.lp.service;

import com.lp.dao.ImageDao;
import com.lp.model.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 李攀 on 2017/11/24.
 */
@Service
public class ImageService {

    @Autowired
    private ImageDao imageDao;

    public List<Image> getImageById(Integer userId) {
        return imageDao.getImageById(userId);
    }

    public void addImage(Image image) {
        imageDao.addImage(image);
    }

    public void delById(Integer id) {
        imageDao.delById(id);
    }
}
