package com.weblink.core.controllers.registerLogin;

import com.weblink.core.models.User;
import com.weblink.core.models.UserProfile;
import com.weblink.core.models.VerificationToken;
import com.weblink.core.common.enums.State;
import com.weblink.core.common.enums.UserProfileType;
import com.weblink.core.services.email_service.EmailService;
import com.weblink.core.services.logger_service.LoggerService;
import com.weblink.core.services.user_profile_service.UserProfileService;
import com.weblink.core.services.user_service.UserService;
import com.weblink.core.validators.EmailInputValidator;
import com.weblink.core.validators.PasswordResetValidator;
import com.weblink.core.validators.RegisterValidator;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Controller
public class LoginMenuController {

    @Autowired UserService userService;
    @Autowired UserProfileService userProfileService;
    @Autowired EmailService emailService;
    @Autowired LoggerService logger;


    /* /loginMenu Request to change to the login Menu*/
    @RequestMapping(value = "/loginMenu" , method = RequestMethod.GET)
    public String redirectLogin(){
        if (!(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken)) return ("redirect:/");
        return "Login";
    }

    /* /logout Receives a Logout Request*/
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutRequest (HttpServletRequest request, HttpServletResponse response) {
        if ((SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken)) return ("redirect:/");

        Map<String, Object> log = new HashMap<>();
        log.put("ip" , request.getRemoteAddr());
        log.put("email" , getEmail());
        log.put("type" , "Logout");
        log.put("activeTime" , (request.getSession().getLastAccessedTime() - request.getSession().getCreationTime()) / 1000);
        logger.log(log);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) new SecurityContextLogoutHandler().logout(request, response, auth);
        return "redirect:/loginMenu?logout=true";
    }

    /* /loginMenu?logout = 1 Logout was Successful */
    @RequestMapping(value="/loginMenu", method = RequestMethod.GET, params = {"logout"})
    public String logoutSuccessful(@RequestParam("logout") String val, Model model) {
        return "Login";
    }

    /* /loginMenu?logout = 1 Logout was Successful */
    @RequestMapping(value="/loginMenu", method = RequestMethod.GET, params = {"expired"})
    public String sessionExpires(@RequestParam("expired") String val, Model model) {
        Map<String, Object> log = new HashMap<>();
        log.put("type" , "Expired");
        log.put("email" , getEmail());

        if(val.equals("true")) logger.log(log);
        model.addAttribute("errorMessage" , "A sua sessão expirou");
        return "Login";
    }

    /* /loginForm?error Someone failed Login */
    @RequestMapping(value="/loginMenu", method = RequestMethod.GET, params = {"error"})
    public String loginError(@RequestParam("error") String val, Model model) {
        Map<String, Object> log = new HashMap<>();
        log.put("type" , "loginFailed");

        logger.log(log);
        model.addAttribute("errorMessage" , "Credenciais Inválidas");
        return "Login";
    }

    /* /loginMenu?logout = 1 Logout was Successful */
    @RequestMapping(value="/loginMenu", method = RequestMethod.GET, params = {"register"})
    public String registerSuccess(@RequestParam("register") Boolean val, Model model) {
        if (val) model.addAttribute("successRegister","Registo bem sucedido, confirme o seu email");
        else model.addAttribute("errorMessage", "Erro no Registo, email já utilizado");
        return "Login";
    }

    /* /registerForm Someone is Trying to Register */
    @RequestMapping(value="/registerForm", method = RequestMethod.POST)
    public String registerRequest(HttpServletRequest request) {
        Set<UserProfile> userProfiles = new HashSet<>();
        String token;

        userProfiles.add(userProfileService.getUserProfileByType(UserProfileType.USER));
        User user = new RegisterValidator().validateInput(request,userProfiles);

        if(user == null) return "redirect:/loginMenu?register=false";
        if (!userService.register(user)) return "redirect:/loginMenu?register=false";

        token = userService.createVerificationToken(user);
        String confirmationUrl = "https://localhost:8443/regitrationConfirm?token=" + token;
        String subject = "Registration Confirmation Email";

        emailService.emailLoader();
        MimeMessage regEmail = emailService.prepareEmail(user.getEmail(),"RegistrationTemplate",user.getName(),confirmationUrl,subject);
        emailService.sendEmail(regEmail,user);

        Map<String, Object> log = new HashMap<>();
        log.put("ip" , request.getRemoteAddr());
        log.put("email" , getEmail());
        log.put("type", "Registration");
        logger.log(log);

        return "redirect:/loginMenu?register=true";
    }

    /* /loginMenu?logout = 1 Logout was Successful */
    @RequestMapping(value="/regitrationConfirm", method = RequestMethod.GET, params = {"token"})
    public String registrationConfirmation(@RequestParam("token") String token, Model model) {
        if (token == null){
            model.addAttribute("errorMessage", "Token invalida");
            return "Login";
        }

        User user = userService.getUser(token);

        if (user == null){
            model.addAttribute("errorMessage", "Token invalida");
            return "Login";
        }

        userService.updateUser(user.setState(State.ACTIVE.getState()));
        model.addAttribute("successRegister","Account confirmada");
        return "Login";
    }

    @RequestMapping(value="/passRecovery", method = RequestMethod.GET)
    public String passwordRecovery() {
        return "PasswordRecovery";
    }

    @RequestMapping(value="/emailRecovery", method = RequestMethod.POST)
    public String sendPasswordRecoveryEmail(HttpServletRequest request, Model model) {
        User user = userService.getSingleUser(new EmailInputValidator().EmailValidator(request));

        if(user == null) {
            model.addAttribute("errorMessage", "Email Inválido");
            return "PasswordRecovery";
        }

        VerificationToken token = userService.getToken(user);

        if(token == null) {
            model.addAttribute("errorMessage", "Não tem uma token associada a esta conta");
            return "PasswordRecovery";
        }

        model.addAttribute("successRegister", "Email Enviado com Instruções");
        String confirmationUrl = "https://localhost:8443/passwordReset?token=" + token.getToken();
        String subject = "Pass Recovery Email";

        emailService.emailLoader();
        MimeMessage passwordRecoveryEmail = emailService.prepareEmail(user.getEmail(),"PasswordRecovery", user.getName(), confirmationUrl, subject);
        emailService.sendEmail(passwordRecoveryEmail,user);

        return "Login";
    }

    @RequestMapping(value="/passwordReset", method = RequestMethod.GET, params = {"token"})
    public String passwordReset(@RequestParam("token") String token, Model model) {
        if (token == null){
            model.addAttribute("errorMessage", "Token invalida");
            return "Login";
        }

        User user = userService.getUser(token);

        if (user == null){
            model.addAttribute("errorMessage", "Token invalida");
            return "Login";
        }
        model.addAttribute("token",token);
        return "PasswordReset";
    }

    @RequestMapping(value="/passwordResetConfirmation", method = RequestMethod.POST, params = {"token"})
    public String passwordResetConfirmation(@RequestParam("token") String token, Model model, HttpServletRequest request) {
        JSONObject log = new JSONObject();

        if (token == null){
            model.addAttribute("errorMessage", "Request Inválido");
            return "Login";
        }

        User user = userService.getUser(token);
        if (user == null){
            model.addAttribute("errorMessage", "Token invalida");
            return "Login";
        }

        String password = new PasswordResetValidator().passwordResetValidator(request);
        if (password == null){
            model.addAttribute("errorMessage", "Passwords did not Match");
            return "Login";
        }

        log     .append("ip" , request.getRemoteAddr())
                .append("email" , getEmail())
                .append("type", "PasswordReset");

        userService.updatePassword(user.setPassword(password));
        model.addAttribute("successRegister","Password Reset Successful");
        return "Login";
    }


    private String getEmail() {
        String userName;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) userName = ((UserDetails)principal).getUsername();
        else userName = principal.toString();

        return userName;
    }
}
