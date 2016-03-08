package com.weblink.core.services.file_system_service;


import com.weblink.core.common.file.FileBucket;
import com.weblink.core.services.logger_service.LoggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


@PropertySource(value = "classpath:weblink.properties")
@Service("fileSystemService")
public class FileSystemServiceImpl implements  FileSystemService{
    @Autowired LoggerService logger;
    @Autowired private Environment environment;



    @Override
    public Boolean add_file(String type, int id, String name, FileBucket fileBucket){
        String initialPath = environment.getProperty("file.system.path");
        Map<String, Object> log = new HashMap<>();

        MultipartFile multipartFile = fileBucket.getFile();
        String path = initialPath + type + "/" + id + "/";

        if (!prepareDirectory(path) || !putFile(fileBucket,path + name)){
            log.put("type", "error");
            log.put("error", "Inserting file");
            logger.log(log, "ERROR");
            return false;
        }

        log.put("type" , "New File");
        log.put("FileType" , type);
        log.put("Identifier", id);
        log.put("File Name" , name);
        log.put("size", multipartFile.getSize());
        logger.log(log,"INFO");

        return true;
    }

    @Override
    public String get_file(String type, int id, String name) {
        return null;
    }

    private Boolean prepareDirectory(String path) {
        File directory = new File(path);
        return directory.exists() || directory.mkdir();
    }
    private Boolean putFile(FileBucket fileBucket, String path){
        try {
            FileCopyUtils.copy(fileBucket.getFile().getBytes(), new File(path));
            return true;
        } catch (IOException e) { return false; }
    }

}
