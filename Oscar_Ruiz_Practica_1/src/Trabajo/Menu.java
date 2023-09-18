package Trabajo;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
	static Scanner sc = new Scanner(System.in);

	public static int PedirNum(int metodo) {
		try {
			int num = sc.nextInt();
			return num;
		} catch (Exception a) {
			LimpiarConsola();
			System.out.println("Error; debes elegir un numero valido");
			sc.next();
			switch(metodo) {
			case 1:
				MenuPrincipal();
				break;
			case 2:
				MenuCarpeta();
				break;	
			case 3:
				Borrado.Borrar();
				break;
			case 4:
				Lectura.LeerArchivo();
				break;
			}
		}
		return 0;
	};

	public static void MenuPrincipal() {
		System.out
				.println("Hola, ¿que quieres hacer hoy? \n 1. Leer archivo\n 2. Crear archivo\n 3. Borrar archivo\n 4. Salir");
		int num = PedirNum(1);
		switch (num) {
		case 1:
			Lectura.LeerArchivo();
			break;
		case 2:
			Escritura.CrearArchivo();
			break;
		case 3:
			Borrado.Borrar();
			break;
		case 4:
			System.exit(0);
			break;
		default:
			System.out.println("Elige otra vez un numero del menu");
			LimpiarConsola();
			MenuPrincipal();
			break;
		}
	}
	
	public static void MenuCarpeta() {
		System.out.println(
				"Parece ser que aun no has creado ningun archivo; ¿Quieres crear uno nuevo?\n 1. Si\n 2. No");
		switch (Menu.PedirNum(2)) {
		case 1:
			Escritura.CrearCarpeta();
			break;
		case 2:
			MenuPrincipal();
			break;
		}
	}

	public static void LimpiarConsola() {
			//Algo
	}
}
