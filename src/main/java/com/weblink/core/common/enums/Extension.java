package com.weblink.core.common.enums;

/**
 * Created by guilherme on 08-03-2016.
 */
public enum Extension {
    PNG(".png"),
    JPG(".jsp"),
    JPEG(".jpeg"),
    MP3(".mp3"),
    FLAC(".flac"),
    MPEG(".mpeg"),
    MPG(".mpg"),
    MKV(".mkv"),
    AVI(".avi"),
    MP4(".mp4"),
    PDF(".pdf"),
    RAR(".rar"),
    ZIP(".zip");

    private String extension;

    Extension(final String extension){
        this.extension = extension;
    }

    public String getExtension(){
        return this.extension;
    }

    @Override
    public String toString(){
        return this.extension;
    }

    public String getName(){
        return this.name();
    }
}
