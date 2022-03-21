package Test.demo.Community;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserCommunitiesRepository extends JpaRepository<Community, Long> {

    void save(UserCommunities userCommunities);

    @Query(value = "select c.* from User_Communities c where c.user_id = :user_id", nativeQuery = true)
    List<Long> findCommunityIdByUserId(@Param("user_id") Long user_id);
    
}
