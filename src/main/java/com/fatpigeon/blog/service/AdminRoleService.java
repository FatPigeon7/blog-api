package com.fatpigeon.blog.service;

import com.fatpigeon.blog.dao.AdminRoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminRoleService {

    @Autowired
    AdminRoleDao adminRoleDao;
}
