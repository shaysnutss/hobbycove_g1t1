package Test.demo.Community;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

import Test.demo.User.User;
import Test.demo.User.UserController;
import Test.demo.User.UserRepository;

import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/getAllCommunities")
    public String getAllCommunities(Model model) {
        List<Community> communityList = commRepo.findAll();
        model.addAttribute("communityList", communityList);
        return "communitieslist";
    }

    @GetMapping("/getMyCommunities")
    public String getMyCommunities(Model model) {
        loggedUser = UserController.identity;
        List<Long> communityIds = userCommRepo.findCommunityIdByUserId(loggedUser.getId());
        List<Community> communityList = new ArrayList<>();

        for (int i = 0; i < communityIds.size(); i++){
            Community community = commRepo.getById(communityIds.get(i));
            communityList.add(community);
        }

        model.addAttribute("communityList", communityList);
        return "mycommunitieslist";
    }

    @GetMapping("/newCommunityForm")
    public String addNewCommunityForm(Model model) {
        Community community = new Community();
        loggedUser = UserController.identity;

        if (userRepo.findByEmail(loggedUser.getEmail()) != null) {
            model.addAttribute("community", community);
            return "testcomm";
        }

        return "homepage";

    }

    @PostMapping("/saveCommunity")
    public String saveCommunity(@ModelAttribute("community") Community community) {

        loggedUser = UserController.identity;
        commService.saveCommunity(community);
        UserCommunities userCommunities = new UserCommunities(loggedUser.getId(), community.getId());
        userCommRepo.save(userCommunities);

        return "homepage";

    }

    @PostMapping("/joinCommunity")
    public String joinCommunity(@ModelAttribute("community") Community community) {

        loggedUser = UserController.identity;
        commService.saveCommunity(community);
        UserCommunities userCommunities = new UserCommunities(loggedUser.getId(), community.getId());
        userCommRepo.save(userCommunities);

        return "homepage";

    }

    // leave community, only delete from the user_communities table
    // @RequestMapping(path = "/unsubscribe")
    // public String deleteSubscription(HttpServletRequest request, Model model) {
    //     Long subId = Long.parseLong(request.getParameter("id"));
    //     subscriptionService.deleteById(subId);

    //     return "redirect:/subscriptions";
    // }
}
