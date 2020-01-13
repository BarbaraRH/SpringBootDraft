package com.bolsadeideas.springboot.backend.apirest.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity 
@Table(name="clientes")
//buena practica nombre tabla en plural con minuscula
//si tabla se llamara Cliente no seria necesario @Table
//palabras compuestas van con guíon Ej: cliente_1

public class Cliente implements Serializable{
	
	@Id //para generar el id
	@GeneratedValue(strategy=GenerationType.IDENTITY)  // indicar estrategia generacion id
	private Long id;
	
	//se podria ocupar @column si el nombre de la columna se llama distinto al nombre del campo
	private String nombre;
	private String apellido;
	private String email;
	
	@Column(name="create_at")
	@Temporal(TemporalType.DATE)//ver cual va a ser el equivalente en la base de datos
	private Date createAt;
	
	@PrePersist //para asignar fecha creacion sirve para post
	public void prePersist() {
		createAt = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; 
	
}
