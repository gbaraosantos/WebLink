package com.weblink.core.common.file;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by guilherme on 08-03-2016.
 */
public class UploadedFile {
    MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public UploadedFile setFile(MultipartFile file) {
        this.file = file;
        return this;
    }
}
