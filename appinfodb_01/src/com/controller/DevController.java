package com.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pojo.DevUser;
import com.service.dev_user.DevService;

/**
 * �����̿�����
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/dev")
public class DevController {
	
	@Resource
	private DevService devService;
	
	//��½ҳ��
	@RequestMapping("/login")
	public String login(){
		return "devlogin";
	}
	
	//��֤����
	@RequestMapping(value="/doLogin",method=RequestMethod.POST)
	public String devLogin(@RequestParam("devCode") String devCode,
						   @RequestParam("devPassword") String devPassword,
						   HttpServletRequest request){
		DevUser devUser = devService.getDevLogin(devCode);
		if(devUser == null) {	//�ж��û���
			throw new RuntimeException("�û�������ȷ");
		} else {
			if(!devUser.getDevPassword().equals(devPassword)){	//���벻��ȷ
				throw new RuntimeException("���벻��ȷ");
			}
			request.getSession().setAttribute("devUserSession", devUser);
			return "redirect:/dev/main";
		}
	}
	
	@RequestMapping("/main")
	public String main(){
		return "developer/main";
	}
	
}
