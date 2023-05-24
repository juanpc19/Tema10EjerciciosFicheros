package ejercicio8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	private static final String FICHERO = "src\\ejercicio8\\RegistroMeteorologico.txt";

	public static void main(String[] args) {

		//guardar temperaturas en listas y puede que fechas tambien
		Scanner dogma = new Scanner(System.in);

		BufferedWriter escriba = null;

		BufferedReader lector = null;

		String linea = "";

		boolean archivoVacio = true;

		int seleccion = 0;

		String fecha = "";

		int temperaturaMax = 0;

		int temperaturaMaxFinal = Integer.MIN_VALUE;

		int temperaturaMin = 0;

		int temperaturaMinFinal = 0;

		while (seleccion != 3) {
			MenuCrud.menu();

			seleccion = dogma.nextInt();
			dogma.nextLine();

			switch (seleccion) {

			case 1 -> {

				try {

					escriba = new BufferedWriter(new FileWriter(FICHERO, true));

					System.out.println("Introduzca la fecha en el siguiente formato: 2023-01-15. ");
					fecha = dogma.nextLine();
					
					System.out.println("Introduzca la temperatura maxima. ");
					temperaturaMax = dogma.nextInt();
					if (temperaturaMax > temperaturaMaxFinal) {
						temperaturaMaxFinal = temperaturaMax;
					}
					
					System.out.println("Introduzca la temperatura minima. ");
					temperaturaMin = dogma.nextInt();
					if (temperaturaMin < temperaturaMinFinal) {
						temperaturaMinFinal = temperaturaMin;
					}

					dogma.nextLine();

					if (archivoVacio == true) {
						escriba.write("Fecha, Temperatura máxima, Temperatura mínima.");
						escriba.newLine();
					}
					archivoVacio = false;

					escriba.write(fecha + ", ");
					escriba.write(temperaturaMax + ", ");
					escriba.write(temperaturaMin + ".");
					escriba.newLine();

				} catch (IOException e) {
					System.out.println("Archivo no encontrado. ");

				} finally {

					if (escriba != null) {
						try {
							escriba.flush();
						} catch (IOException e) {
							System.out.println("Error al hacer el flush.");
						}
						try {
							escriba.close();
						} catch (IOException e) {
							System.out.println("Error al cerrar el archivo.");
						}
					}
				}

			}

			case 2 -> {
				try {
					lector = new BufferedReader(new FileReader(FICHERO));

					linea = lector.readLine();

					while (linea != null) {
						System.out.println(linea);
						linea = lector.readLine();
					}
					System.out.println(temperaturaMaxFinal);
					System.out.println(temperaturaMinFinal);
					
				} catch (FileNotFoundException e) {
					System.out.println("Error, archivo no encontrado.");
				} catch (IOException e) {
					System.err.println("Error, siguiente linea igual a null.");

				} finally {
					if (lector != null) {
						try {
							lector.close();
						} catch (IOException e) {
							System.out.println("Error, al cerrar el archivo.");
						}
					}
				}
			}

			case 3 -> {
				System.out.println("Cerrando programa...");
			}
			}

		}
		dogma.close();
	}

}
