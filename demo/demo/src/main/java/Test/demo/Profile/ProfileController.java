package Test.demo.Profile;

import Test.demo.User.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {

    @Autowired
    private UserController userController;
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private ProfileService profileService;
    @Autowired
    private ProfileRepository profileRepo;

    public static User user;

    @GetMapping("/profile")
	public String profilePage(Model model) {
        user = UserController.identity;
        model.addAttribute("user", user);
        model.addAttribute("name", user.getName());
        model.addAttribute("role", user.getRole());
        // model.addAttribute("location", user.getLocation());
        // model.addAttribute("instagram", user.getInstagram());
		return "profile";
	} 

    @GetMapping("/editProfile")
    public String editProfile(Model model) {
        return "editprofile";
    }
    
}
