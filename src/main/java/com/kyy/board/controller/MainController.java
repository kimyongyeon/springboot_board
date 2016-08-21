package com.kyy.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yongyeonkim on 2016. 8. 21..
 */
@Controller
public class MainController {

    @RequestMapping(value = "/test")
    public String testPage(Model model) {
        model.addAttribute("name", "study...");
        System.out.println("test 페이지 입니다 222222 ");
        return "test";
    }
}
