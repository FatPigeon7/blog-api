package com.fatpigeon.blog.dao;

import com.fatpigeon.blog.pojo.AdminMenu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminMenuDao extends JpaRepository<AdminMenu, Integer> {
    List<AdminMenu> findAllByParentId(int parentId);
}
