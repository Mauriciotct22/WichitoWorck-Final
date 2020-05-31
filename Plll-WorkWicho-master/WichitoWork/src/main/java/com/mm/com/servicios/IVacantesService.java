package com.mm.com.servicios;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mm.com.modelo.Vacante;

public interface IVacantesService {
	//Interfaz Vacantes Servicio
	void guardar(Vacante vacante);
	void eliminar(Integer idVacante);
	List<Vacante> buscarTodas();
	Vacante buscarPorId(Integer idVacante);
	List<Vacante> buscarDestacadas();
	Page<Vacante> buscarTodas(Pageable page);
	List<Vacante> buscarByExample(Example<Vacante> example);
}
