package com.example.indexmanager.controller;

import com.example.indexmanager.result.Result;
import com.example.indexmanager.result.ResultFactory;
import com.example.indexmanager.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    private FileService fileService;

    @PostMapping("/file")
    public Result uploadProfile(MultipartFile file){
        return ResultFactory.makeSuccessResult(fileService.uploadPicture(file,"file"));
    }
}
