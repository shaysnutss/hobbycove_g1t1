package Test.demo.Explore;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import Test.demo.Skills.Skills;

public interface ExploreRepository extends JpaRepository<Skills, Long> {

    
    
}
