package com.chanchifeng.curd;

import com.chanchifeng.curd.model.SysUser;
import com.chanchifeng.curd.service.SysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CurdApplicationTests {

    @Resource
    private SysUserService sysUserService;

    @Test
    public void contextLoads() {
        SysUser byId = sysUserService.getById(1L);
        System.out.println(byId.getSysUserLoginName());
    }

}