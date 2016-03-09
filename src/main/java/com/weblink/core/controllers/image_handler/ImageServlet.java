package com.weblink.core.controllers.image_handler;

import org.springframework.core.io.ContextResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;


@Controller
public class ImageServlet extends HttpServlet {

    @RequestMapping(value = "/customImgLoader" ,method = RequestMethod.GET, params = {"dir"})
    public void getImage(@RequestParam("dir") String path, HttpServletResponse response, HttpServletRequest request) throws MalformedURLException {
        File image = new File(path);

        if (!image.exists() && path.endsWith("nopic.jpg"))
            image = new File(request.getSession().getServletContext().getRealPath("")+ path);

        response.reset();
        response.setHeader("Content-Length", String.valueOf(image.length()));

        try {
            Files.copy(image.toPath(), response.getOutputStream());
        } catch (IOException e) { e.printStackTrace(); }
    }
}
