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
	
	public void save(Admin admin){
		admin.setFechaCreacion(new Timestamp(new Date().getTime()));
		
		adminDao.save(admin);
	}

	public List<Admin> findAll() {
		
		return adminDao.findAll();
	}

	public Admin findById(int id) {
		
		return adminDao.findById(id);
	}

	public void saveOrUpdate(Admin adminForm) {
		
		if(adminForm.getId() == 0){
			adminForm.setFechaCreacion(new Timestamp(new Date().getTime()));
			adminDao.save(adminForm);
		}else{
			
			adminDao.update(adminForm);
		}
		
	}

	public void delete(int id) {
		
		Admin admin = adminDao.findById(id);
		adminDao.delete(admin);
	}

}
