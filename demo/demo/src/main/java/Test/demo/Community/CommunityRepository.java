package Test.demo.Community;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommunityRepository extends JpaRepository<Community, Long> {

    // List<Users> findUsersByCommunityId(Long id);
    
}
