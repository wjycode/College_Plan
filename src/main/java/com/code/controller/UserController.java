package com.code.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code.dao.UserDao;
import com.code.model.User;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
    private UserDao userDao;
	
	/**
	 * 注册
	 * @param user
	 * @return:0-注册成功;1-注册不成功;2-账户名已存在
	 */
	@RequestMapping("/signIn")
	@Transactional(rollbackFor = { Exception.class })
	public int userSignIn(@RequestBody User user)
	{
		int sign=2;//0-注册成功;1-注册不成功;2-账户名已存在
		//查询该用户账号是否已被占用
		boolean flag = userDao.getUserByAccount(user);
		if(flag == true){
			try {
				sign = userDao.userSignIn(user);
			} catch (Exception e) {
				e.printStackTrace();     
	            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();  
	            sign = 2;
			}
		}
		return sign;
	}
	
	/**
	 * 登录
	 * @param user
	 * @return:true-账户合法;false-账户不合法
	 */
	@RequestMapping("/loginIn")
	public boolean userLogin(@RequestBody User user)
	{
		return userDao.userLogin(user);
	}
	
	/**
	 * 更改用户信息
	 * @param user
	 * @return
	 */
	@RequestMapping("/changeUser")
	@Transactional(rollbackFor = { Exception.class })
	public boolean changeUser(@RequestBody User user)
	{
		try {
			userDao.changeUser(user);
		} catch (Exception e) {
			e.printStackTrace();     
            //就是这一句了, 加上之后抛了异常就能回滚（有这句代码就不需要再手动抛出运行时异常了）
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();  
            return false;
		}
		return true;
	}
	
}
