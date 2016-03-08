package com.weblink.core.common.enums;

public enum FileType {
    VIDEO("video"),
    IMAGE("image"),
    SOUND("sound"),
    OTHER("other");


    private String fileType;

    FileType(final String fileType){
        this.fileType = fileType;
    }

    public String getFileType(){
        return this.fileType;
    }

    @Override
    public String toString(){
        return this.fileType;
    }

    public String getName(){
        return this.name();
    }

}
