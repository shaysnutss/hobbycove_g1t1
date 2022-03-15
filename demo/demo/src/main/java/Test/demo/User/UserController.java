package Test.demo.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepo;

    @GetMapping("/signupForm")
    public String signup(Model model){
        User user = new User(); 
        model.addAttribute("user", user);
        return "signup"; 

    }

    @GetMapping("/loginForm")
    public String login(Model model){
        User user = new User(); 
        model.addAttribute("user", user);
        return "login"; 

    }


    @PostMapping("/saveUser")
    public String saveNewUser(@ModelAttribute("user") User user){
        userService.saveUser(user);
        return "redirect:/";

    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute("email") String email, @ModelAttribute("password") String password){

        if (userRepo.findByEmail(email) != null) {
            User u = userRepo.findByEmail(email);
            String password2 = u.getPassword();
            
            // checks if the password keyed in matches existing password
            if (password.equals(password2)) {
                return "redirect:/"; //redirect to home or profile later on
            }
         }
         return "login";
        

    }
}
