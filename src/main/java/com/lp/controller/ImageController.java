package com.lp.controller;

import com.lp.model.Image;
import com.lp.model.User;
import com.lp.service.ImageService;
import com.lp.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.UUID;

/**
 * Created by 李攀 on 2017/11/25.
 */
@Controller
public class ImageController {

    @Autowired
    private ImageService imageService;

    @RequestMapping("/image.do")
    @ResponseBody
    public void image(HttpServletRequest request, HttpServletResponse response, @RequestParam(required = false) MultipartFile image) throws IOException, ServletException {

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        Integer type = Integer.valueOf(request.getParameter("type"));
        if (type == 1) {
            User user = (User) request.getSession().getAttribute("user");
            String imageName = request.getParameter("image_name");
            Image img = new Image();
            img.setDate(new Timestamp(System.currentTimeMillis()));
            img.setName(imageName);
            img.setUser(user);
            img.setUrl(img.getUser().getUsername() + "/" + UUID.randomUUID());//UUID,唯一的辨识资讯

            FileUtils.upload(image.getInputStream(), img.getUrl());
            imageService.addImage(img);
            request.getSession().setAttribute("imageList", imageService.getImageById(img.getUser().getId()));
            response.sendRedirect(request.getContextPath() + "/home.do");
        } else if (type == 2) {
            String ids = request.getParameter("ids");
            String urls = request.getParameter("urls");

            String[] idArray = ids.split(",");
            String[] urlArray = urls.split(",");

            if (!"".equals(idArray[0]) && !"".equals(urlArray[0])) {
                for (int i = 0; i < idArray.length; i++) {
                    FileUtils.delete(urlArray[i]);
                    imageService.delById(Integer.valueOf(idArray[i]));
                }
            }
            request.getSession().setAttribute("imageList", imageService.getImageById(((User) request.getSession().getAttribute("user")).getId()));
        }
    }
}
