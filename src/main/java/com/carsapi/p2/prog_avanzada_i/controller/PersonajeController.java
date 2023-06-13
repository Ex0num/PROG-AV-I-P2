package com.carsapi.p2.prog_avanzada_i.controller;

import java.lang.reflect.Field;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.carsapi.p2.prog_avanzada_i.entity.Personaje;
import com.carsapi.p2.prog_avanzada_i.repository.PersonajeRepository;

@RestController
public class PersonajeController {

	
	@Autowired
	PersonajeRepository personajeRepository;
	
	@GetMapping("/")
	public ResponseEntity<?> welcomeEndpoint()
	{
		String textoDeBienvenida =
		"Bienvenido/a a la API de Cars. Su finalidad es devolver informacion de todos los autos de cars que sean reconocibles como autos reales." + 
		"Con su marca, su modelo, y algunos datos más. Es una versión básica e inicial. Para obtener endpoints por favor utilice por GET, /v1/endpoints";
		ResponseEntity<String> respuesta = new ResponseEntity(textoDeBienvenida, HttpStatus.OK);
		
		return respuesta;		
	}
	
	@GetMapping("/v1/endpoints")
	public ResponseEntity<?> getAllEndpoints()
	{
		String textoDeAyuda =
		"Bienvenido/a al expositor de endpoints de CARS-API. \n\n" + 
		"GET / -> Devuelve la bienvenida al programa, \n" +
		"GET /help -> Devuelve una lista de todos los endpoints disponibles. \n" +
		"GET /v1/api/features -> Devuelve una lista futuras actualizaciones de la API. \n" +
		"GET /v1/all-cars -> Devuelve un listado completo con toda la información almacenada de todos los autos.\n" +
		"GET /v1/car/by-name/{name} -> Devuelve la informacion de un auto en particular, buscado por su nombre.\n" +
		"GET /v1/car/by-color/{color} -> Devuelve la informacion de uno o varios autos, buscados por su color principal.\n" +
		"GET /v1/car/by-brand/{brand} -> Devuelve la informacion de uno o varios autos, buscados por su marca real.\n" +
		"GET /v1/car/structure -> Devuelve la estructura básica en la que se debe basar un objeto auto en la API.\n" +
		"POST /v1/car -> Recibe la información de un auto y la sube a la base de datos. Si ya existe, se actualiza.\n";
		
		ResponseEntity<String> respuesta = new ResponseEntity(textoDeAyuda, HttpStatus.OK);
		return respuesta;		
	}
	
	@GetMapping("/v1/features")
	public ResponseEntity<?> getAllFeatures()
	{
		String textoDeFeatures =
		"Bienvenido/a a las últimas noticias y novedad de CARS-API. \n" +
		"\n <12/06/2023> - Anuncio: 'Se lanzó por primera vez, CARS-API'" +
		"\n <13/06/2023> - Anuncio: 'Se implementarán más de 500 autos de los 3 films de Cars. Se realizarán en un endpoint 'v2'. Proximamente. (Se permitirán filtraciones más complejas)";
		
		ResponseEntity<String> respuesta = new ResponseEntity(textoDeFeatures, HttpStatus.OK);
		return respuesta;		
	}
	
	@GetMapping("/v1/all-cars")
	public ResponseEntity<?> getAllCars()
	{
		List <Personaje> listaAutosObtenida = (List<Personaje>) this.personajeRepository.findAll();
		ResponseEntity<String> respuesta = new ResponseEntity(listaAutosObtenida, HttpStatus.OK);
		return respuesta;	
	}
	
	@GetMapping("/v1/car/by-name/{nombreRecibido}")
	public ResponseEntity<?> getCarByName(@PathVariable String nombreRecibido)
	{
		List <Personaje> listaAutosObtenida = (List<Personaje>) this.personajeRepository.findByNombre(nombreRecibido);
		ResponseEntity<String> respuesta = new ResponseEntity(listaAutosObtenida, HttpStatus.OK);
		return respuesta;	
	}
	
	@GetMapping("/v1/car/by-color/{colorRecibido}")
	public ResponseEntity<?> getCarByColor(@PathVariable("colorRecibido") String colorRecibido) 
	{
	    System.out.println(colorRecibido);
	    List<Personaje> listaAutosObtenida = personajeRepository.findByColor(colorRecibido);
	    ResponseEntity<List<Personaje>> respuesta = new ResponseEntity<>(listaAutosObtenida, HttpStatus.OK);
	    return respuesta;
	}
	
	@GetMapping("/v1/car/by-brand/{marcaRecibida}")
	public ResponseEntity<?> getCarByMarca(@PathVariable("marcaRecibida") String marcaRecibida) 
	{
	    System.out.println(marcaRecibida);
	    List<Personaje> listaAutosObtenida = personajeRepository.findByBrand(marcaRecibida);
	    ResponseEntity<List<Personaje>> respuesta = new ResponseEntity<>(listaAutosObtenida, HttpStatus.OK);
	    return respuesta;
	}
	
	@GetMapping("/v1/car/structure")
	public ResponseEntity<?> getCarStructure() 
	{
	    String estructuraPersonajeDefinida = "La estructura de un Personaje (AUTO) es la siguiente: \n\n";
	    
	    Field[] arrayDeAtributos = Personaje.class.getDeclaredFields();
	    
	    for (int i = 0; i < arrayDeAtributos.length; i++) {
	        String[] stringClassType = arrayDeAtributos[i].getAnnotatedType().toString().split("\\.");
	        System.out.println(stringClassType);
	        estructuraPersonajeDefinida = estructuraPersonajeDefinida + stringClassType[2] + " " + arrayDeAtributos[i].getName().toString() + "\n";
	    }
	    
	    ResponseEntity<String> respuesta = new ResponseEntity<>(estructuraPersonajeDefinida, HttpStatus.OK);
	    return respuesta;
	}
	
	@PostMapping("/v1/car")
	public ResponseEntity<?> postOneCar(@RequestBody Personaje personajeRecibido)
	{
		this.personajeRepository.save(personajeRecibido);
		
		String resultadoPosting = "Car posted sucessfully \n\n" + personajeRecibido.toString();
				
		ResponseEntity<String> respuesta = new ResponseEntity(resultadoPosting, HttpStatus.OK);
		return respuesta;
	}

}