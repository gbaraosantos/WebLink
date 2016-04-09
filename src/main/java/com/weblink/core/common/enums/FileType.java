package com.weblink.core.common.enums;

public enum FileType {
    VIDEO("video"),
    IMAGE("image"),
    SOUND("sound"),
    OTHER("other"),
    ANY("any");


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

    public static FileType tellByExtension(Extension extension) {
        if(Extension.AVI == extension)  return FileType.VIDEO;
        if(Extension.MKV == extension)  return FileType.VIDEO;
        if(Extension.MPEG == extension)  return FileType.VIDEO;
        if(Extension.MPG == extension)  return FileType.VIDEO;
        if(Extension.MP4 == extension)  return FileType.VIDEO;
        if(Extension.MP3 == extension)  return FileType.SOUND;
        if(Extension.FLAC == extension)  return FileType.SOUND;
        if(Extension.PNG == extension)  return FileType.IMAGE;
        if(Extension.JPEG == extension)  return FileType.IMAGE;
        if(Extension.JPG == extension)  return FileType.IMAGE;
        if(Extension.PDF == extension)  return FileType.OTHER;
        if(Extension.RAR == extension)  return FileType.OTHER;
        if(Extension.ZIP == extension)  return FileType.OTHER;

        return null;
    }
}
