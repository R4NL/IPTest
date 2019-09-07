package com.aleshka.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ControllerForStart {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String start(HttpServletRequest httpServletRequest, Model model){
        model.addAttribute("host",httpServletRequest.getRemoteHost());
        model.addAttribute("ip",httpServletRequest.getRemoteAddr());
        return "startHTMLPage";
    }
}
