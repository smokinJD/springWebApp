package com.novellius.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.novellius.dao.AdminDao;
import com.novellius.pojo.Admin;

@Service
public class AdminService {
	
	@Autowired
	private AdminDao adminDao;
	
	public boolean save(Admin admin){
		admin.setFechaCreacion(new Timestamp(new Date().getTime()));
		
		return adminDao.save(admin);
	}

	public List<Admin> findAll() {
		
		return adminDao.findAll();
	}

	public Admin findById(int id) {
		
		return adminDao.findById(id);
	}

	public boolean saveOrUpdate(Admin adminForm) {
		
		if(adminForm.getId() == 0){
			adminForm.setFechaCreacion(new Timestamp(new Date().getTime()));
			return adminDao.save(adminForm);
		}else{
			
			return adminDao.update(adminForm);
		}
		
	}

	public boolean delete(int id) {
		
		return adminDao.delete(id);
	}

}
