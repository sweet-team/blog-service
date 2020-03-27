package lx.controller;

import com.alibaba.fastjson.JSONObject;
import lx.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ImageUpload {
    @Autowired
    private FileUploadService fileUploadService;

    @RequestMapping({"/imgUpload"})
    public ResponseEntity<String> uploadImage(@RequestBody MultipartFile file){
        String  imgUrl = null;
        long startTime = System.currentTimeMillis();
        if (file == null){
            return ResponseEntity.status(HttpStatus.SEE_OTHER).body("请求有误");
        }
        try {
            imgUrl = fileUploadService.imgUploadResultOriage(file);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.SEE_OTHER).body("请求有误");
        }
        System.out.println("图片上传时间："+(System.currentTimeMillis() - startTime)+"\n"+imgUrl);
        return ResponseEntity.ok(imgUrl);
    }
    @RequestMapping("/api/imagesUpload")
    public ResponseEntity<String> uploadImages(@RequestBody List<MultipartFile> file){
        List<String>  imagesUrl = new ArrayList<>();
        long startTime = System.currentTimeMillis();
        if (file == null){
            return ResponseEntity.status(HttpStatus.SEE_OTHER).body("请求有误");

        }
        for (MultipartFile f: file
             ) {
            String imgUrl;
            try {
                imgUrl = fileUploadService.imgUploadResult(f);
            } catch (IOException e) {
                return ResponseEntity.status(HttpStatus.SEE_OTHER).body("请求有误");
            }
            imagesUrl.add(imgUrl);
        }
        String o = imagesUrl.toString();
        System.out.println("图片上传时间："+(System.currentTimeMillis() - startTime)+"\n"+o);
        return  ResponseEntity.ok(o);
    }
}
