package com.example.indexmanager.service.Impl;

import com.example.indexmanager.service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {

    public String uploadPicture(MultipartFile file, String type){
        String path="";
        try {
            String filePath = "W:/upload/"+type;

            File realPath = new File(filePath);
            if (!realPath.exists()){
                boolean mkdirs = realPath.mkdirs();
            }

            String fileRealName=file.getOriginalFilename();
            String suffix = fileRealName.substring(fileRealName.lastIndexOf(".") + 1);
            String fileName = "file-"+ UUID.randomUUID().toString().replaceAll("-", "") + "." + suffix;

            file.transferTo(new File(realPath +"\\"+ fileName));

            path="file/"+type+"/"+fileName;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }
}
