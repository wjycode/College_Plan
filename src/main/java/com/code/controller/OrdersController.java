package com.code.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code.dao.OrdersDao;
import com.code.model.Order;
import com.code.model.User;

@RestController
@RequestMapping("/order")
public class OrdersController {

	@Autowired
	private OrdersDao ordersDao;
	
	/**
	 * 根据userid获取所有订单
	 * @param user
	 * @return
	 */
	@RequestMapping("/getOrderList")
	public List<Order> getOrderList(@RequestBody User user){
		return ordersDao.getOrderList(user.getId());
	}
	
	/**
	 * 添加订单
	 * @param order
	 * @param userid
	 * @return
	 */
	@RequestMapping("/addOrder")
	@Transactional(rollbackFor = { Exception.class })
	public boolean addOrder(Order order,int userid){
		try {
			ordersDao.addOrder(order, userid);
		} catch (Exception e) {
			e.printStackTrace();     
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();  
            return false;
		}
		return true;
	}
}
