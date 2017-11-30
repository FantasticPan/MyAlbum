package com.lp.util;

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;

import java.io.InputStream;

/**
 * Created by 李攀 on 2017/11/25.
 * 七牛云存储服务
 */
public class FileUtils {

    private static final String ACCESS_KEY = "BM9gv_FWZayQsk-C8QtSab6DGn1_BYbQOQWo2XYm";//这里填密钥管理里面的密钥
    private static final String SECRET_KEY = "y3ZEBg2QWREhwRw2yx4I1IH24KxxtN3931F29cdq";
    private static final String BUCKET_NAME = "photos";    //填在七牛云创建的 Bucket 名字

    /**
     * 上传图片到七牛云存储
     */
    public static void upload(InputStream reader, String fileName) {

        Configuration cfg = new Configuration(Zone.zone2());
        UploadManager uploadManager = new UploadManager(cfg);
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        String token = auth.uploadToken(BUCKET_NAME);

        try {
            uploadManager.put(reader, fileName, token, null, null);

        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        }
    }

    /**
     * 删除七牛云存储上的图片
     */
    public static void delete(String key) {

        Configuration cfg = new Configuration(Zone.zone2());
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        BucketManager bucketManager = new BucketManager(auth, cfg);
        try {
            bucketManager.delete(BUCKET_NAME, key);
        } catch (QiniuException ex) {
            //如果遇到异常，说明删除失败
            System.err.println(ex.code());
            System.err.println(ex.response.toString());
        }
    }
}
