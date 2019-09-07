package com.aleshka.demo.controller;

import com.aleshka.demo.entity.User;
import com.aleshka.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ControllerForStart {
    private UserRepository userRepository;

    @Autowired
    public ControllerForStart(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ControllerForStart() {
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String start(HttpServletRequest httpServletRequest, Model model) {
        User user = new User(httpServletRequest.getRemoteAddr(), httpServletRequest.getRemotePort());
        List<User> userList = userRepository.findAll();
        if (userList.size() != 0) {
            if (!userList.contains(user)) {
                userRepository.save(user);
            }
        } else {
            userRepository.save(user);
        }
        model.addAttribute("users",userList);
        model.addAttribute("port", user.getPort());
        model.addAttribute("ip", user.getIp());
        return "startHTMLPage";
    }
}
