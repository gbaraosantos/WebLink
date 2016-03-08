package com.weblink.core.services.file_system_service;


import com.weblink.core.common.file.FileBucket;

import java.io.IOException;

public interface FileSystemService {
    Boolean add_file(String type, int id, String name, FileBucket fileBucket);
    String get_file(String type, int id, String name);
}
