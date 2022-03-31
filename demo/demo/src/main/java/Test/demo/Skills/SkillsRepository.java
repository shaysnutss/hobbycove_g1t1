package Test.demo.Skills;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface SkillsRepository extends JpaRepository<Skills, Long> {
    Skills findById(long id);

    @Modifying
    @Query(value = "delete from skills s where s.skill_id=:id", nativeQuery = true)
    void deleteSkillById(@Param("id") Long id);

}

