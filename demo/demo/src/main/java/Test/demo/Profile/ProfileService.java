package Test.demo.Profile;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProfileService {
    
    @Autowired
    private ProfileRepository profileRepo;

    public List<Profile> getAllProfiles() {
        return profileRepo.findAll();
    }

    public void saveProfile(Profile profile) {
        this.profileRepo.save(profile);
    }
}
