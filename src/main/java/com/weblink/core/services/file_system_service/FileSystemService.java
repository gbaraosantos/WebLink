package com.weblink.core.services.file_system_service;


import com.weblink.core.common.enums.Extension;
import com.weblink.core.common.file.FileBucket;
import com.weblink.core.models.Material;
import com.weblink.core.models.Module;
import com.weblink.core.models.User;

import java.io.IOException;
import java.util.List;

public interface FileSystemService {
    Boolean add_file(String type, int id, String name, FileBucket fileBucket); //Although the name this only adds images

    List<Material> getMaterialList(Module module);
    Material getMaterial(int id);
    Boolean createMaterial(String type, Module module, String name, String description, Extension extension, FileBucket fileBucket, User user);
    void deleteMaterial(int materialId);
}
