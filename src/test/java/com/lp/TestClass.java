package com.lp;

import com.lp.junit.JunitTest;
import com.lp.model.Image;
import com.lp.model.User;
import com.lp.service.ImageService;
import com.lp.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by 李攀 on 2017/11/27.
 */
public class TestClass extends JunitTest {

    @Autowired
    private UserService userService;

    @Autowired
    private ImageService imageService;

    @Test
    public void testUser() {

        //User user = new User("lp", "999999");
        //userService.addUser(user);
        User lp = userService.getUserByUsername("lp");
        System.out.println(lp);
    }

    @Test
    public void testImage(){

        //Image image = new Image();
        //image.setName("wangping");
        //image.setUrl("www.www");
        //image.setDate(new Date(System.currentTimeMillis()));
        //User user = new User();
        //user.setId(1);
        //image.setUser(user);
        //imageService.addImage(image);

        List<Image> images = imageService.getImageById(1);
        images.stream().forEach(System.out::println);
    }
}