package com.weblink.core.controllers.main_screen;

import com.weblink.core.common.enums.Extension;
import com.weblink.core.common.enums.FileType;
import com.weblink.core.common.file.FileBucket;
import com.weblink.core.models.User;
import com.weblink.core.services.file_system_service.FileSystemService;
import com.weblink.core.services.user_service.UserService;
import com.weblink.core.validators.FileValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
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

@PropertySource(value = "classpath:weblink.properties")
@Controller
public class MenuController {
    @Autowired FileSystemService fileSystemService;
    @Autowired UserService userService;
    @Autowired private Environment environment;

    private volatile User user;

    /*User Tried to Access a page to which he has no access*/
    @RequestMapping(value = "/weblink" , method = RequestMethod.GET)
    public String getAppMenu(Model model){
        user = userService.getSingleUser(getEmail());
        model.addAttribute("User", user);
        model.addAttribute("fileBucket" , new FileBucket());
        return "weblink";
    }

    private String getEmail() {
        String userName;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) userName = ((UserDetails)principal).getUsername();
        else userName = principal.toString();

        return userName;
    }
}
