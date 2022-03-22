package Test.demo.Skills;

import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springsframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

public class SkillsController {
    @Autowired
    private SkillsService skillService;
    
    @Autowired
    private SkillsRepository skillsRepo;

    @GetMapping("/skills")
    public String skillsPage(){
        return "allskills";
    }

    @GetMapping("/getAllSkills")
    public String getAllSkills(Model model) {
        List<Skills> skillsList = skillsRepo.findAll();
        model.addAttribute("skillsList", skillsList);
        return "skillslist";
    }

    
}
