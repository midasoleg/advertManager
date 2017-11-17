package com.advertManager.controller;

import com.advertManager.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("app")
public class UserInfoController {

    @Autowired
    private IUserInfoService userInfoService;
    @GetMapping("login")
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("custom-login");
        return mav;
    }

    @GetMapping("secure/advert-details")
    public ModelAndView getAllUserAdverts(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("usersAdverts", userInfoService.getAllUserAdverts());
        mav.setViewName("adverts");
        return mav;
    }

    @GetMapping("error")
    public ModelAndView error(){
        ModelAndView mav = new ModelAndView();
        String errorMassage = "You are not authorized for the request data.";
        mav.addObject("errorMsg", errorMassage);
        mav.setViewName("403");
        return mav;
    }

}
