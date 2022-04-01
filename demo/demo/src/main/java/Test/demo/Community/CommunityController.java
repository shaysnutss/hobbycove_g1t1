package Test.demo.Community;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

import Test.demo.User.User;
import Test.demo.User.UserController;
import Test.demo.User.UserRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class CommunityController {

    @Autowired
    private UserController userController;
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private UserCommunitiesRepository userCommRepo;

    @Autowired
    private CommunityService commService;
    @Autowired
    private CommunityRepository commRepo;

    public static User loggedUser;
    public static Community community;

    @GetMapping("/getAllCommunities")
    public String getAllCommunities(Model model, Model comModel) {
        Community communityyy = new Community();
        comModel.addAttribute("communityyy", communityyy);
        List<Community> communityList = commRepo.findAll();
        model.addAttribute("communityList", communityList);
        return "allcommunities";
    }

    @GetMapping("/getUserCommunities")
    public String getMyCommunities(Model model, Model comModel) {
        Community communityyy = new Community();
        comModel.addAttribute("communityyy", communityyy);
        
        loggedUser = UserController.identity;
        List<UserCommunities> userCommunities = userCommRepo.findByUserId(loggedUser.getId());
        List<Community> communityList= new ArrayList<>();
        
        for (int i = 0; i < userCommunities.size(); i++){
        
            communityList.add(commRepo.getById(userCommunities.get(i).getCommunity_id()));
        }

        model.addAttribute("communityList", communityList);
        
        return "allmycommunities";
    }


    @GetMapping("/newCommunityForm")
    public String addNewCommunityForm(Model model) {
        Community community = new Community();
        loggedUser = UserController.identity;

        if (userRepo.findByEmail(loggedUser.getEmail()) != null) {
            model.addAttribute("community", community);
            return "createcommunity";
        }

        return "allcommunities";

    }

    @PostMapping("/createCommunity")
    public String saveCommunity(@ModelAttribute("community") Community community) {

        boolean check = false;
        loggedUser = UserController.identity;
        commService.saveCommunity(community);
        UserCommunities userCommunities = new UserCommunities(loggedUser.getId(), community.getId());
        userCommRepo.save(userCommunities);
        check = true;

        if (check) {
            return "redirect:/getUserCommunities";
        }

        return "homepage";

    }

    @PostMapping("/searchCommunities")
    public String searchCommunities(@ModelAttribute("name") String name, Model model){
        Community community = commRepo.findByName(name);
        if (community == null) {
            return "commerror";
        }
        List<Community> communityList = new ArrayList<>();
        communityList.add(community);
        model.addAttribute("communityList", communityList);
        return "searchcommunities";

    } 

}
