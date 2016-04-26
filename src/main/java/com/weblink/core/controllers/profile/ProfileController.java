package com.weblink.core.controllers.profile;

import com.weblink.core.common.enums.Extension;
import com.weblink.core.common.enums.FileType;
import com.weblink.core.common.file.FileBucket;
import com.weblink.core.models.EmailApp;
import com.weblink.core.models.FriendRequest;
import com.weblink.core.models.User;
import com.weblink.core.services.file_system_service.FileSystemService;
import com.weblink.core.services.logger_service.LoggerService;
import com.weblink.core.services.messaging_service.MessageService;
import com.weblink.core.services.user_service.FriendService;
import com.weblink.core.services.user_service.UserService;
import com.weblink.core.validators.FileValidator;
import com.weblink.core.validators.ProfileUpdateValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ProfileController {

    @Autowired FileSystemService fileSystemService;
    @Autowired UserService userService;
    @Autowired private Environment environment;
    @Autowired private PasswordEncoder passwordEncoder;
    @Autowired LoggerService logger;
    @Autowired MessageService messageService;
    @Autowired FriendService friendService;

    private volatile User user;

    @RequestMapping(value = "/weblink/profile", method = RequestMethod.GET)
    public String getProfile(Model model){
        user = userService.getSingleUser(getEmail());
        prepareModel(model);
        model.addAttribute("User", user);
        model.addAttribute("fileBucket" , new FileBucket());
        return "Profile";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String UploadProfilePicture(@Valid FileBucket fileBucket, BindingResult result, ModelMap model){
        if (result.hasErrors()) return "redirect:/weblink/profile?uploadSuccess=false";
        model.addAttribute("User" , user);


        String initialPath = environment.getProperty("file.system.path");
        Extension ext = new FileValidator().validateFile(fileBucket, FileType.IMAGE);

        if(ext == null) return "redirect:/weblink/profile?uploadSuccess=false";
        if (!fileSystemService.add_file("User" , user.getId(), "profilepic" + ext.getExtension() ,fileBucket)) return "redirect:/weblink/profile?uploadSuccess=false";

        user.setAvatarLocation(initialPath + "User/" + user.getId() + "/profilepic" + ext.getExtension());
        userService.updateUser(user);
        model.addAttribute("User" , user);
        return "redirect:/weblink/profile?uploadSuccess=true";

    }

    @RequestMapping(value = "/weblink/profile", method = RequestMethod.GET, params = {"uploadSuccess"})
    public String UploadProfilePictureSuccess(Model model, @RequestParam("uploadSuccess") Boolean success){
        if(success) model.addAttribute("Success", "The Requested image was uploaded successfully");
        else model.addAttribute("ErrorUpload", "The Requested image was not uploaded successfully");
        model.addAttribute("fileBucket" , new FileBucket());
        model.addAttribute("User", user);
        prepareModel(model);
        return "Profile";

    }



    @RequestMapping(value = "/weblink/profileUpdate", method = RequestMethod.POST)
    public String UpdateProfile(Model model, HttpServletRequest request){
        Map<String,Object> log = new HashMap<>();

        user = new ProfileUpdateValidator().validateInput(request,user,passwordEncoder);

        log.put("type","ProfileUpdate");
        log.put("email" , user.getEmail());
        logger.log(log, "INFO");

        userService.updateUser(user);

        prepareModel(model);
        model.addAttribute("Success", "Update de perfil foi bem sucedido");
        model.addAttribute("fileBucket" , new FileBucket());
        model.addAttribute("User", user);
        return "Profile";

    }




    @ResponseBody
    @RequestMapping(value = "/weblink/profile/deleteUser", method= RequestMethod.GET)
    public String deleteProfile(){
        System.out.println();
        userService.deleteUser(getEmail());
        return "Success Deleting";
    }

    private String getEmail() {
        String userName;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) userName = ((UserDetails)principal).getUsername();
        else userName = principal.toString();

        return userName;
    }
    private void prepareModel(Model model) {
        List<FriendRequest> list = friendService.getToMePending(user);
        List<EmailApp> sentList = messageService.sentMessages(user);
        List<EmailApp> receivedList = messageService.receivedMessage(user);
        List<EmailApp> receivedUnreadList = messageService.receivedUnreadMessage(user);

        model.addAttribute("fromMePending", friendService.getFromMePending(user));
        model.addAttribute("toMePending", list );
        model.addAttribute("friendListing" , friendService.getFriends(user));
        model.addAttribute("sentList" , sentList);
        model.addAttribute("receivedList", receivedList);

        if(list != null) model.addAttribute("nrRequestsPending" , list.size());
        if(receivedUnreadList != null) model.addAttribute("nrMessages", receivedUnreadList.size());
    }

}
