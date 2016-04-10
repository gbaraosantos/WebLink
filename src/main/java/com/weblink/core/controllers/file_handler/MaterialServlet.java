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
import java.nio.file.Files;

@Controller
public class MaterialServlet {
    @RequestMapping(value = "/materialLoader" ,method = RequestMethod.GET)
    public void getMaterial(@RequestParam("dir") String path, HttpServletResponse response, HttpServletRequest request) throws MalformedURLException {
        File material = new File(path);

        response.reset();
        response.setHeader("Content-Length", String.valueOf(material.length()));

        try {
            Files.copy(material.toPath(), response.getOutputStream());
        } catch (IOException e) { e.printStackTrace(); }
    }
}
