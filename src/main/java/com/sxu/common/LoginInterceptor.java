package com.sxu.common;

import com.sxu.util.staticvar.StaticKeys;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    String[] static_resource = {"login/toLogin", "login/login", "sys/code", ".css", ".js", ".jpg", ".png", ".ico", ".gif", "font"};

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        String uri = request.getRequestURI();
        for (String ss : static_resource) {
            if (uri.indexOf(ss) != -1) {
                return true;
            }
        }
        Object user = request.getSession().getAttribute(StaticKeys.LOGIN_KEY);
        if (user != null) {
            return true;
        }
        response.sendRedirect("/wgcloud/sys/login/toLogin");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}