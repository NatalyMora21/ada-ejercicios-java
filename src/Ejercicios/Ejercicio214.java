package Ejercicios;

import java.util.Scanner;

public class Ejercicio214 {

	public static void main(String[] args) {

		Scanner sc;
		sc = new Scanner(System.in);

		int costoentrega = 0;

		System.out.println("Ingrese peso del envio ");
		int peso = sc.nextInt();
		System.out.println("Ingrese el número de la zona ");
		int zona = sc.nextInt();

		if (peso < 5) {

			switch (zona) {

			case 1: {
				costoentrega = 11 * peso;
				break;
			}
			case 2: {
				costoentrega = 10 * peso;
				break;
			}
			case 3: {
				costoentrega = 12 * peso;
				break;
			}
			case 4: {
				costoentrega = 24 * peso;
				break;
			}

			case 5: {
				costoentrega = 27 * peso;
				break;

			}
			default:
				System.out.println("Zona no válida");
				break;

			}
		} else {
			System.out.println("El paquete no puede ser transportado");
		}
		System.out.println("El costo total del envío es: " + costoentrega);

	}

}
