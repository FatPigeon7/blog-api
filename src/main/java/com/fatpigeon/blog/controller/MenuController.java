package com.fatpigeon.blog.controller;

import com.fatpigeon.blog.pojo.AdminMenu;
import com.fatpigeon.blog.service.AdminMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MenuController {

    @Autowired
    AdminMenuService adminMenuService;

    @RequestMapping("/api/menu")
    public List<AdminMenu> menu() {
        return adminMenuService.getMenusByCurrentUser();
    }

}
