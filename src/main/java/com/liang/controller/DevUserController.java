package com.liang.controller;

import com.liang.pojo.DevUser;
import com.liang.service.DevUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/dev")
public class DevUserController {

    public static final Logger LOGGER = LoggerFactory.getLogger(DevUserController.class);

    @Autowired
    DevUserService devUserService;

    @RequestMapping("/toLogin")
    public String toLogin(){return "dev/login";}
    @RequestMapping("/login")
    public String login(DevUser devUser, Model model, HttpSession session){
        devUser = devUserService.login(devUser);
        if(devUser !=null){
            session.setAttribute("devUser",devUser);
            return "dev/index";
        }
        model.addAttribute("Msg","登陆失败");
        return "dev/login";
    }

    @RequestMapping("logOut")
    public String LogOut(HttpSession session){
        LOGGER.warn("devUser----------------session:",session.getAttribute("devUser"));
        session.removeAttribute("devUser");
//        session.invalidate();
        return "redirect:/";
    }

}
