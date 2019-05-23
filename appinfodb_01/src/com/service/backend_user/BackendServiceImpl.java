package com.service.backend_user;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.backend_user.BackendMapper;

@Service("backendService")
public class BackendServiceImpl implements BackendService {

	@Resource
	private BackendMapper backendMapper;
	
}
