package com.dao.dev_user;

import org.apache.ibatis.annotations.Param;

import com.pojo.DevUser;

/**
 * ������
 * @author Administrator
 *
 */
public interface DevMapper {
	
	//�����û�����ѯ
	public DevUser getDevLogin(@Param("devCode") String devCode);
	
}
