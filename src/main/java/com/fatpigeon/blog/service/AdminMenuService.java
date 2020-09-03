package com.fatpigeon.blog.service;

import com.fatpigeon.blog.dao.AdminMenuDao;
import com.fatpigeon.blog.pojo.AdminMenu;
import com.fatpigeon.blog.pojo.AdminRoleMenu;
import com.fatpigeon.blog.pojo.AdminUserRole;
import com.fatpigeon.blog.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminMenuService {

    @Autowired
    AdminMenuDao adminMenuDao;
    @Autowired
    AdminUserRoleService adminUserRoleService;
    @Autowired
    AdminRoleMenuService adminRoleMenuService;
    @Autowired
    UserService userService;

    public List<AdminMenu> getAllByParentId(int parentId) {
        return adminMenuDao.findAllByParentId(parentId);
    }

    /**
     * 查询出当前用户的所有菜单
     * @return
     */
    public List<AdminMenu> getMenusByCurrentUser() {
        // 从数据库中获取当前用户
        String username = SecurityUtils.getSubject().getPrincipal().toString();
        User user = userService.getByName(username);

        // 获得当前用户对应的所有角色的 id 列表
        List<Integer> rids = adminUserRoleService.findAllByUid(user.getId())
                .stream().map(AdminUserRole::getRid).collect(Collectors.toList());

        // 查询出这些角色对应的所有菜单项
        List<Integer> menuIds = adminRoleMenuService.findAllByRidIn(rids)
                .stream().map(AdminRoleMenu::getMid).collect(Collectors.toList());
        List<AdminMenu> menus = adminMenuDao.findAllById(menuIds).stream().distinct().collect(Collectors.toList());

        // 处理菜单的结构
        handleMenus(menus);
        return menus;
    }

    private void handleMenus(List<AdminMenu> menus) {
        menus.stream().forEach( m -> {
            List<AdminMenu> children = getAllByParentId(m.getId());
            m.setChildren(children);
        });

        menus.removeIf(m -> m.getParentId() != 0);
    }

}
