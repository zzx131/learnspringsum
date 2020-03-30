package com.zzx.shiro.controller;

import com.zzx.shiro.bean.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    public final String quStirng = "admin";

    @PostMapping("/login")
    public String login(User user) {
        //添加用户认证信息
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(
                user.getUsername(),
                user.getPassword()
        );
        try {
            //进行验证，这里可以捕获异常，然后返回对应信息
            subject.login(usernamePasswordToken);
//            subject.checkRole("admin");
//            subject.checkPermissions("query", "add");
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return "账号或密码错误！";
        } catch (AuthorizationException e) {
            e.printStackTrace();
            return "没有权限";
        }
        return "login success";
    }
    //注解验角色和权限
    @RequiresRoles(value={"T1","T2"},logical = Logical.OR)
    @RequiresPermissions("add")
    @RequestMapping("/index")
    public String index() {
        return "index!";
    }

    @GetMapping("/getSession")
    public void getSession(){
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        //这个参数用于判定会话不存在时是否创建新会话。
        //Session session = subject.getSession(boolean create);
        System.out.println(session.getAttribute("org.apache.shiro.subject.support.DefaultSubjectContext_PRINCIPALS_SESSION_KEY"));
    }
}
