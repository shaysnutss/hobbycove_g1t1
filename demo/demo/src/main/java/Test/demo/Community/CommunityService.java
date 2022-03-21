package Test.demo.Community;


import org.springframework.beans.factory.annotation.*;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List; 

@Service
@Transactional
public class CommunityService {

    @Autowired
    private CommunityRepository commRepo;

    public void saveCommunity(Community community){
        this.commRepo.save(community); 
    }
    
}
