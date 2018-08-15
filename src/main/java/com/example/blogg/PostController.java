package com.example.blogg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class PostController {
    @Autowired
    private PostRepository postRepository;

    private UserController userController;
BloggPagination bloggList;
    @PostMapping("/bloggposts")
    public String postpost(Model model, users users, posts posts, HttpServletRequest request) {
        int userID = userController.getUserId();
        postRepository.save(posts);
        return "bloggposts";
    }

    @GetMapping("/bloggposts")
    public String getPost(Model model, users users, posts posts, HttpServletRequest request) {
        int userID = userController.getUserId();
        List<posts> allPosts = postRepository.findAllByUserID(userID);
        List <posts> paginationList = bloggList.getPostForPage()
        for (int i = 0; i < allPosts.size(); i++) {
            System.out.println(allPosts.get(i).getHeadline());
        }
        return ("/bloggposts");
    }
}
