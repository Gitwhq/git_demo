package com.service.dev_user;

import org.apache.ibatis.annotations.Param;

import com.pojo.DevUser;
/**
 * ������
 * @author Administrator
 *
 */
public interface DevService {

	//�����û�����ѯ
	public DevUser getDevLogin(@Param("devCode") String devCode);
	
}
