package com.fatpigeon.blog.service;

import com.fatpigeon.blog.dao.AdminUserRoleDao;
import com.fatpigeon.blog.pojo.AdminUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminUserRoleService {
    @Autowired
    AdminUserRoleDao adminUserRoleDao;

    List<AdminUserRole> findAllByUid(int uid) {
        return adminUserRoleDao.findAllByUid(uid);
    }

}
