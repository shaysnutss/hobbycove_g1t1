package Test.demo.Skills;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.PagingAndSortingRepository;

@Repository
public interface SkillsRepository extends PagingAndSortingRepository<Skills, String>,
        JpaSpecificationExecutor<Skills> {

    // define a derived query to find user by skill
    //List<Skills> findBySkill(String skills);
}
