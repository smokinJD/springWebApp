package com.novellius.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.novellius.pojo.Admin;
import com.novellius.pojo.AdminRowMapper;

@Component("adminDao")
public class AdminDaoImpl implements AdminDao{

	private NamedParameterJdbcTemplate JdbcTemplate;
	
	@Autowired
	private void setDataSource(DataSource dataSource){
		this.JdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	@Override
	public boolean save(Admin admin) {
		// TODO Auto-generated method stub
//		MapSqlParameterSource paramMap = new MapSqlParameterSource();
//		paramMap.addValue("Nombre", admin.getNombre());
//		paramMap.addValue("Cargo", admin.getCargo());
//		paramMap.addValue("FechaCreacion", admin.getFechaCreacion());
		
		//Pasa los parametros sin necesidad de Get, siempre y cuando tengan el mismo nombre que en la base de datos
		BeanPropertySqlParameterSource paramMap = new BeanPropertySqlParameterSource(admin);
		return JdbcTemplate.update("Insert into Admin (Nombre, Cargo, FechaCreacion) values (:Nombre, :Cargo, :FechaCreacion)", paramMap) == 1;
	}
	@Override
	public List<Admin> findAll() {
		return JdbcTemplate.query("Select * FROM Admin", new RowMapper<Admin>() {

			@Override
			public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
				Admin admin = new Admin();
				
				admin.setId(rs.getInt("id"));
				admin.setNombre(rs.getString("Nombre"));
				admin.setCargo(rs.getString("Cargo"));
				admin.setFechaCreacion(rs.getTimestamp("FechaCreacion"));
				return admin;
			}
			
		});
	}
	@Override
	public Admin findById(int id) {
		//este metodo no sabe que lo que tiene que devolver es un objeto por lo que hay que ponerle (Admin) al principio
		//return (Admin) JdbcTemplate.query("Select * FROM Admin WHERE Id=:id", new MapSqlParameterSource("id", id), new AdminRowMapper());
		
		return JdbcTemplate.queryForObject("Select * FROM Admin WHERE Id=:id", new MapSqlParameterSource("id", id), new AdminRowMapper());
	}
	@Override
	public List<Admin> findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return JdbcTemplate.query("Select * FROM Admin WHERE Nombre LIKE :nombre", new MapSqlParameterSource("nombre", "%" + nombre + "%"), new AdminRowMapper());
	}
	@Override
	public boolean update(Admin admin) {
		return JdbcTemplate.update("UPDATE Admin SET Nombre=:nombre, Cargo=:cargo, FechaCreacion=:fechaCreacion WHERE Id=:id", new BeanPropertySqlParameterSource(admin))==1;
	}
	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return JdbcTemplate.update("DELETE FROM Admin WHERE Id=:id", new MapSqlParameterSource("id", id))==1;
	}
	
	@Transactional
	@Override
	public int[] saveAll(List<Admin> admins) {
		SqlParameterSource[] batchArgs = SqlParameterSourceUtils.createBatch(admins.toArray());
		return JdbcTemplate.batchUpdate("Insert into Admin (Id, Nombre, Cargo, FechaCreacion) values (:id, :nombre, :cargo, :fechaCreacion)", batchArgs);
	}

}
