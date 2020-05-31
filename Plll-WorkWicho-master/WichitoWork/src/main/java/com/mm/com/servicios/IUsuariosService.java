package com.mm.com.servicios;

import java.util.List;

import com.mm.com.modelo.Usuario;

public interface IUsuariosService {
	//Interfaz Usuario Servicio
	void guardar(Usuario usuario);
	void eliminar(Integer idUsuario);
	List<Usuario> buscarTodos();
	List<Usuario> buscarRegistrados();
	Usuario buscarPorId(Integer idUsuario);
	Usuario buscarPorUsername(String username);
	int bloquear(int idUsuario);
	int activar(int idUsuario);
}
