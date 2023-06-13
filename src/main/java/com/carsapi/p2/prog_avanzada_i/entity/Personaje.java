package com.carsapi.p2.prog_avanzada_i.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="sys_personajes") //Define que esta clase se va a guardar en la tabla sys_personajes
public class Personaje 
{
	@Id
	@Column 
	String nombre;
	
	@Column
	String apodo;
	
	@Column
	String actor_voz_original;
	
	@Column
	String color_principal;
	
	@Column
	Boolean es_personaje_principal;
	
	@Column
	String link_foto_auto_pelicula;
	
	@Column
	String link_foto_auto_realidad;
	
	@Column
	String marca_real;
	
	@Column
	String modelo_real;
	
	public String getNombre() {return nombre;}
	public void setNombre(String nombre) {this.nombre = nombre;}
	
	public String getApodo() {return apodo;}
	public void setApodo(String apodo) {this.apodo = apodo;}
	
	public String getActor_voz_original() {return actor_voz_original;}
	public void setActor_voz_original(String actor_voz_original) {this.actor_voz_original = actor_voz_original;}
	
	public String getColor_principal() {return color_principal;}
	public void setColor_principal(String color_principal) {this.color_principal = color_principal;}
	
	public Boolean getEs_personaje_principal() {return es_personaje_principal;}
	public void setEs_personaje_principal(Boolean es_personaje_principal) {this.es_personaje_principal = es_personaje_principal;}
	
	public String getLink_foto_auto_pelicula() {return link_foto_auto_pelicula;}
	public void setLink_foto_auto_pelicula(String link_foto_auto_pelicula) {this.link_foto_auto_pelicula = link_foto_auto_pelicula;}
	
	public String getLink_foto_auto_realidad() {return link_foto_auto_realidad;}
	public void setLink_foto_auto_realidad(String link_foto_auto_realidad) {this.link_foto_auto_realidad = link_foto_auto_realidad;}
	
	public String getMarca_real() {return marca_real;}
	public void setMarca_real(String marca_real) {this.marca_real = marca_real;}
	
	public String getModelo_real() {return modelo_real;}
	public void setModelo_real(String modelo_real) {this.modelo_real = modelo_real;}
	
	@Override
	public String toString() 
	{
		return "Personaje ["
				+ "nombre=" + this.nombre + 
				", apodo=" + this.apodo + 
				", actor_voz_original=" + this.actor_voz_original + 
				", color_principal=" + this.color_principal + 
				", es_personaje_principal=" + this.es_personaje_principal +
				", link_foto_auto_pelicula=" + this.link_foto_auto_pelicula +
				", link_foto_auto_realidad=" + this.link_foto_auto_realidad +
				", marca_real=" + this.marca_real +
				", modelo_real=" + this.modelo_real +
				"]";
	}
}