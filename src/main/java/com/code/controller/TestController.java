package com.code.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code.dao.OrdersDao;
import com.code.dao.UserDao;
import com.code.model.User;

@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired
	private UserDao userDao;
	private OrdersDao ordersDao;
	
	@RequestMapping(value = "/userSignIn")
	public int userSignIn(){
		User user = new User();
		user.setAccount("1231234");
		user.setPassword("123456");
		user.setName("李四");
		user.setSex(1);
		user.setBirthday("20170101");
		user.setPhone("1231234");
		user.setMenber(1);
		return userDao.userSignIn(user);
	}
	
	@RequestMapping(value = "/loginSignIn")
	public boolean loginSignIn(){
		User user = new User();
		user.setAccount("1231234");
		user.setPassword("123456");
		return userDao.userLogin(user);
	}

	//测试
	@RequestMapping("/getUser/{account}")
	public boolean user(@PathVariable String account)
	{
		User user = new User();
		user.setAccount(account);
		System.out.println(user.getAccount());
		return userDao.getUserByAccount(user);
	}
}
