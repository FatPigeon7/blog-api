package com.fatpigeon.blog.dao;

import com.fatpigeon.blog.pojo.AdminUserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminUserRoleDao extends JpaRepository<AdminUserRole, Integer> {
    List<AdminUserRole> findAllByUid(int uid);
}
