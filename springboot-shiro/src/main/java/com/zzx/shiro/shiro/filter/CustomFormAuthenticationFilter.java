package com.zzx.shiro.shiro.filter;

import com.zzx.shiro.bean.User;
import com.zzx.shiro.service.LoginService;
import com.zzx.shiro.service.imp.LoginServiceImpl;
import com.zzx.shiro.util.SpringBeanUtil;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CustomFormAuthenticationFilter extends FormAuthenticationFilter {

    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request,
                                     ServletResponse response) throws Exception {
        LoginServiceImpl loginService = SpringBeanUtil.getBean(LoginServiceImpl.class);
        //获取已登录的用户信息
        String name = (String) subject.getPrincipal();
        User user = loginService.getUserByName(name);
        //获取session
        Session session = subject.getSession();
        //把用户信息保存到session
        session.setAttribute("activeUser", user);
        return true;
    }

}
