/*
 * All rights Reserved, Copyright (C) Aisino LIMITED 2018
 * FileName: ControllerMain.java
 * Version:  $Revision$
 * Modify record:
 * NO. |     Date       |    Name         |      Content
 * 1   | 2019年1月14日        | Aisino)Jack    | original version
 */
package com.hhit.wificar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * class name:ControllerMain <BR>
 * class description: please write your description <BR>
 * Remark: <BR>
 * @version 1.00 2019年1月14日
 * @author Aisino)weihaohao
 */
@Controller
public class ControllerMain {
	
	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}
}
