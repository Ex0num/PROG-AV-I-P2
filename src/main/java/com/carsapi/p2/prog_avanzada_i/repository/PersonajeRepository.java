package com.carsapi.p2.prog_avanzada_i.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.carsapi.p2.prog_avanzada_i.entity.Personaje;

public interface PersonajeRepository extends CrudRepository <Personaje,Integer>
{
	public List<Personaje> findByNombre(String nombreRecibido);
	
	@Query(nativeQuery= true, value="SELECT "
	+ "p1_0.nombre,"
	+ "p1_0.actor_voz_original,"
	+ "p1_0.apodo,p1_0.color_principal,"
	+ "p1_0.es_personaje_principal,"
	+ "p1_0.link_foto_auto_pelicula,"
	+ "p1_0.link_foto_auto_realidad,"
	+ "p1_0.marca_real,"
	+ "p1_0.modelo_real "
	+ "FROM sys_personajes p1_0 where p1_0.color_principal= :colorRecibido")
	public List<Personaje> findByColor(String colorRecibido);
	
	@Query(nativeQuery= true, value="SELECT "
	+ "p1_0.nombre,"
	+ "p1_0.actor_voz_original,"
	+ "p1_0.apodo,p1_0.color_principal,"
	+ "p1_0.es_personaje_principal,"
	+ "p1_0.link_foto_auto_pelicula,"
	+ "p1_0.link_foto_auto_realidad,"
	+ "p1_0.marca_real,"
	+ "p1_0.modelo_real "
	+ "FROM sys_personajes p1_0 where p1_0.marca_real= :marcaRecibida")
	public List<Personaje> findByBrand(String marcaRecibida);
}
