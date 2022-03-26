package Test.demo.Explore;

import Test.demo.Skills.*;

import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

public class ExploreController {
    @Autowired
    private SkillsRepository skillsRepo;

    @GetMapping("/explore")
    public String explorePage() {
        return "allposts";
    }

    @GetMapping("/getAllSkills")
    public String exploreSkills(Model model) {
        List<Skills> skillsList = skillsRepo.findAll();
        model.addAttribute("skillsList", skillsList);
        return "skillslist";
    }

    @GetMapping("/getAllSkills/teacher")
    public String exploreSkills(Model model) {
        List<Skills> skillsList = skillsRepo.findAll();
        for
        model.addAttribute("skillsList", skillsList);
        return "skillslist";
    }
}
