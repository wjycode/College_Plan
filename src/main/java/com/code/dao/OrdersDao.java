package com.code.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.code.model.Order;
import com.code.model.Travel;

@Repository
public class OrdersDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * 根据userid获取订单
	 * @param userId
	 * @return
	 */
	public List<Order> getOrderList(int userId){
		String sql = "select * from order where userid=?";
		List<Order> orderList = jdbcTemplate.query(sql, new Object[]{},new RowMapper<Order>(){

			@Override
			public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
				Order order = new Order();
				order.setOrderid(rs.getInt("orderid"));
				order.setOrdername(rs.getString("ordername"));
				order.setScokname(rs.getString("sockname"));
				order.setScokprice(rs.getInt("scokprice"));
				order.setOrdertime(rs.getString("ordertime"));
				return order;
			}
		});
		return orderList;
	}
	
	/**
	 * 插入订单
	 * @param order
	 * @param userid
	 * @return
	 */
	public boolean addOrder(Order order,int userid){
		String sql = "insert into order(ordername,scokname,scokprice,ordertime,userid) values(?,?,?,?,?)";
		Object[] params = {
				order.getOrdername(),
				order.getScokname(),
				order.getScokprice(),
				order.getOrdertime(),
				order.getUserid()
			};
		int flag = jdbcTemplate.update(sql,params);
		return flag==1 ? true:false;
	}
	
}
