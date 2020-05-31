package com.mm.com.configuracion;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	@Value("${empleosapp.ruta.imagenes}")
	private String rutaImagenes;
	
	@Value("${empleosapp.ruta.cv}")
	private String rutaCv;
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		// Configuración de los recursos estáticos (imagenes de las vacantes) 
		//registry.addResourceHandler("/logos/**").addResourceLocations("file:c:/empleos/img-vacantes/"); // Deben crear un directorio para guardar las imagenes en esta direccion
		registry.addResourceHandler("/logos/**").addResourceLocations("file:"+rutaImagenes); 
		
		// Configuración de los recursos estáticos (archivos de los CV)
		//registry.addResourceHandler("/cv/**").addResourceLocations("file:c:/empleos/files-cv/"); // Aca se guardan los curriculums, de igual forma en la misma carpeta dentro de ella crean esta
		registry.addResourceHandler("/cv/**").addResourceLocations("file:"+rutaCv); // Linux
		
	}
	//Cambio 1
}
