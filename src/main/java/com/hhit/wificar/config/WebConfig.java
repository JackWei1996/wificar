/*
 * All rights Reserved, Copyright (C) Aisino LIMITED 2018
 * FileName: WebConfig.java
 * Version:  $Revision$
 * Modify record:
 * NO. |     Date       |    Name         |      Content
 * 1   | 2019年1月2日        | Aisino)Jack    | original version
 */
package com.hhit.wificar.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hhit.wificar.filter.TimeFilter;
import com.hhit.wificar.listener.ListenerTest;

/**
 * class name:WebConfig <BR>
 * class description: 全局配置文件 <BR>
 * Remark: <BR>
 * @version 1.00 2019年1月2日
 * @author Aisino)weihaohao
 */
@Configuration
public class WebConfig {
	/**
	 * Method name: timeFilter <BR>
	 * Description: 配置过滤器 <BR>
	 * Remark: <BR>
	 * @return  FilterRegistrationBean<BR>
	 */
	@Bean
	public FilterRegistrationBean timeFilter() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		
		TimeFilter timeFilter = new TimeFilter();
		registrationBean.setFilter(timeFilter);
		
		List<String> urls = new ArrayList<>();
		urls.add("/*");
		registrationBean.setUrlPatterns(urls);
		
		return registrationBean;
	}
	/**
	 * 
	 * Method name: servletListenerRegistrationBean <BR>
	 * Description: 配置监听器<BR>
	 * Remark: <BR>
	 * @return  ServletListenerRegistrationBean<ListenerTest><BR>
	 */
	@Bean
	public ServletListenerRegistrationBean<ListenerTest> servletListenerRegistrationBean() {
	    return new ServletListenerRegistrationBean<ListenerTest>(new ListenerTest());
	}
}
