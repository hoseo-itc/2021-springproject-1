package itc.hoseo.springproject.controller;

import itc.hoseo.springproject.service.LikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class LikesController {

    @Autowired
    private LikesService likesService;
}
