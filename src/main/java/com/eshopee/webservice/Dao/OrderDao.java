package com.eshopee.webservice.Dao;

import java.sql.ResultSet;


import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.eshopee.webservice.model.Order;

@Repository
public class OrderDao {
	@Autowired
	JdbcTemplate template;

	class OrderMapper implements RowMapper<Order> {
		@Override
		public Order mapRow(ResultSet rst, int rowNum) throws SQLException {
			Order order = new Order();
			order.setId(rst.getInt(1));
			order.setOrdername(rst.getString(2));
			order.setAdress(rst.getString(3));
			order.setCreatedAt(rst.getDate(4));
			return order;
		}

	}

	public List<Order> findAll() {
		List<Order> orders = new LinkedList<Order>();
		orders = template.query("select * from orders", new OrderMapper());
		return orders;
	}

	public Order findById(int id) {
		return template.queryForObject("select * from orders where id=?", new OrderMapper(), id);
	}

	public Order findByName(String ordername) {
		return template.queryForObject("select * from Orders where ordername=?", new OrderMapper(), ordername);

	}

	public int insert(Order order) {
		return template.update("insert into orders (id,ordername,adress) " + "values(?, ?, ?)",
				new Object[] { order.getId(), order.getOrdername(), order.getAdress() });
	}

	public int update(Order order) {
		return template.update("update orders " + "set ordername = ?,adress = ?" + " where id=?",
				new Object[] {order.getOrdername(), order.getAdress() ,order.getId()});
	}

	public int delete(int id) {
		return template.update("delete from orders where id=?", id);

	}

}
