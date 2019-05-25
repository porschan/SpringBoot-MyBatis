package com.chanchifeng.curd.controller;

import com.chanchifeng.curd.model.SysUser;
import com.chanchifeng.curd.service.SysUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/sysUserController")
public class SysUserController {

    @Resource
    private SysUserService sysUserService;

    @RequestMapping("/showUserToJspById/{userId}")
    @ResponseBody
    public SysUser showUser(Model model, @PathVariable("userId") Long userId){
        SysUser user = sysUserService.getById(userId);

        return user;
    }
}
