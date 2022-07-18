package com.atguigu.crowd.service.impl;

import com.atguigu.crowd.entity.Admin;
import com.atguigu.crowd.mapper.AdminMapper;
import com.atguigu.crowd.service.api.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hy
 * @create 2022-07-17 16:04
 * @Description
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;

    @Override
    public List<Admin> getAll() {
        return adminMapper.selectByExample(null);
    }
}
