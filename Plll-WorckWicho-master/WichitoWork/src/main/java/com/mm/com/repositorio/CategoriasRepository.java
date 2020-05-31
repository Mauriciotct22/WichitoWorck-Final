package com.mm.com.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mm.com.modelo.Categoria;
//Repositorio Categoria
public interface CategoriasRepository extends JpaRepository<Categoria, Integer> {
	
}
