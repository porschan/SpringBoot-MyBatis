package com.chanchifeng.demo;

import com.chanchifeng.demo.model.SysUser;
import com.chanchifeng.demo.service.SysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Resource
    private SysUserService sysUserService;

    @Test
    public void contextLoads() {
        SysUser byId = sysUserService.getById(1L);
        System.out.println(byId.getSysUserLoginName());
    }

}
