/*
 * All rights Reserved, Copyright (C) Aisino LIMITED 2018
 * FileName: WebConfig.java
 * Version:  $Revision$
 * Modify record:
 * NO. |     Date       |    Name         |      Content
 * 1   | 2019年1月16日        | Aisino)Jack    | original version
 */
package com.hhit.wificar.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hhit.wificar.mapper.UserMapper;
import com.hhit.wificar.model.ResultMap;
import com.hhit.wificar.service.LoginService;

/**
 * class name:LoginController <BR>
 * class description: 登录操作 <BR>
 * Remark: <BR>
 * @version 1.00 2019年1月16日
 * @author Aisino)weihaohao
 */
@RestController
public class LoginController {
	@Autowired
    private ResultMap resultMap;
	@Autowired
    private UserMapper userMapper;
    @Autowired
    private LoginService loginService;

/*    @Autowired
    public LoginController(ResultMap resultMap, UserMapper userMapper) {
        this.resultMap = resultMap;
        this.userMapper = userMapper;
    }*/

    @RequestMapping(value = "/notLogin", method = RequestMethod.GET)
    public ResultMap notLogin() {
        return resultMap.success().message("您尚未登陆！");
    }

    @RequestMapping(value = "/notRole", method = RequestMethod.GET)
    public ResultMap notRole() {
        return resultMap.success().message("您没有权限！");
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ResultMap logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return resultMap.success().message("成功注销！");
    }

    /**
     * Method name: login <BR>
     * Description: 登录 <BR>
     * Remark: <BR>
     * @param username 用户名
     * @param password 密码
     * @return  ResultMap<BR>
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ResultMap login(String username, String password) {
    	return loginService.login(username, password);
    }
}
