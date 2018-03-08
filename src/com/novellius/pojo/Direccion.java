package com.novellius.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Direccion {
	private String calle;
	private int cp;
	//To String
	@Override
	public String toString() {
		return "Direccion [calle=" + calle + ", cp=" + cp + "]";
	}
	
	//Constructor
	public Direccion() {
		super();
	}
	
	public Direccion(String calle, int cp) {
		super();
		this.calle = calle;
		this.cp = cp;
	}
	
	//Getters and Setters

	public String getCalle() {
		return calle;
	}

	@Autowired //sirve para definir un set de una clase instanciada
	public void setCalle(@Value("Erandio")String calle) {
		this.calle = calle;
	}

	public int getCp() {
		return cp;
	}

	@Autowired
	public void setCp(@Value("777")int cp) {
		this.cp = cp;
	}
	
	

}
