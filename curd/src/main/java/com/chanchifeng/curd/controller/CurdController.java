package com.chanchifeng.curd.controller;

import com.chanchifeng.curd.model.SysUser;
import com.chanchifeng.curd.service.SysUserService;
import com.chanchifeng.curd.vo.PageVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/curdController")
public class CurdController {

    @Resource
    private SysUserService sysUserService;


    @GetMapping("/queryAll")
    public String queryAll(Model model) {

        List<SysUser> sysUsers = sysUserService.queryAll();
        System.out.println(sysUsers.size() + "!!");

        model.addAttribute("users",sysUsers);

        return "curd/index";
    }

    @RequestMapping("/delete/{userId}")
    public String delete(Model model,@PathVariable("userId") Long userId){

        //删除
        sysUserService.deleteByPrimaryKey(userId);

        return "redirect:/curdController/queryAll";
    }

    @RequestMapping("/queryById/{userId}")
    public String queryById(Model model,@PathVariable("userId") Long userId){

        model.addAttribute("user",sysUserService.selectByPrimaryKey(userId));

        return "curd/update";
    }

    @RequestMapping(value = "/update")
    public String update(SysUser sysUser) {

        System.out.println(sysUser.getSysUserId() + "!!");

        sysUserService.updateByPrimaryKeySelective(sysUser);

        return "redirect:/curdController/queryAll";
    }

    @RequestMapping(value = "/add")
    public String add(SysUser sysUser) {

        System.out.println(sysUser.getSysUserId() + "!!");

        sysUserService.insertSelective(sysUser);

        return "redirect:/curdController/queryAll";
    }


    /* START 模糊查询 & 分页 */

    @RequestMapping(value="/findAllJSON")
    @ResponseBody
    public PageVo<SysUser> findAllJson(SysUser sysUser, @RequestParam("page") int page,@RequestParam("limit") int limit){
        System.out.println("thisss??!");
        PageVo<SysUser> sysUserPageVo = sysUserService.selectAll(sysUser, page, limit);
        return sysUserPageVo;
    }

    /* END 模糊查询 & 分页 */
}
