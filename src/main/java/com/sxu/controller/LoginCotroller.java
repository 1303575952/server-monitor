package com.sxu.controller;

import com.sxu.common.AppInit;
import com.sxu.entity.user.AccountInfo;
import com.sxu.util.shorturl.MD5;
import com.sxu.util.staticvar.StaticKeys;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/sys/login")
public class LoginCotroller {

    private static final Logger logger = LoggerFactory.getLogger(LoginCotroller.class);


    /**
     * 转向到登录页面
     *
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("toLogin")
    public String toLogin(Model model, HttpServletRequest request) {
        return "login/login";
    }

    /**
     * 登出系统
     *
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("loginOut")
    public String loginOut(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/sys/host/toLogin";
    }

    /**
     * 管理员登录验证
     *
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "login")
    public String login(Model model, HttpServletRequest request) {
        String userName = request.getParameter("userName");
        String passwd = request.getParameter("md5pwd");
        String code = request.getParameter(StaticKeys.SESSION_CODE);
        HttpSession session = request.getSession();
        try {
            if (!StringUtils.isEmpty(userName) && !StringUtils.isEmpty(passwd) && !StringUtils.isEmpty(code)) {
                if (!code.equals(session.getAttribute(StaticKeys.SESSION_CODE))) {
                    model.addAttribute("error", "验证码错误");
                    return "login/login";
                }
                AccountInfo accountInfo = new AccountInfo();
                if (MD5.GetMD5Code(AppInit.admindPwd).equals(passwd)) {
                    accountInfo.setAccount("admin");
                    accountInfo.setId("admin");
                    request.getSession().setAttribute(StaticKeys.LOGIN_KEY, accountInfo);
                    return "redirect:/sys/dash/main";
                }
            }
        } catch (Exception e) {
            logger.error("登录异常：", e);
        }
        model.addAttribute("error", "帐号或者密码错误");
        return "login/login";
    }

}