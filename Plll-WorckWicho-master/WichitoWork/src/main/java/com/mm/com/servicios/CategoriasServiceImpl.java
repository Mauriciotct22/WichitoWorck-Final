package com.mm.com.servicios;

import java.util.LinkedList;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mm.com.modelo.Categoria;

@Service
public class CategoriasServiceImpl implements ICategoriasService{

	private List<Categoria> lista = null;
	
	public CategoriasServiceImpl() {
		lista = new LinkedList<Categoria>();
		
		// Creamos algunas Categorias para poblar la lista con datos crudos/quemados ...
		
		// Categoria 1
		Categoria cat1 = new Categoria();
		cat1.setId(1);
		cat1.setNombre("Redes");
		cat1.setDescripcion("Descripcion de la categoria Redes");
		
		// Categoria 2
		Categoria cat2 = new Categoria();
		cat2.setId(2);
		cat2.setNombre("Marketing");
		cat2.setDescripcion("Trabajos relacionados con Marketing");
		
					
		// Categoria 3
		Categoria cat3 = new Categoria();
		cat3.setId(3);
		cat3.setNombre("Relaciones Publicas");
		cat3.setDescripcion("Trabajos relacionados con Relaciones Publicas");
		
		// Categoria 4
		Categoria cat4 = new Categoria();
		cat4.setId(4);
		cat4.setNombre("Arquitectura");
		cat4.setDescripcion("Trabajos de Ingenieria en Sistemas");
		
		// Categoria 5
		Categoria cat5 = new Categoria();
		cat5.setId(5);
		cat5.setNombre("Electronica");
		cat5.setDescripcion("Ingenieros electricos");
		
		/**
		 * Agregamos los 5 objetos de tipo Categoria a la lista ...
		 */
		lista.add(cat1);			
		lista.add(cat2);
		lista.add(cat3);
		lista.add(cat4);
		lista.add(cat5);

	}
	
	public void guardar(Categoria categoria) {		
		lista.add(categoria);
	}

	public List<Categoria> buscarTodas() {
		return lista;
	}

	public Categoria buscarPorId(Integer idCategoria) {			
		for (Categoria cat : lista) {
			if (cat.getId()==idCategoria) {
				return cat;
			}
		}		
		return null;	
	}

	@Override
	public void eliminar(Integer idCategoria) {
		// TODO Auto-generated method stub		
	}

	@Override
	public Page<Categoria> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

}
