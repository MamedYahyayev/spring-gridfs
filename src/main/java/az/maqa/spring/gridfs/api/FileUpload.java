package az.maqa.spring.gridfs.api;

import az.maqa.spring.gridfs.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/file/upload")
public class FileUpload {

    @Autowired
    private FileUploadService service;

    @PostMapping
    public void fileUpload(@RequestParam MultipartFile file) {
        service.uploadFile(file);
    }

}
