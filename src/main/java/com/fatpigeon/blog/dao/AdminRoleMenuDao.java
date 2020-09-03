package com.fatpigeon.blog.dao;

import com.fatpigeon.blog.pojo.AdminRoleMenu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminRoleMenuDao extends JpaRepository<AdminRoleMenu, Integer> {
    List<AdminRoleMenu> findAllByRid(int rid);
    List<AdminRoleMenu> findAllByRidIn(List<Integer> rids);
}
