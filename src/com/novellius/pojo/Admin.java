package com.novellius.pojo;

import java.sql.Timestamp;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Admin")
public class Admin {
	
    @Id
    @GeneratedValue
    private int id;
	private String nombre;
	private String cargo;
	private Timestamp fechaCreacion;
	
	@OneToMany(mappedBy="admin")
	private Set<Direccion> direcciones;
	
	//String to String
	@Override
	public String toString() {
		return "Admin [id=" + id + ", nombre=" + nombre + ", cargo=" + cargo + ", fechaCreacion=" + fechaCreacion + "]";
	}

	//Constructor
	public Admin() {
		super();
	}

	public Admin(int id, String nombre, String cargo, Timestamp fechaCreacion,
      Set<Direccion> direcciones) {
    super();
    this.id = id;
    this.nombre = nombre;
    this.cargo = cargo;
    this.fechaCreacion = fechaCreacion;
    this.direcciones = direcciones;
  }

  //Getter and Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Timestamp getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

  public Set<Direccion> getDirecciones() {
    return direcciones;
  }

  public void setDirecciones(Set<Direccion> direcciones) {
    this.direcciones = direcciones;
  }
	
}
