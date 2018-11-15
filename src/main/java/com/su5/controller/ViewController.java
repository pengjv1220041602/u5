package com.su5.controller;

import com.su5.entry.Goods;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    @RequestMapping(path = "/view")
    public String view () {
        return "/view";
    }

    @RequestMapping({"/"})
    public String viewModel (Model model) {
        model.addAttribute(new Goods("1", "2", 1));
        return "/view";
    }
}
