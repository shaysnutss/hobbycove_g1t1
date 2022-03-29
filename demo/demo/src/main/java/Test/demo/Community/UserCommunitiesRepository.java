package Test.demo.Community;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserCommunitiesRepository extends JpaRepository<UserCommunities, Long> {

    // void save(UserCommunities userCommunities);

    // @Query(value = "SELECT * FROM USER_COMMUNITIES u WHERE u.user_id = 1", nativeQuery = true)
    // List<Long> findCommunityIdByUserId(@Param("user_id") Long user_id);

    List<UserCommunities> findByUserId(Long userId);
    
}
