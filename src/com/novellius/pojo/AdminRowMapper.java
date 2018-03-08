package com.novellius.pojo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
//Esta Clase sirve para hacer una consulta de Select sin necesidad de estar poniendo este codigo, cada vez que queramos hacer un select
public class AdminRowMapper implements RowMapper<Admin>{

	@Override
	public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
		Admin admin = new Admin();
		
		admin.setId(rs.getInt("id"));
		admin.setNombre(rs.getString("Nombre"));
		admin.setCargo(rs.getString("Cargo"));
		admin.setFechaCreacion(rs.getTimestamp("FechaCreacion"));
		return admin;
	}
	

}
