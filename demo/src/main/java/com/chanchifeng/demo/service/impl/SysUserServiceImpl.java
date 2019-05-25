package com.chanchifeng.demo.service.impl;

import com.chanchifeng.demo.mapper.SysUserMapper;
import com.chanchifeng.demo.model.SysUser;
import com.chanchifeng.demo.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser getById(Long id) {
        return sysUserMapper.selectByPrimaryKey(id);
    }

}
