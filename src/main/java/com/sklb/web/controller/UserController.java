package com.sklb.web.controller;

import com.sklb.web.common.AjaxResult;
import com.sklb.web.model.User;
import com.sklb.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: lingjunhao
 * create at:  2019-06-10  13:02
 * @description: 用户Controller
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/queryList")
    public AjaxResult queryList(){
        return userService.queryList();
    }

    @ResponseBody
    @RequestMapping("/addUser")
    public AjaxResult addUser(User user){
        return userService.save(user);
    }

    @ResponseBody
    @RequestMapping("/delUser")
    public AjaxResult delUser(Integer[] ids){
        return userService.batchDelete(ids);
    }

    @ResponseBody
    @RequestMapping("/updateUser")
    public AjaxResult updateUser(User user){
        return userService.update(user);
    }

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(ModelMap map){
        map.put("title","你好");
        return "index";
    }




}
