package com.weblink.core.controllers.main_screen;

import com.weblink.core.common.file.FileBucket;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import javax.validation.Valid;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MenuController {

    /*User Tried to Access a page to which he has no access*/
    @RequestMapping(value = "/AppMenu" , method = RequestMethod.GET)
    public String getAppMenu(Model model){
        String user = getEmail();
        model.addAttribute("user" , user);
        model.addAttribute("fileBucket" , new FileBucket());
        return "AppMenu";
    }

    private String getEmail() {
        String userName;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) userName = ((UserDetails)principal).getUsername();
        else userName = principal.toString();

        return userName;
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String singleFileUpload(HttpServletRequest request, ModelMap model) throws IOException {
        try {
            Part a = request.getPart("file");
            System.out.println(a);
        } catch (ServletException e) {
            e.printStackTrace();
        }

        return "AppMenu";

    }
}
