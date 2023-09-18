package Trabajo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Escritura {

	static Scanner sc = new Scanner(System.in);

	public static void CrearArchivo() {
		File ruta = new File("./Archivos");

		if (!(ruta.exists() && ruta.isDirectory())) {
			CrearCarpeta();
		}

		System.out.println("¿Como quieres llamar al archivo?");
		String nombreArchivo = sc.nextLine() + ".txt";
		try {
			FileWriter archivo = new FileWriter(ruta + "\\" + nombreArchivo);

			System.out.println("Escribe linea a linea y cuando quieras dejar de escribir pulse 0");
			String contenido = "";
			while (true) {
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

	public static void CrearCarpeta() {
		File archivo = new File("./Archivos");
		archivo.mkdir();

		Menu.MenuPrincipal();
	}
}
