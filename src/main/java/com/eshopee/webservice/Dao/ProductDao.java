package com.eshopee.webservice.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.eshopee.webservice.model.Product;

@Repository
public class ProductDao {
	@Autowired
	JdbcTemplate template;

	class ProductMapper implements RowMapper<Product> {
		@Override
		public Product mapRow(ResultSet rst, int rowNum) throws SQLException {
			Product product = new Product();
			product.setId(rst.getInt(1));
			product.setName(rst.getString(2));
			product.setPrice(rst.getDouble(3));
			product.setDescription(rst.getString(4));
			product.setCreatedAt(rst.getDate(5));
			return product;
		}

	}

	public List<Product> findAll() {
		List<Product> products = new LinkedList<Product>();
		products = template.query("select * from products", new ProductMapper());
		return products;
	}

	public Product findById(int id) {
		return template.queryForObject("select * from products where id=?", new ProductMapper(), id);
	}

	public Product findByName(String name) {
		return template.queryForObject("select * from products where name=?", new ProductMapper(), name);

	}

	public int insert(Product product) {
		return template.update("insert into products (id, name, price, description) " + "values(?, ?, ?, ? )",
				new Object[] { product.getId(), product.getName(), product.getPrice(), product.getDescription() });
	}

	public int update(Product product) {
		return template.update("update products " + " set name = ?, price = ? ,description = ?" + " where id=?",
				new Object[] { product.getName(), product.getPrice(),product.getDescription(), product.getId() });
	}

	public int delete(int id) {
		return template.update("delete from products where id=?", id);

	}

}
