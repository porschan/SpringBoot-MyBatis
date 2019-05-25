package com.chanchifeng.curd.service.impl;

import com.chanchifeng.curd.mapper.SysUserMapper;
import com.chanchifeng.curd.model.SysUser;
import com.chanchifeng.curd.service.SysUserService;
import com.chanchifeng.curd.vo.PageVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser getById(Long id) {
        return sysUserMapper.selectByPrimaryKey(id);
    }

    /* START CURD */

    @Override
    public List<SysUser> queryAll() {
        return sysUserMapper.queryAll();
    }

    @Override
    public SysUser selectByPrimaryKey(Long sysUserId) {
        return sysUserMapper.selectByPrimaryKey(sysUserId);
    }

    @Override
    public int deleteByPrimaryKey(Long sysUserId) {
        return sysUserMapper.deleteByPrimaryKey(sysUserId);
    }

    @Override
    public int updateByPrimaryKeySelective(SysUser sysUser) {
        return sysUserMapper.updateByPrimaryKeySelective(sysUser);
    }

    @Override
    public int insertSelective(SysUser record) {
        return sysUserMapper.insertSelective(record);
    }
    /* END CURD */

    /* START 模糊搜索 + 分页*/

    @Override
    public PageVo<SysUser> selectAll(SysUser sysUser, int startIndex, int pageSize) {
        int totalNum;
        if(pageSize<=0){
            totalNum = pageSize;
        }else {
            totalNum = sysUserMapper.count(sysUser);
        }
        PageVo<SysUser> pageVo = new PageVo<>(startIndex,pageSize,totalNum);
        pageVo.setItems(sysUserMapper.selectAll(sysUser,pageVo.getStartIndex(),pageSize));
        pageVo.setTotalNum(totalNum);
        return pageVo;
    }

    /* END 模糊搜索 +  分页 */

}
