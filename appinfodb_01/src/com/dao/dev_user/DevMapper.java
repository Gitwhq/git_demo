package com.dao.dev_user;

import org.apache.ibatis.annotations.Param;

import com.pojo.DevUser;

/**
 * 开发商
 * @author Administrator
 *
 */
public interface DevMapper {
	
	//根据用户名查询
	public DevUser getDevLogin(@Param("devCode") String devCode);
	
}
