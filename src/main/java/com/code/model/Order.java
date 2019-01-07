package com.code.model;

public class Order {

	private int orderid;
	
	private String ordername;
	
	private String scokname;
	
	private int scokprice;
	
	private String ordertime;
	
	private int userid;
	
	public Order(){
		super();
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public String getOrdername() {
		return ordername;
	}

	public void setOrdername(String ordername) {
		this.ordername = ordername;
	}

	public String getScokname() {
		return scokname;
	}

	public void setScokname(String scokname) {
		this.scokname = scokname;
	}

	public int getScokprice() {
		return scokprice;
	}

	public void setScokprice(int scokprice) {
		this.scokprice = scokprice;
	}

	public String getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(String ordertime) {
		this.ordertime = ordertime;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}
	
}
