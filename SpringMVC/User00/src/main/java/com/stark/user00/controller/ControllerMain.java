package com.stark.user00.controller;

import com.stark.user00.Service.ServiceUser;
import com.stark.user00.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by m on 10/02/2016.
 */
@Controller
public class ControllerMain {

    @Autowired
    private ServiceUser serviceUser;

    @RequestMapping("/searchUsers")
    public ModelAndView searchUsers(@RequestParam(required= false, defaultValue="") String name) {
        ModelAndView mav = new ModelAndView("showUsers");
        List<User> users = serviceUser.searchUsers(name.trim());
        mav.addObject("users", users);
        return mav;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String helloworld(ModelMap model) {
        model.addAttribute("message", "Hello world!");
        return "hello";
    }

    @RequestMapping(value = "/users_list", method = RequestMethod.GET)
    public ModelAndView allUsers() {
        ModelAndView modelAndView = new ModelAndView();
        List<User> users = serviceUser.getAll();
        modelAndView.addObject("users", users);
        modelAndView.setViewName("users_list");
        return modelAndView;
    }

    @RequestMapping(value= "/addUser", method = RequestMethod.POST)
    public String addUser(@ModelAttribute User u){
        if (u.getAdmin() != null){
            u.setAdmin(true);
        }
        if(u.getId() == 0){
            this.serviceUser.addUser(u);
        }else{
            this.serviceUser.updateUser(u);
        }
        return "redirect:/users_list";
    }

    @RequestMapping("/remove/{id}")
    public String removeUser(@PathVariable("id") int id){

        this.serviceUser.removeUser(id);
        return "redirect:/users_list";
    }

    @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
    public ModelAndView editUser(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("editpage");
        User user = serviceUser.getUserById(id);
        modelAndView.addObject("user",user);
        return modelAndView;
    }

    @RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
    public ModelAndView edditingUser(@ModelAttribute User user, @PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("editedpage");
        serviceUser.updateUser(user);
        String message = "User was successfully edited.";
        modelAndView.addObject("message", message);
        return modelAndView;
    }
}
