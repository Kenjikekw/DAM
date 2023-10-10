package Trabajo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Escritura {

	static Scanner sc = new Scanner(System.in);
	
	/* Pre: Te crea un archivo con el contenido que quieres en la carpeta de archivos
	 * Pro: Una vez en el menu te deja elegir lo que quieres hacer
	 * 
	 * ORG 15/09/2023
	 */

	public static void CrearArchivo() {
		File ruta = new File("./Archivos");

		if (!(ruta.exists() && ruta.isDirectory())) { //En case de que no exista la ruta te crea la carpeta
			CrearCarpeta();
		}

		System.out.println("¿Como quieres llamar al archivo?");
		String nombreArchivo = sc.nextLine() + ".txt";
		try {
			FileWriter archivo = new FileWriter(ruta + "\\" + nombreArchivo);

			System.out.println("Escribe linea a linea y cuando quieras dejar de escribir pulse 0");
			String contenido = "";
			while (true) {							// Te deja escribir todas las lineas que quieras hasta que escribes un 0 suelto
				String mensaje = sc.nextLine();
				if (mensaje.equals("0")) {
					break;
				} else {
					contenido += mensaje + "\n";
				}
			}
			archivo.write(contenido);

			archivo.close();
			System.out.println("Se ha guardado correctamente");
			Menu.MenuPrincipal();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/* Pre: Te crea una carpeta en el directorio raiz con el nombre de Archivos
	 * Pro: Te crea la carpeta y te lleva al menu principal
	 * 
	 * ORG 18/09/2023
	 */

	public static void CrearCarpeta() {
		File archivo = new File("./Archivos");
		archivo.mkdir();

		Menu.MenuPrincipal();
	}
}
