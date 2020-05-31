package com.mm.com.repositorio;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mm.com.modelo.Vacante;

public interface VacantesRepository extends JpaRepository<Vacante, Integer> {
	//Interfaces
	
	List<Vacante> findByEstatus(String estatus);
	
	List<Vacante> findByDestacadoAndEstatusOrderByIdDesc(int destacado, String estatus);
	
	List<Vacante> findBySalarioBetweenOrderBySalarioDesc(double s1, double s2);
	
	List<Vacante> findByEstatusIn(String[] estatus);

}
