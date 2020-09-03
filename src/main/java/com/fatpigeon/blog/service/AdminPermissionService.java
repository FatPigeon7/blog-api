package com.fatpigeon.blog.service;

import com.fatpigeon.blog.dao.AdminPermissionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminPermissionService {

    @Autowired
    AdminPermissionDao adminPermissionDao;
}
