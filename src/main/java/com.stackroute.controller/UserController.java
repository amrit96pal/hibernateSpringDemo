package com.stackroute.controller;


import com.stackroute.dao.UserDao;
import com.stackroute.model.UserInformation;
import com.stackroute.service.userServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class UserController {

    userServiceImp userservice= new userServiceImp();

    @Autowired
    UserDao userDaoImp;


    @GetMapping
    public String firstControl(){
        return "index";
    }

    @PostMapping("populate")
    public ModelAndView secondView(@RequestParam("username") String UserName, @RequestParam("password") String Password){
        UserInformation user =userservice.populateUser(UserName,Password);
        userDaoImp.saveData(user);
        ModelAndView mv= new ModelAndView();
        mv.setViewName("show");
        mv.addObject("obj",user.getUsername());
        return mv;
    }
}
