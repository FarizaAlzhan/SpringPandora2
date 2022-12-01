package kz.narxoz.springpandora2.Controller;

import kz.narxoz.springpandora2.Entity.Auth.Users;
import kz.narxoz.springpandora2.Service.CategoryService;
import kz.narxoz.springpandora2.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired

    private CategoryService categoryService;


    @GetMapping(value = "/")
    public String homepage(Model model){

        model.addAttribute("category", categoryService.findAllCategory());
        return "Home";
    }

    @GetMapping(value = "/403")
    public String accessDenied(Model model){

        return "403";
    }

    @GetMapping(value = "/login")
    public String login(){
        return "login";
    }

    @GetMapping(value = "/welcome")
    @PreAuthorize("isAuthenticated()")
    public String welcome(Model model){

        model.addAttribute("currentUser", getUserData());
        return "welcome";
    }


    @GetMapping(value = "/administration")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String addnewthing(){

        return "administration";
    }

    @GetMapping(value = "/register")
    public String register(Model model){
        model.addAttribute("currentUser", getUserData());
        return "register";
    }

    @PostMapping(value = "/register")
    public String toRegister(@RequestParam(name = "user_email") String email,
                             @RequestParam(name = "user_full_name") String fullName,
                             @RequestParam(name = "user_password") String password,
                             @RequestParam(name = "re_user_password") String Repassword
                             ) {

        if (password.equals(Repassword)){

            Users newUser = new Users();
            newUser.setFull_name(fullName);
            newUser.setPassword(password);
            newUser.setEmail(email);
            if (userService.createUser(newUser)!=null){
                return "redirect:/register?success";
            }

        }
        return "redirect:/register?error";

    }
    private Users getUserData(){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
                if(!(authentication instanceof AnonymousAuthenticationToken)){

                    User secUser = (User)authentication.getPrincipal();

                    Users myUser = userService.getUserByEmail(secUser.getUsername());

                    return  myUser;
                }
                return null;
    }


}
