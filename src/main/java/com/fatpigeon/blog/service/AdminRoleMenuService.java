package com.fatpigeon.blog.service;

import com.fatpigeon.blog.dao.AdminRoleMenuDao;
import com.fatpigeon.blog.pojo.AdminRoleMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminRoleMenuService {

    @Autowired
    AdminRoleMenuDao adminRoleMenuDao;

    public List<AdminRoleMenu> findAllByRid(int rid) {
        return adminRoleMenuDao.findAllByRid(rid);
    }

    public List<AdminRoleMenu> findAllByRidIn(List<Integer> rids) {
        return adminRoleMenuDao.findAllByRidIn(rids);
    }

}
