/*
 * All rights Reserved, Copyright (C) Aisino LIMITED 2018
 * FileName: WebConfig.java
 * Version:  $Revision$
 * Modify record:
 * NO. |     Date       |    Name         |      Content
 * 1   | 2019年1月16日        | Aisino)Jack    | original version
 */
package com.hhit.wificar.controller;

import org.apache.shiro.authc.AccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hhit.wificar.model.ResultMap;

/**
 * class name:ExceptionController <BR>
 * class description: 异常处理Controller <BR>
 * Remark: <BR>
 * @version 1.00 2019年1月16日
 * @author Aisino)weihaohao
 */
@RestControllerAdvice
public class ExceptionController {
    private final ResultMap resultMap;

    @Autowired
    public ExceptionController(ResultMap resultMap) {
        this.resultMap = resultMap;
    }

    /**
     * Method name: handleShiroException <BR>
     * Description: 捕捉 CustomRealm 抛出的异常 <BR>
     * Remark: <BR>
     * @param ex
     * @return  ResultMap<BR>
     */
    @ExceptionHandler(AccountException.class)
    public ResultMap handleShiroException(Exception ex) {
        return resultMap.fail().message(ex.getMessage());
    }
}
