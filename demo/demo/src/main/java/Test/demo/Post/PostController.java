package Test.demo.Post;

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

import Test.demo.Community.Community;
import Test.demo.Community.CommunityRepository;
import Test.demo.User.User;
import Test.demo.User.UserController;
import Test.demo.User.UserRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PostController {

    // @Autowired
    // private UserController userController;
    // @Autowired
    // private UserRepository userRepo;
    @Autowired
    private PostRepository postRepo;
    @Autowired
    private CommunityRepository commRepo;


    // public static User loggedUser;
    public static Community community;

    @PostMapping("/savePost")
    public String saveCommunity(@ModelAttribute("post") Post post, Model model) {

        // model.addAttribute("post", new Post());
        post.setCommunityId(community.getId());
        postRepo.save(post);
        return "redirect:/getPosts";

    }

    @GetMapping("/getPosts")
    public String getPostsByCommunity(Model model, Model postModel) {
        Post posttt = new Post();
        postModel.addAttribute("posttt", posttt);

        List<Post> postList = postRepo.findAllByCommunityId(community.getId());
        model.addAttribute("postList", postList);
        return "entercommunity";
    }

    // @GetMapping("/getPosts/{id}")
    @GetMapping("/getPosts/{id}")
    public String getPostsByCommunity(@PathVariable(value = "id") String id, Model model) {

        community = commRepo.getById(Long.parseLong(id));
        return "redirect:/getPosts";

    }


}
