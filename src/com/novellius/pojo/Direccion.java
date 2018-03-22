package com.novellius.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@Entity
@Table(name = "Direccion")
public class Direccion {
  @Id
  @GeneratedValue
  private int id;
  private String calle;
  private int cp;
  
  @ManyToOne
  @JoinColumn(name="IdAdmin")
  private Admin admin;

  // To String
  @Override
  public String toString() {
    return "Direccion [id=" + id + ", calle=" + calle + ", cp=" + cp + "]";
  }

  // Constructor
  public Direccion() {
    super();
  }

  public Direccion(int id, String calle, int cp, Admin admin) {
    super();
    this.id = id;
    this.calle = calle;
    this.cp = cp;
    this.admin = admin;
  }

  // Getters and Setters
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getCalle() {
    return calle;
  }

  public void setCalle(String calle) {
    this.calle = calle;
  }

  public int getCp() {
    return cp;
  }

  public void setCp(int cp) {
    this.cp = cp;
  }

  public Admin getAdmin() {
    return admin;
  }

  public void setAdmin(Admin admin) {
    this.admin = admin;
  }



}
