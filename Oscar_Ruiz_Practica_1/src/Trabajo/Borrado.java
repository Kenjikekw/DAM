package Trabajo;

import java.io.File;

public class Borrado {
	
	/* Pre: Te debe dejar eliminar un archivo del directorio de archivos
	 * Pro: Te lo borra y te lleva de nuevo al menu principal
	 * 
	 * ORG 18/09/2023
	 */
	
	public static void Borrar() {
		File carpeta = new File("./Archivos");
		if (carpeta.exists() && carpeta.isDirectory()) { // En caso de que no exista el directorio te dice de crearlo
			File[] archivos = carpeta.listFiles();
			if (archivos.length <= 0) {
				System.out.println("Parece ser que no tienes archivos");
				Menu.MenuPrincipal();
			} else {
				System.out.println("Pon el numero del archivo que quieres eliminar");

				for (int i = 0; i < archivos.length; i++) {
					System.out.println((i + 1) + ". " + archivos[i].getName());
				}

				try {
					archivos[(Menu.PedirNum(3) - 1)].delete();
					Menu.MenuPrincipal();
				} catch (Exception e) {
					System.out.println(
							"No puedes poner un numero que no hay, por favor, revise si el numero que ha puesto está en la lista");
					Borrar();
				}
			}
		} else {
			Menu.MenuCarpeta();
			System.out.println("Se ha creado la carpeta");
		}

	}
}
