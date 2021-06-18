package Ejercicios;

import java.util.Scanner;

public class Tateti {

	static Scanner sc = new Scanner(System.in);

	// Verifica si en algunas de las filas las fichas son las mismas
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

	// Verifica si en algunas de las columnas las fichas son las mismas
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

	// Verifica si en la diagonal de izquierda a derecha las fichas son las mismas
	static int validaciondiagonal(String tablero[][]) {
		int diagonal = 0;
		int ganador = 0;

		for (int i = 0; i < 2; i++) {

			if (tablero[i][i] != "") {
				if (tablero[i][i] == tablero[i + 1][i + 1]) {
					diagonal++;
				}
			}
			if (diagonal == 2) {
				ganador = 1;
			}
		}
		return ganador;

	}

	// Verifica si en la diagonal de derecha a izquierda las fichas son las mismas
	static int validaciondiagonalder(String tablero[][]) {
		int ganador = 0;

		if (tablero[0][2] == tablero[1][1] && tablero[1][1] == tablero[2][0]) {
			ganador = 1;
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

		if (posicion1 > 3 || posicion2 > 3) {
			System.out.println("Coordenas inválidas, --Intente nuevamente--");
			coordenadas(tablero, valores, ficha);

		} else {
			if (valores[posicion1 - 1][posicion2 - 1].equals("O")
					|| valores[posicion1 - 1][posicion2 - 1].equals("X")) {
				System.out.println("Campo lleno, --Intente nuevamente--");
				coordenadas(tablero, valores, ficha);

			} else {
				System.out.println();
				tablero[posicion1 - 1][posicion2 - 1] = ficha + " ";
				valores[posicion1 - 1][posicion2 - 1] = ficha;
				tablero(tablero);
			}
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
		int jugador;
		int movimiento = 0;
		String ficha;

		while (movimiento != 9) {
			if (movimiento % 2 == 0) {
				jugador = 1;
				ficha = "O";
			} else {
				jugador = 2;
				ficha = "X";
			}
			System.out.println("TURNO JUGADOR " + jugador);
			coordenadas(tablero, valores, ficha);
			if (movimiento >= 3) {

				if (validacionvertical(valores) == 1 || validacionhorizontal(valores) == 1
						|| validaciondiagonal(valores) == 1 || validaciondiagonalder(valores) == 1) {

					System.out.println("¡¡ GANADOR :) !!, JUGADOR " + jugador);
					break;
				}
			}
			movimiento++;

		}

		if (movimiento == 9) {
			System.out.println("¡¡ EMPATE :C !!");

		}

	}

}
