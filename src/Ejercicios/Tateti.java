package Ejercicios;

import java.util.Scanner;

public class Tateti {

	static Scanner sc = new Scanner(System.in);

	static int validacionhorizontal(String tablero[][]) {
		int horizontales = 0;
		int ganador = 0;
		for (int i = 0; i < 3; i++) {
			horizontales = 0;
			for (int j = 0; j < 2; j++) {
				if (tablero[i][j] != "") {
					if (tablero[i][j] == tablero[i][j + 1]) {
						horizontales++;
					}
				}
			}
			if (horizontales == 2) {
				ganador = 1;
			}
		}
		return ganador;
	}

	static int validacionvertical(String tablero[][]) {
		int verticales = 0;
		int ganador = 0;
		for (int i = 0; i < 3; i++) {
			verticales = 0;
			for (int j = 0; j < 2; j++) {
				if (tablero[j][i] != "") {
					if (tablero[j][i] == tablero[j + 1][i]) {
						verticales++;
					}
				}
			}
			if (verticales == 2) {
				ganador = 1;
			}

		}
		return ganador;

	}

	static int validaciondiagonal(String tablero[][]) {
		int diagonal = 0;
		int ganador = 0;

		for (int i = 0; i < 2; i++) {
			diagonal = 0;
			if (tablero[i][i] != "") {
				if (tablero[i][i] == tablero[i + 1][i]) {
					diagonal++;
				}
			}
			if (diagonal == 2) {
				ganador = 1;
			}

		}
		return ganador;

	}

	static void coordenadas(String[][] tablero, String[][] valores, String ficha) {

		int posicion1 = 0;
		int posicion2 = 0;

		System.out.println("Ingrese la primera coordenada");
		posicion1 = sc.nextInt();

		System.out.println("Ingrese la segunda coordenada");
		posicion2 = sc.nextInt();

		if (valores[posicion1 - 1][posicion2 - 1].equals("O") || valores[posicion1 - 1][posicion2 - 1].equals("X")) {
			System.out.println("Campo lleno, --Intente nuevamente--");
			coordenadas(tablero, valores, ficha);

		} else {
			System.out.println();
			tablero[posicion1 - 1][posicion2 - 1] = ficha + " ";
			valores[posicion1 - 1][posicion2 - 1] = ficha;
			tablero(tablero);
		}
	}

	static void tablero(String[][] tablero) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(tablero[i][j] + " ");
			}
			System.out.println(" ");
		}
	}

	public static void main(String[] args) {

		String tablero[][] = { { "__", "__", "__" }, { "__", "__", "__" }, { "__", "__", "__" } };
		String valores[][] = { { "", "", "" }, { "", "", "" }, { "", "", "" } };

		int movimiento = 0;
		String ficha;

		while (movimiento != 9) {

			if (movimiento % 2 == 0) {
				System.out.println("TURNO JUGADOR 1");
				ficha = "O";
			} else {
				System.out.println("TURNO JUGADOR 2");
				ficha = "X";
			}

			coordenadas(tablero, valores, ficha);

			if (movimiento >= 3) {
				validacionhorizontal(valores);
				validacionvertical(valores);
				validaciondiagonal(valores);

				if (validacionvertical(valores) == 1 || validacionhorizontal(valores) == 1
						|| validaciondiagonal(valores) == 1) {

					System.out.println("Ganador");
					break;
				} else {

				}
			}

			movimiento++;

		}

		//

		// TODO Auto-generated method stub

	}

}
