package lx.service;
import com.alibaba.fastjson.JSONObject;
import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.domain.ThumbImageConfig;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Service
public class FileUploadService {
    @Autowired
    private FastFileStorageClient fastFileStorageClient;
    @Autowired
    private ThumbImageConfig thumbImageConfig;

    private static final List<String> suffixes = Arrays.asList("image/png","image/jpeg","image/gif");

    public String imgUpload(MultipartFile imgFile){
        if(!vilateImg(imgFile)){
            //非图片及图片内容，抛异常
        }
        StorePath storePath = null;
        try {
            String afterLast= StringUtils.substringAfterLast(imgFile.getOriginalFilename(), ".");
            storePath = fastFileStorageClient.uploadImageAndCrtThumbImage(imgFile.getInputStream(), imgFile.getSize(), afterLast, null);
        }catch (Exception e){
            e.printStackTrace();
        }

        String thumbImagePath = thumbImageConfig.getThumbImagePath(storePath.getFullPath());
        return storePath.getFullPath()+"^"+thumbImagePath;
    }

    private boolean vilateImg(MultipartFile imgFile){
        try {
            BufferedImage read = ImageIO.read(imgFile.getInputStream());
            if(read == null){
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        String contentType = imgFile.getContentType();
        if(!suffixes.contains(contentType)){
            return false;
        }
        return true;
    }

    public String imgUploadResultOriage(MultipartFile file) throws IOException {
        String imgUpload = this.imgUpload(file);
        String[] split = StringUtils.split(imgUpload,"^");
        return split[0];
    }
    public String imgUploadResult(MultipartFile file) throws IOException {
        String imgUpload = this.imgUpload(file);
        String[] split = StringUtils.split(imgUpload,"^");
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("originalImg",split[0]);
        stringStringHashMap.put("thumbImg",split[1]);
        return JSONObject.toJSON(stringStringHashMap).toString();
    }
}
