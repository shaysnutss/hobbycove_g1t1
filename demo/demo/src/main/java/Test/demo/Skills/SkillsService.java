package Test.demo.Skills;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List; 


@Service
@Transactional
public class SkillsService {

    @Autowired
    private SkillsRepository skillsRepo;

    public List<Skills> getAllSkills(){
        return skillsRepo.findAll();
    }
    public void saveUser(Skills skill){
        this.skillsRepo.save(skill); 
    }
}