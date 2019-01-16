/*
 * All rights Reserved, Copyright (C) Aisino LIMITED 2018
 * FileName: ListenerTest.java
 * Version:  $Revision$
 * Modify record:
 * NO. |     Date       |    Name         |      Content
 * 1   | 2019年1月16日        | Aisino)Jack    | original version
 */
package com.hhit.wificar.mapper;

import org.springframework.stereotype.Repository;

/**
 * class name:UserMapper <BR>
 * class description: 用户Mapper <BR>
 * Remark: <BR>
 * @version 1.00 2019年1月16日
 * @author Aisino)weihaohao
 */
@Repository
public interface UserMapper {
    /**
     * Method name: getPassword <BR>
     * Description: 根据用户名获取密码<BR>
     * Remark: <BR>
     * @param username
     * @return  String<BR>
     */
    String getPassword(String username);
    /**
     * Method name: getRole <BR>
     * Description: 根据用户名获取权限 <BR>
     * Remark: <BR>
     * @param username
     * @return  String<BR>
     */
    String getRole(String username);
}
