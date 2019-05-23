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
 * 开发商控制类
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/dev")
public class DevController {
	
	@Resource
	private DevService devService;
	
	//登陆页面
	@RequestMapping("/login")
	public String login(){
		return "devlogin";
	}
	
	//验证密码
	@RequestMapping(value="/doLogin",method=RequestMethod.POST)
	public String devLogin(@RequestParam("devCode") String devCode,
						   @RequestParam("devPassword") String devPassword,
						   HttpServletRequest request){
		DevUser devUser = devService.getDevLogin(devCode);
		if(devUser == null) {	//判断用户名
			throw new RuntimeException("用户名不正确");
		} else {
			if(!devUser.getDevPassword().equals(devPassword)){	//密码不正确
				throw new RuntimeException("密码不正确");
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
