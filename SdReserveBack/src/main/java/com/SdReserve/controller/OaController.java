package com.SdReserve.controller;


import com.SdReserve.bean.OaBean;
import com.SdReserve.bean.SdBackResult;
import com.SdReserve.service.OaService;
import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;
import com.alibaba.fastjson.JSON;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangxz on 2017/7/26.
 */

@Controller
public class OaController {

    private static final Log logger = LogFactory.getLog(OaController.class);

    @Autowired
    OaService oaService;

    @RequestMapping(value = "/doLogin")
    public @ResponseBody
    ModelAndView doLogin(String oaAccount, String oaPwd, HttpServletRequest request, HttpServletResponse response){
        logger.info("doLogin========" + oaAccount + oaPwd);

        String msg = "";
        String userName = oaAccount;
        String password = oaPwd;
        int errorCode = -1;
        Map<String, Object> map = new HashMap<String, Object>();
        System.out.println(userName);
        System.out.println(password);
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        token.setRememberMe(true);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            errorCode = 0;
//            if (subject.isAuthenticated()) {
//                SecurityUtils.getSubject().getSession().setTimeout(30000);
//            }
        } catch (IncorrectCredentialsException e) {
            msg = "登录密码错误. Password for account " + token.getPrincipal() + " was incorrect.";
        } catch (ExcessiveAttemptsException e) {
            msg = "登录失败次数过多";
        } catch (LockedAccountException e) {
            msg = "帐号已被锁定. The account for username " + token.getPrincipal() + " was locked.";
        } catch (DisabledAccountException e) {
            msg = "帐号已被禁用. The account for username " + token.getPrincipal() + " was disabled.";
        } catch (ExpiredCredentialsException e) {
            msg = "帐号已过期. the account for username " + token.getPrincipal() + "  was expired.";
        } catch (UnknownAccountException e) {
            msg = "帐号不存在. There is no user with username of " + token.getPrincipal();
        } catch (UnauthorizedException e) {
            msg = "您没有得到相应的授权！" + e.getMessage();
        }
        System.out.println(msg);
        map.put("error", errorCode);
        map.put("msg", msg);
        if(errorCode == 0){
            return new ModelAndView("redirect:/html/loginSuccess2.ftl", map);
        }
        return new ModelAndView("redirect:/html/login.html", map);

//        OaBean oaAccount = oaService.getOaAccount(oaBean);
//        if(oaAccount==null){
//            return SdBackResult.getFailResult("用户不存在");
//        }else {
//            String oaPwd = oaAccount.getOaPwd();
//            if(oaPwd!=null && oaPwd.equals(oaBean.getOaPwd())){
//                User userByOaId = oaService.getUserByOaId(oaAccount.getOaId());
//                if(userByOaId == null){
//                    return SdBackResult.getSuccessResult("用户信息为空");
//                }
//                return SdBackResult.getSuccessResult(null);
//            }else{
//                return SdBackResult.getFailResult("密码错误", -2);
//            }
//        }
    }

    @RequestMapping("/doLogout")
    public @ResponseBody SdBackResult doLogout() {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            subject.logout(); // session 会销毁，在SessionListener监听session销毁，清理权限缓存
        }
        return SdBackResult.getSuccessResult("已经退出登录");
    }

    @RequestMapping("/test")
    public String test(Model model){
        model.addAttribute("name", "xiamo");
        model.addAttribute("age", 12);
        return "test";
    }
}
