package itc.hoseo.springproject.controller;

import itc.hoseo.springproject.domain.Post;
import itc.hoseo.springproject.domain.UploadFile;
import itc.hoseo.springproject.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MainController {

    @Autowired
    PostService postService;

    @RequestMapping(value = "/")
    public String rootPage(ModelMap mm) {
        List<Post> bestPost = null;
        List<Post> popularPhoto = null;
        List<Post> popularTraveler = null;

        List<Post> mainPosts = postService.postList().stream()
                .filter(p -> {
                    return p.getUploadPhotos().size() > 0;
                })
                .sorted(Comparator.comparing(Post::getUpload_date).reversed())
                .collect(Collectors.toList());

        if(mainPosts.size() > 4) {
            bestPost = mainPosts.subList(0, 4);
        }
        if(mainPosts.size() > 20) {
            popularPhoto = mainPosts.subList(0, 20);
        }else {
            popularPhoto = mainPosts;
        }
        mm.put("bestPosts", bestPost);
        mm.put("popularPhotos", popularPhoto);

        return "main";
    }

    @RequestMapping(value = "/main")
    public String main() {
        return "main";
    }
}
