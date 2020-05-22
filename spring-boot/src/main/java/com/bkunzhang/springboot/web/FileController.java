package com.bkunzhang.springboot.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@RestController
public class FileController {
    @RequestMapping("/postFile")
    public String postFile(@RequestParam("file1") MultipartFile file, @RequestParam Map<String, Object> map) throws IOException {
        if (file.isEmpty()) {
            return "file not find";
        }
        System.out.println(file.getOriginalFilename());
        System.out.println("map=" + map);
        String filePath = "d:/t/";
        file.transferTo(new File(filePath + file.getOriginalFilename()));
        return "yes";
    }
}
