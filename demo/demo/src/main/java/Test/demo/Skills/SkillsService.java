package Test.demo.Skills;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.List;


@Service
@Transactional
public class SkillsService {

    @Autowired
    private SkillsRepository skillsRepo;

    public List<Skills> getAllSkills(){
        Iterable<Skills> iterable = skillsRepo.findAll();
        List<Skills> result = new ArrayList<Skills>();
        while (iterable.iterator().hasNext()) {
            result.add(iterable.iterator().next());
        }
        return result;
        //return skillsRepo.findAll();
    }
    
    public void saveSkill(Skills skill){
        this.skillsRepo.save(skill);
    }
}