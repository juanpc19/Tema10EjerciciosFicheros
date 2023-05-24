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

		Scanner dogma = new Scanner(System.in);

		BufferedWriter escriba = null;

		BufferedReader lector = null;

		String linea = "";

		String lineaSeparada[];

		int seleccion = 0;

		String fecha = "";

		double temperaturaMax = Double.MIN_VALUE;

		double temperaturaMaxFinal = Double.MIN_VALUE;

		double temperaturaMin = Double.MAX_VALUE;

		double temperaturaMinFinal = Double.MAX_VALUE;

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
					temperaturaMax = dogma.nextDouble();

					System.out.println("Introduzca la temperatura minima. ");
					temperaturaMin = dogma.nextDouble();

					dogma.nextLine();

					escriba.write(fecha + ", ");
					escriba.write(temperaturaMax + ", ");
					escriba.write(temperaturaMin + "");
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

					System.out.println("Fecha, Temperatura máxima, Temperatura mínima.");

					while (linea != null) {

						lineaSeparada = linea.split(",");
						System.out.println(linea);

						if (temperaturaMaxFinal < Double.parseDouble(lineaSeparada[1])) {
							temperaturaMaxFinal = Double.parseDouble(lineaSeparada[1]);
						}

						if (temperaturaMinFinal > Double.parseDouble(lineaSeparada[2])) {
							temperaturaMinFinal = Double.parseDouble(lineaSeparada[2]);
						}

						linea = lector.readLine();

					}

					System.out.println("Temperatura maxima: " + temperaturaMaxFinal);
					System.out.println("Temperatura minima: " + temperaturaMinFinal);

				} catch (FileNotFoundException e) {
					System.out.println("Error, archivo no encontrado.");
				} catch (IOException e) {
					System.out.println("Error, siguiente linea igual a null.");

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
