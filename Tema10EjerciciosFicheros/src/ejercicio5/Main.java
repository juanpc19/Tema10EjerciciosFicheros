package ejercicio5;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		BufferedWriter escriba = null;

		Scanner dogma = new Scanner(System.in);

		String decision = "";

		String nombre = "";

		int edad = 0;

		try {
			escriba = new BufferedWriter(new FileWriter("src\\ejercicio5\\datos.txt", true));

			while (!decision.equalsIgnoreCase("no")) {

				System.out.println("Quiere añadir un nombre y edad a la lista?");
				decision = dogma.nextLine();

				if (!decision.equalsIgnoreCase("no")) {
					System.out.println("Introduzca su nombre:");
					nombre = dogma.nextLine();
					System.out.println("Introduzca su edad:");
					edad = dogma.nextInt();
					dogma.nextLine();

					escriba.write("Nombre: " + nombre + ", edad: " + edad);
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
