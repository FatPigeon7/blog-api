package com.fatpigeon.blog.dao;

import com.fatpigeon.blog.pojo.AdminPermission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminPermissionDao extends JpaRepository<AdminPermission, Integer> {
}
