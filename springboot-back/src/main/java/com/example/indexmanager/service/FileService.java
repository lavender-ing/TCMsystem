package com.example.indexmanager.service;

import org.springframework.web.multipart.MultipartFile;

/*用于文件上传*/
public interface FileService {

    public String uploadPicture(MultipartFile file, String type);
}
