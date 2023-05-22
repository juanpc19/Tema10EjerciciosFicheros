package ejercicio4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		BufferedWriter escriba = null;

		Scanner dogma = new Scanner(System.in);

		String linea = "";

		try {
			escriba = new BufferedWriter(new FileWriter("src\\ejercicio4\\texto.txt"));

			while (!linea.equalsIgnoreCase("fin")) {

				System.out.println("Introduzca texto a escribir:");
				linea = dogma.nextLine();

				if (!linea.equalsIgnoreCase("fin")) {
					escriba.write(linea);
					escriba.newLine();
				}
			}

		} catch (IOException e) {
			System.out.println("Error, no se pudo crear el archivo.");

		} finally {
			if (escriba != null) {

				try {
					escriba.flush();

				} catch (IOException e) {
					System.out.println("Error, no se puedo hacer el flush.");
				}
				try {
					escriba.close();

				} catch (IOException e) {
					System.out.println("Error al cerrar el archivo.");
				}
			}
		}
		dogma.close();
	}

}
