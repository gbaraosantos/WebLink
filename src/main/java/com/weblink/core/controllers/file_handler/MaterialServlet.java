package com.weblink.core.controllers.file_handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;

@Controller
public class MaterialServlet {
    @RequestMapping(value = "/materialLoader" ,method = RequestMethod.GET)
    public void getMaterial(@RequestParam("dir") String path, HttpServletResponse response, HttpServletRequest request){
        File material = new File(path);

        String mimeType = URLConnection.guessContentTypeFromName(material.getName());
        String contentDisposition = String.format("attachment; filename=%s", material.getName());
        int fileSize = Long.valueOf(material.length()).intValue();

        response.setContentType(mimeType);
        response.setHeader("Content-Disposition", contentDisposition);
        response.setContentLength(fileSize);


        try (OutputStream out = response.getOutputStream()) {
            Path path1 = material.toPath();
            Files.copy(path1, out);
            out.flush();
        } catch (IOException e) {
            System.out.println("Well hello there  :(");
        }

    }
}
