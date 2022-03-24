package Test.demo.Profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {

    // @Autowired
    // private ProfileService profileService;
    // @Autowired
    // private ProfileRepository profileRepo;

    @GetMapping("/profile")
	public String profilePage() {
		return "profile";
	} 
    
}
