package Test.demo.Skills;

import java.util.*;
import Test.demo.User.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SkillsService {
    
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private UserService userService;

    @Autowired
    private SkillsRepository skillsRepo;

    public List<Skills> getAllSkills() {
        return skillsRepo.findAll();
    }

    public void addSkills(User user, Skills skill) {
        skill.setUser(user);
        List<Skills> temp = user.getSkills();
        temp.add(skill);
        user.setSkills(temp);
        this.userRepo.save(user);
    }
}
