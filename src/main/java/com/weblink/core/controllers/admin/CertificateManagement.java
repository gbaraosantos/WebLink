package com.weblink.core.controllers.admin;

import com.weblink.core.models.*;
import com.weblink.core.services.certificate_management_service.CertificateManagementService;
import com.weblink.core.services.logger_service.LoggerService;
import com.weblink.core.services.messaging_service.MessageService;
import com.weblink.core.services.user_profile_service.UserProfileService;
import com.weblink.core.services.user_service.FriendService;
import com.weblink.core.services.user_service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
public class CertificateManagement {
    @Autowired UserService userService;
    @Autowired UserProfileService userProfileService;
    @Autowired LoggerService logger;
    @Autowired FriendService friendService;
    @Autowired MessageService messageService;
    @Autowired CertificateManagementService certificateManagementService;
    private volatile User user;

    @RequestMapping(value = "/admin/certificateRequestsManagement")
    public String getCertManagement(Model model){
        prepareModel(model);

        return "CertificateManagement";
    }



    private void prepareModel(Model model) {
        user = userService.getSingleUser(getEmail());
        model.addAttribute("User", user);

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

        List<CertificateRequest> certList = certificateManagementService.getCertificates();

        if(certList == null || certList.size() == 0) model.addAttribute("ErrorMessage" , "Nao existem requests");
        model.addAttribute("certList" , certList);

    }

    @RequestMapping(value = "/deleteCert", method = RequestMethod.GET, params = {"certId"})
    public String deleteCert(@RequestParam("certId") int certId, Model model) {
        CertificateRequest certificateRequest = certificateManagementService.getCertificate(certId);
        if(certificateRequest == null ) return "/weblink";

        certificateManagementService.removeCertificate(certificateRequest);


        prepareModel(model);
        return "CertificateManagement";
    }

    private String getEmail() {
        String userName;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) userName = ((UserDetails)principal).getUsername();
        else userName = principal.toString();

        return userName;
    }

}
