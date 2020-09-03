package com.fatpigeon.blog.service;

import com.fatpigeon.blog.dao.AdminRolePermissionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminRolePermissionService {

    @Autowired
    AdminRolePermissionDao adminRolePermissionDao;
}
