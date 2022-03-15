package Test.demo.User;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List; 


@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public List<User> getAllUsers(){
        return userRepo.findAll();
    }
    public void saveUser(User user){
        this.userRepo.save(user); 
    }

    
}
