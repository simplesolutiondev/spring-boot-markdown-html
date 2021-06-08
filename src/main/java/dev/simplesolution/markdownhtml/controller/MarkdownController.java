package dev.simplesolution.markdownhtml.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dev.simplesolution.markdownhtml.service.HtmlService;

@Controller
public class MarkdownController {

    @Autowired
    private HtmlService htmlService;

    @GetMapping("/")
    public String index() {
        return "edit";
    }

    @PostMapping("/view")
    public ModelAndView view(@RequestParam String markdown) {
        ModelAndView modelAndView = new ModelAndView("view");
        String htmlContent = htmlService.markdownToHtml(markdown);
        modelAndView.addObject("markdown", markdown);
        modelAndView.addObject("htmlContent", htmlContent);
        return modelAndView;
    }
}