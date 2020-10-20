package az.maqa.spring.gridfs.service;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileUploadService {

    @Autowired
    private GridFsTemplate template;

    public void uploadFile(MultipartFile multipartFile) {
        try {
            DBObject dbObject = new BasicDBObject();
            dbObject.put("fileName", multipartFile.getOriginalFilename());
            dbObject.put("contentType", multipartFile.getContentType());
            dbObject.put("fileSize", multipartFile.getSize());
            template.store(multipartFile.getInputStream(), multipartFile.getOriginalFilename(), dbObject);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
