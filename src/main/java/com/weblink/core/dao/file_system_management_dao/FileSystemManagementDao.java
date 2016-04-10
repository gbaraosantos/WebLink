package com.weblink.core.dao.file_system_management_dao;

import com.weblink.core.models.Material;
import com.weblink.core.models.Module;

import java.util.List;

public interface FileSystemManagementDao {
    int addFile(Material material);
    void removeFile(Material material);
    List<Material> getFile(int id);
    List<Material> getFileList(Module module);


    void updateMaterial(Material material);
}
