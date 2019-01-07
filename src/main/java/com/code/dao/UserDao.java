package com.code.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.code.model.User;

@Repository
public class UserDao {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	/**
	 * 根据用户账号account查询用户信息
	 * @param user
	 * @return
	 */
	public boolean getUserByAccount(User user)
	{
		boolean flag = false;
		String sql = "select * from user where account = ?";
		List<Map<String, Object>> userlist= jdbcTemplate.queryForList(sql, new Object[]{user.getAccount()});
		if(userlist.isEmpty())
			flag = true;
		return flag;
	}
	
	/**
	 * 插入新用户
	 * @param user
	 * @return
	 */
	public int userSignIn(User user)
	{
		String sql = "insert into user(account,password,name,phone,sex,birthday,address,menber) "
				+ "values (?,?,?,?,?,?,?,?)";
		int flag = jdbcTemplate.update(sql, new Object[]{
				user.getAccount(),user.getPassword(),user.getName(),
				user.getPhone(),user.getSex(),user.getBirthday(),
				user.getAddress(),user.getMenber()
		});
		return flag==1?0:1;//0-插入成功;1-插入不成功
	}
	
	/**
	 * 登录
	 * @param user
	 * @return
	 */
	public boolean userLogin(User user)
	{
		boolean flag = false;
		String sql = "select * from user where account = ? and password = ?";
		List<Map<String, Object>> userlist= jdbcTemplate.queryForList(sql, new Object[]{user.getAccount()}, user.getPassword());
		if(userlist.isEmpty())
			flag = true;
		return flag;
	}
	
	/**
	 * 更新用户信息
	 * @param user
	 * @return
	 */
	public boolean changeUser(User user){
		String sql = "update user set password=?,name=?,sex=?,birthday=?,address=?,menber=? where userid=?";
		Object[] params = {
				user.getPassword(),
				user.getName(),
				user.getSex(),
				user.getBirthday(),
				user.getAddress(),
				user.getMenber(),
				user.getId()
			};
		int flag = jdbcTemplate.update(sql, params);
		return flag==1?true:false;
	}
}
