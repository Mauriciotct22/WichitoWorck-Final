package com.mm.com.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mm.com.modelo.Solicitud;
//Repositorio Solicitudes
public interface SolicitudesRepository extends JpaRepository<Solicitud, Integer> {

}
