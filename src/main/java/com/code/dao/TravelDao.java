package com.code.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.code.model.Travel;

@Repository
public class TravelDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * 获取所有旅游列表
	 * @return
	 */
	public List<Travel> getTravelList(){
		String sql = "select * from travel";
		List<Travel> travelList = jdbcTemplate.query(sql,new Object[]{},new RowMapper<Travel>(){

			@Override
			public Travel mapRow(ResultSet rs, int rowNum) throws SQLException {
				Travel travel = new Travel();
				travel.setTravelid(rs.getInt("travelid"));
				travel.setTravelname(rs.getString("travelname"));
				travel.setTraveldesc(rs.getString("traveldesc"));
				return travel;
			}
			
		});
		return travelList;
	}
	
}
