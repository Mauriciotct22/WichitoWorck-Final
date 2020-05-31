package com.mm.com.util;

import java.io.File;
import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;

public class Utileria {
	
	/**
	 * Metodo que guarda un archivo atraves de un formulario HTML al disco duro.
	 * Aca guardamos las imagenes
	 */
	public static String guardarArchivo(MultipartFile multiPart, String ruta) {
		// Obtenemos el nombre original del archivo.
		String nombreOriginal = multiPart.getOriginalFilename();
		// Reemplazamos en el nombre de archivo los espacios por guiones por cuestiones de orden y evitar errores.
		nombreOriginal = nombreOriginal.replace(" ", "-");
		// Agregamos al nombre del archivo 8 caracteres aleatorios para evitar duplicados con el metodo de abajo mejor conocido como RANDOM.
		String nombreFinal = randomAlphaNumeric(8)+nombreOriginal;
		try {
			// Formamos el nombre del archivo para guardarlo en el disco duro, en las carpetas que anteriormente mencione que las creen.
			File imageFile = new File(ruta + nombreFinal);
			System.out.println("Archivo: " + imageFile.getAbsolutePath());
			//Guardamos fisicamente el archivo
			multiPart.transferTo(imageFile);
			return nombreFinal;
		} catch (IOException e) {
			System.out.println("Error en Utileria " + e.getMessage());
			return null;
		}
	}

	/**
	 * Metodo para generar una cadena aleatoria de longitud N... METODO ALEATORIO-RANDOM-Para generar caracteres aleatorios para evitar archivos duplicados
	 */
	public static String randomAlphaNumeric(int count) {
		String CARACTERES = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int) (Math.random() * CARACTERES.length());
			builder.append(CARACTERES.charAt(character));
		}
		return builder.toString();
	}
}