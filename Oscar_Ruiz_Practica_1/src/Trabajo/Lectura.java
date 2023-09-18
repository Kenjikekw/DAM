package Trabajo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Lectura {

	public static void LeerArchivo() {

		File carpeta = new File("./Archivos");
		if (carpeta.exists() && carpeta.isDirectory()) {
			File[] archivos = carpeta.listFiles();
			if (archivos.length <= 0) {
				System.out.println("Parece ser que no tienes archivos");
				Menu.MenuPrincipal();
			} else {
				System.out.println("Pon el numero del archivo que quieres leer");

				for (int i = 0; i < archivos.length; i++) {
					System.out.println((i + 1) + ". " + archivos[i].getName());
				}

				try {
					 
		                BufferedReader lector = new BufferedReader(new FileReader(archivos[Menu.PedirNum(4) - 1]));

		                String linea;
		                while ((linea = lector.readLine()) != null) {
		                    System.out.println(linea);
		                }

		                lector.close();
		                Menu.MenuPrincipal();
				} catch (Exception e) {
					System.out.println(
							"No puedes poner un numero que no hay, por favor, revise si el numero que ha puesto está en la lista");
					LeerArchivo();
				}
			}
		} else {
			Menu.MenuCarpeta();
			System.out.println("Se ha creado la carpeta");
		}

	}
}
