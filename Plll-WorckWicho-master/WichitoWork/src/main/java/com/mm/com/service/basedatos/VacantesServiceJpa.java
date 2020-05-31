package com.mm.com.service.basedatos;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mm.com.modelo.Vacante;
import com.mm.com.repositorio.VacantesRepository;
import com.mm.com.servicios.IVacantesService;

@Service
/**
 * 	Hay 2 clases que implementan la interfaz IVacantesService:
 *		- VacantesServiceImpl -> Guardamos las Vacantes en una LinkedList, Lista enlazada
 *		- VacantesServiceJpa  -> Guardamos las Vacantes en base de datos
 *	Spring no puede decidir cual Inyectar. Nosotros tenemos que decidir y nuevamente lo hacemos como en categorias con la anotacion @Primary
 *	Por lo tanto, con la anotación @Primary le decimos que esta es la implementación por Defecto.
 *
 */
@Primary
public class VacantesServiceJpa implements IVacantesService{

	@Autowired
	private VacantesRepository vacantesRepo;

	@Override
	public void guardar(Vacante vacante) {
		vacantesRepo.save(vacante);
	}

	@Override
	public void eliminar(Integer idVacante) {
		vacantesRepo.deleteById(idVacante);
	}

	@Override
	public List<Vacante> buscarTodas() {		
		return vacantesRepo.findAll();
	}

	@Override
	public Vacante buscarPorId(Integer idVacante) {
		Optional<Vacante> optional = vacantesRepo.findById(idVacante);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public List<Vacante> buscarDestacadas() {
		return vacantesRepo.findByDestacadoAndEstatusOrderByIdDesc(1, "Aprobada");
	}

	@Override
	public Page<Vacante> buscarTodas(Pageable page) {		
		return vacantesRepo.findAll(page);
	}

	@Override
	public List<Vacante> buscarByExample(Example<Vacante> example) {
		return vacantesRepo.findAll(example);
	}
		
}
