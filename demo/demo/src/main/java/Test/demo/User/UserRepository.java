package Test.demo.User;

import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, String> {
    // define a derived query to find user by email
    User findByEmail(String email);

    @Query("SELECT a FROM User a WHERE role = ?1")
    List<User> findAllByRole(String role);

    @Query("SELECT a FROM User a WHERE user_id = ?1")
    User findByUserId(Long id);

    @Query("SELECT a FROM User a WHERE name = ?1 OR location = ?1")
    User findByName(String name);
}