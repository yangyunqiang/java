package com.example.server01.service;

import com.example.server01.mapper.TbUserMapper;
import com.example.server01.pojo.po.TbUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TbUserServiceImpl implements TbUserService {

    @Resource
    private TbUserMapper tbUserMapper;

    @Override
    public void doUserInsert() {

        TbUser tbUser = new TbUser();
        tbUser.setUserid(2);
        tbUser.setUsername("2");
        tbUserMapper.insert(tbUser);
        doUserInsert2();

    }

    public void doUserInsert2() {

        TbUser tbUser = new TbUser();
        tbUser.setUserid(4);
        tbUser.setUsername("111");
        tbUserMapper.insert(tbUser);
    }

}

