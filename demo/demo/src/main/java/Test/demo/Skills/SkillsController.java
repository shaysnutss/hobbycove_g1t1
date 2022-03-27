package Test.demo.Skills;

import java.util.*;
import Test.demo.User.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Controller
@ControllerAdvice
public class SkillsController {

    @Autowired
    private UserController userController;
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private SkillsService skillsService;
    @Autowired
    private SkillsRepository skillsRepo;

    public static User user;

    @GetMapping("/addSkill")
    public String addSkill(Model model) {
        user = UserController.identity;
        model.addAttribute("user", user);
        model.addAttribute("name", user.getName());
        model.addAttribute("role", user.getRole());
        model.addAttribute("skillsList", user.getSkills());

        Skills skill = new Skills();
        model.addAttribute("skill", skill);
        return "addskill";
    }

    @PostMapping("/saveSkill")
    public String saveSkill(Model model, @ModelAttribute("skill") Skills skill) {
        user = UserController.identity;
        model.addAttribute("user", user);
        model.addAttribute("name", user.getName());
        model.addAttribute("role", user.getRole());
        model.addAttribute("skillsList", user.getSkills());
        
        skillsService.addSkills(user, skill);
         return "redirect:profile";

    }
}