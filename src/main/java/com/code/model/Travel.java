package com.code.model;

public class Travel {
	
	private int travelid;
	
	private String travelname;
	
	private String traveldesc;
	
	public Travel(){
		super();
	}

	public int getTravelid() {
		return travelid;
	}

	public void setTravelid(int travelid) {
		this.travelid = travelid;
	}

	public String getTravelname() {
		return travelname;
	}

	public void setTravelname(String travelname) {
		this.travelname = travelname;
	}

	public String getTraveldesc() {
		return traveldesc;
	}

	public void setTraveldesc(String traveldesc) {
		this.traveldesc = traveldesc;
	}

}
