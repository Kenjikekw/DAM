package Trabajo;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
	static Scanner sc = new Scanner(System.in);

	public static int PedirNum() {
		try {
			int num = sc.nextInt();
			return num;
		} catch (Exception a) {
			LimpiarConsola();
			System.out.println("Error; debes elegir un numero valido");
			sc.next();
			Menu();
		}
		return 0;
	};

	public static void Menu() {
		System.out
				.println("Hola, ¿que quieres hacer hoy? \n 1. Leer archivo\n 2. Crear archivo\n 3. Modificar archivo");
		int num = PedirNum();
		switch (num) {
		case 1:
			System.out.println("lalal");
			break;
		case 2:
			System.out.println("2");
			break;
		case 3:
			System.out.println("3");
		default:
			System.out.println("Elige otra vez un numero del menu");
			LimpiarConsola();
			Menu();
		}
	}

	public static void LimpiarConsola() {
			//Algo
	}
}
