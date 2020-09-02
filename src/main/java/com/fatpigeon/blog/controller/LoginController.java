package com.fatpigeon.blog.controller;

import com.fatpigeon.blog.pojo.User;
import com.fatpigeon.blog.result.Result;
import com.fatpigeon.blog.result.ResultFactory;
import com.fatpigeon.blog.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpSession;

@RestController
public class LoginController {

    @Autowired
    UserService userService;

    @PostMapping("api/register")
    public Result register(@RequestBody User user) {
        String username = user.getUsername();
        username = HtmlUtils.htmlEscape(username);
        user.setUsername(username);
        String password = user.getPassword();

        boolean isExist = userService.isExist(username);
        if (isExist) {
            String message = "用户名已被使用";
            return ResultFactory.buildFailResult(message);
        }

        // 生成盐，默认长度16位
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        // 设置 hash 算法迭代次数
        int times = 2;
        // 得到hash后的密码
        String encodedPassword = new SimpleHash("md5", password, salt, times).toString();

        // 存储用户信息，包括 salt 和 hash 后的密码
        user.setSalt(salt);
        user.setPassword(encodedPassword);
        userService.add(user);

        return ResultFactory.buildSuccessResult(user);
    }

    @PostMapping(value = "api/login")
    public Result login(@RequestBody User requestUser, HttpSession session) {
        String username = requestUser.getUsername();
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, requestUser.getPassword());
        try {
            subject.login(usernamePasswordToken);
            return ResultFactory.buildSuccessResult(username);
        } catch (IncorrectCredentialsException e) {
            return ResultFactory.buildFailResult("密码错误");
        } catch (UnknownAccountException e) {
            return ResultFactory.buildFailResult("账号不存在");
        }
    }

    @GetMapping("api/logout")
    public Result logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        String message = "成功登出";
        return ResultFactory.buildSuccessResult(message);
    }

}
