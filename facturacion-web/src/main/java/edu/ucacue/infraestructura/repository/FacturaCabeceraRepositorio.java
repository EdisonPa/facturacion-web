package edu.ucacue.infraestructura.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.ucacue.modelo.FacturaCabecera;

public interface FacturaCabeceraRepositorio extends JpaRepository<FacturaCabecera, Integer> {

	List<FacturaCabecera> findById(int id);
	
	
	//List<FacturaCabecera> findByNombreLike(String nombre);
	
	//List<FacturaCabecera> findByNombre(String nombre);
	
	@Query("select fc from FacturaCabecera fc where fc.id =  :id")
	List<FacturaCabecera> buscarPorId(@Param("id") int id);
	
	/*@Query("select fc from FacturaCabecera fc where fc.nombre like %:nombre%")
	List<FacturaCabecera> buscarPorNombreLike(@Param("nombre") String nombre);*/
	
	
	
	
}