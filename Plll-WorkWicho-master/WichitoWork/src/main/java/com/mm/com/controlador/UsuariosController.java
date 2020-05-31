package com.mm.com.controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mm.com.modelo.Categoria;
import com.mm.com.modelo.Usuario;
import com.mm.com.servicios.IUsuariosService;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {
	
	// Inyectamos una instancia desde nuestro ApplicationContext
    @Autowired
	private IUsuariosService serviceUsuarios;
    
    /**
	 * Metodo que muestra la lista de usuarios sin paginacion
	 */
    @GetMapping("/index")
	public String mostrarIndex(Model model) {
    	List<Usuario> lista = serviceUsuarios.buscarRegistrados();
    	model.addAttribute("usuarios", lista);
		return "usuarios/listUsuarios";
	}
    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") int idUsuario, Model model) {		
		Usuario usuario = serviceUsuarios.buscarPorId(idUsuario);			
		model.addAttribute("usuario", usuario);
		return "formRegistro";
	}
    
    /**
     * Método para eliminar un usuario de la base de datos.
     */
    @GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") int idUsuario, RedirectAttributes attributes) {
		    	
		// Eliminamos el usuario
    	serviceUsuarios.eliminar(idUsuario);
			
		attributes.addFlashAttribute("msg", "El usuario fue eliminado!.");
		return "redirect:/usuarios/index";
	}
    
    
    /**
     * Método para activar un usuario
     */
    @GetMapping("/unlock/{id}")
	public String activar(@PathVariable("id") int idUsuario, RedirectAttributes attributes) {		
    	serviceUsuarios.activar(idUsuario);
		attributes.addFlashAttribute("msg", "El usuario fue activado y ahora tiene acceso al sistema.");		
		return "redirect:/usuarios/index";
	}
    
	/**
	 * Método para bloquear un usuario
	 */
	@GetMapping("/lock/{id}")
	public String bloquear(@PathVariable("id") int idUsuario, RedirectAttributes attributes) {		
		serviceUsuarios.bloquear(idUsuario);
		attributes.addFlashAttribute("msg", "El usuario fue bloqueado y no tendra acceso al sistema.");		
		return "redirect:/usuarios/index";
	}
	
}
