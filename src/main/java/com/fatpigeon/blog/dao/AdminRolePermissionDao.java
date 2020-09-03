package com.fatpigeon.blog.dao;

import com.fatpigeon.blog.pojo.AdminRolePermission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRolePermissionDao extends JpaRepository<AdminRolePermission, Integer> {
}
