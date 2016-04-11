package com.weblink.core.services.file_system_service;


import com.weblink.core.common.enums.Extension;
import com.weblink.core.common.enums.FileType;
import com.weblink.core.common.file.FileBucket;
import com.weblink.core.dao.file_system_management_dao.FileSystemManagementDao;
import com.weblink.core.models.Action;
import com.weblink.core.models.Material;
import com.weblink.core.models.Module;
import com.weblink.core.models.User;
import com.weblink.core.services.logger_service.LoggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;


@PropertySource(value = "classpath:weblink.properties")
@Service("fileSystemService")
public class FileSystemServiceImpl implements  FileSystemService{
    @Autowired LoggerService logger;
    @Autowired private Environment environment;
    @Autowired FileSystemManagementDao fileSystemManagementDao;

    @Override
    public Boolean add_file(String type, int id, String name, FileBucket fileBucket){
        String initialPath = environment.getProperty("file.system.path");
        Map<String, Object> log = new HashMap<>();

        MultipartFile multipartFile = fileBucket.getFile();
        String path = initialPath + type + "/" + id + "/";

        if (!prepareDirectory(path,name) || !putFile(fileBucket,path + name)){
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
    public List<Material> getMaterialList(Module module) {
        List<Material> list = fileSystemManagementDao.getFileList(module);
        if(list==null || list.size() <= 0) return null;
        return list;
    }


    @Override
    public Material getMaterial(int id) {
        List<Material> list = fileSystemManagementDao.getFile(id);
        if(list==null || list.size() <= 0) return null;
        return list.get(0);
    }


    @Override
    public Boolean createMaterial(String type, Module module, String name, String description, Extension extension, FileBucket fileBucket, User user) {
        double sizeBytes, sizeKBytes, sizeMBytes;
        Map<String, Object> log = new HashMap<>();
        String initialPath = environment.getProperty("file.system.path");

        MultipartFile multipartFile = fileBucket.getFile();
        String path = initialPath + type + "/" + module.getId() + "/";

        sizeBytes = multipartFile.getSize();
        sizeKBytes = sizeBytes / 1024;
        sizeMBytes = sizeKBytes / 1024;

        FileType fileType = FileType.tellByExtension(extension);
        if(fileType == null)    return false;

        Material newMaterial = new Material()
                .setCreationDate(new Date())
                .setDescription(description)
                .setExtension(extension.getExtension())
                .setDirectory(path)
                .setFileType(fileType.getFileType())
                .setModule(module)
                .setName(name)
                .setSize(((int) sizeMBytes))
                .setUploadedBy(user);

        int materialId = fileSystemManagementDao.addFile(newMaterial);
        String finalName = String.valueOf(materialId) + extension;

        List<Material> temp = fileSystemManagementDao.getFile(materialId);

        if(temp==null || temp.size() <= 0) return null;
        fileSystemManagementDao.updateMaterial(temp.get(0).setDirectory(path + finalName).setName(multipartFile.getOriginalFilename()));
        if (!prepareDirectory(path,finalName) || !putFile(fileBucket,path + finalName)) return false;


        log.put("type" , "New Material");
        log.put("FileType" , type);
        log.put("Identifier", materialId);
        log.put("size", multipartFile.getSize());
        logger.log(log,"INFO");

        return true;


    }

    @Override
    public void deleteMaterial(int materialId) {
        Material material = getMaterial(materialId);

        if(material != null) fileSystemManagementDao.removeFile(material);
    }

    private Boolean prepareDirectory(String path, String name) {
        File directory = new File(path);
        File file = new File(path + name);

        if(file.exists()) return file.delete();
        return directory.exists() || directory.mkdirs();
    }

    private Boolean putFile(FileBucket fileBucket, String path){
        try {
            FileCopyUtils.copy(fileBucket.getFile().getBytes(), new File(path));
            return true;
        } catch (IOException e) {
            e.printStackTrace(); return false; }
    }

}
