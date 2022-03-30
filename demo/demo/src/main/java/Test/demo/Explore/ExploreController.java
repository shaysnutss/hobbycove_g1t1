package Test.demo.Explore;

import Test.demo.Skills.*;
import Test.demo.User.*;
import Test.demo.User.UserRepository;

import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.*;

@Controller
public class ExploreController {
    @Autowired
    private SkillsRepository skillsRepo;
    @Autowired
    private UserRepository userRepo;

    public static User user;

    @GetMapping("/explore")
    public String getAllTeachers(Model model, Model expModel) {
        User userrr = new User();
        expModel.addAttribute("userrr", userrr);

        List<User> userList = userRepo.findAllByRole("Teacher");
        model.addAttribute("userList", userList);
        return "explorepage";
    }

    @GetMapping("/goToProfile/{id}")
	public String profilePage(@PathVariable(name = "id") String id, Model model) {
        user = userRepo.findByUserId(Long.parseLong(id));
        model.addAttribute("user", user);
        model.addAttribute("name", user.getName());
        model.addAttribute("role", user.getRole());
        model.addAttribute("skillsList", user.getSkills());

        return "redirect:/goToProfile";
    
	} 

    @GetMapping("/goToProfile")
    public String getPostsByCommunity(Model model, Model expModel) {
        User userrr = new User();
        expModel.addAttribute("userrr", userrr);

        model.addAttribute("user", user);
        model.addAttribute("name", user.getName());
        model.addAttribute("role", user.getRole());
        model.addAttribute("skillsList", user.getSkills());
        return "teacherprofile";
    }
}
