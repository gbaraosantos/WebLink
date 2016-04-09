package com.weblink.core.validators;

import com.weblink.core.common.enums.Extension;
import com.weblink.core.common.enums.FileType;
import com.weblink.core.common.file.FileBucket;

public class FileValidator {

    public Extension validateFile(FileBucket fileBucket, FileType type){
        Extension ext = null;
        if(fileBucket == null) return null;
        if (fileBucket.getFile() == null) return null;
        if(fileBucket.getFile().getSize() == 0) return null;

        if (type.equals(FileType.VIDEO)) ext = getVideoExtension(fileBucket.getFile().getOriginalFilename());
        if (type.equals(FileType.OTHER)) ext = getOtherExtension(fileBucket.getFile().getOriginalFilename());
        if (type.equals(FileType.SOUND)) ext = getSoundExtension(fileBucket.getFile().getOriginalFilename());
        if (type.equals(FileType.IMAGE)) ext = getImageExtension(fileBucket.getFile().getOriginalFilename());
        if (type.equals(FileType.ANY))   ext = getAnyExtension(fileBucket.getFile().getOriginalFilename());

        return ext;
    }

    private Extension getAnyExtension(String originalFilename) {
        if(originalFilename.endsWith(Extension.FLAC.getExtension())) return Extension.FLAC;
        if(originalFilename.endsWith(Extension.MP3.getExtension())) return Extension.MP3;
        if(originalFilename.endsWith(Extension.ZIP.getExtension())) return Extension.ZIP;
        if(originalFilename.endsWith(Extension.RAR.getExtension())) return Extension.RAR;
        if(originalFilename.endsWith(Extension.PDF.getExtension())) return Extension.PDF;
        if(originalFilename.endsWith(Extension.MPEG.getExtension())) return Extension.MPEG;
        if(originalFilename.endsWith(Extension.AVI.getExtension())) return Extension.AVI;
        if(originalFilename.endsWith(Extension.MKV.getExtension())) return Extension.MKV;
        if(originalFilename.endsWith(Extension.MPG.getExtension())) return Extension.MPG;
        if(originalFilename.endsWith(Extension.MP4.getExtension())) return Extension.MP4;
        if(originalFilename.endsWith(Extension.JPEG.getExtension())) return Extension.JPEG;
        if(originalFilename.endsWith(Extension.PNG.getExtension())) return Extension.PNG;
        if(originalFilename.endsWith(Extension.JPG.getExtension())) return Extension.JPG;
        return null;
    }

    private Extension getSoundExtension(String originalFilename) {
        if(originalFilename.endsWith(Extension.FLAC.getExtension())) return Extension.FLAC;
        if(originalFilename.endsWith(Extension.MP3.getExtension())) return Extension.MP3;
        return null;
    }

    private Extension getOtherExtension(String originalFilename) {
        if(originalFilename.endsWith(Extension.ZIP.getExtension())) return Extension.ZIP;
        if(originalFilename.endsWith(Extension.RAR.getExtension())) return Extension.RAR;
        if(originalFilename.endsWith(Extension.PDF.getExtension())) return Extension.PDF;
        return null;
    }

    private Extension getVideoExtension(String originalFilename) {
        if(originalFilename.endsWith(Extension.MPEG.getExtension())) return Extension.MPEG;
        if(originalFilename.endsWith(Extension.AVI.getExtension())) return Extension.AVI;
        if(originalFilename.endsWith(Extension.MKV.getExtension())) return Extension.MKV;
        if(originalFilename.endsWith(Extension.MPG.getExtension())) return Extension.MPG;
        if(originalFilename.endsWith(Extension.MP4.getExtension())) return Extension.MP4;
        return null;
    }


    private Extension getImageExtension(String originalFilename) {
        if(originalFilename.endsWith(Extension.JPEG.getExtension())) return Extension.JPEG;
        if(originalFilename.endsWith(Extension.PNG.getExtension())) return Extension.PNG;
        if(originalFilename.endsWith(Extension.JPG.getExtension())) return Extension.JPG;
        return null;
    }


}
