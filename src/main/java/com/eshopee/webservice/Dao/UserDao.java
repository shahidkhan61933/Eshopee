package com.eshopee.webservice.Dao;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.eshopee.webservice.model.User;

@Repository
public class UserDao {
	@Autowired
	JdbcTemplate template;

	class UserMapper implements RowMapper<User> {
		@Override
		public User mapRow(ResultSet rst, int rowNum) throws SQLException {
			User user = new User();
			user.setId(rst.getInt(1));
			user.setName(rst.getString(2));
			user.setPhone(rst.getString(3));
			user.setEmail(rst.getString(4));
			user.setCreatedAt(rst.getDate(5));
			return user;
		}

	}

	public List<User> findAll() {
		List<User> users = new LinkedList<User>();
		users = template.query("select * from users", new UserMapper());
		return users;
	}

	public User findById(int id) {
		return template.queryForObject("select * from users where id=?", new UserMapper(), id);
	}

	public User findByName(String name) {
		return template.queryForObject("select * from users where name=?", new UserMapper(), name);

	}

	public int insert(User user) {
		return template.update("insert into users (id, name, phone, email) " + "values(?, ?, ?, ? )",
				new Object[] { user.getId(), user.getName(), user.getPhone(), user.getEmail() });
	}

	public int update(User user) {
		return template.update("update users " + " set name=?,phone =?,email=?" + " where id=?",
				new Object[] {user.getName(), user.getPhone(),user.getEmail(),user.getId()});
	}

	public int delete(int id) {
		return template.update("delete from users where id = ?",id);

	}

}
