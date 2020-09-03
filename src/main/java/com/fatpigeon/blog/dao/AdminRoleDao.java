package com.fatpigeon.blog.dao;

import com.fatpigeon.blog.pojo.AdminRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRoleDao extends JpaRepository<AdminRole, Integer> {
}
