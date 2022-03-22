package Test.demo.Skills;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

@Repository
public interface SkillsRepository extends JpaRepository<Skills, String>{

    // define a derived query to find user by skill
    List <Long> findBySkill(String skills);
}

