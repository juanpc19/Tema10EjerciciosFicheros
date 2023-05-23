package ejercicio7;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) {

		Map<String, Integer> agenda = new TreeMap<String, Integer>();

		int seleccionUsuario = 0;

		String nombre = "";

		int numeroTelefono = 0;

		Scanner dogma = new Scanner(System.in);

		while (seleccionUsuario != 4) {

			Menu.menu();

			seleccionUsuario = dogma.nextInt();
			dogma.nextLine();

			switch (seleccionUsuario) {

			case 1 -> {

				System.out.println("Introduzca nombre para el nuevo contacto:");
				nombre = dogma.nextLine();

				System.out.println("Introduzca numero de telefono para el nuevo contacto:");
				numeroTelefono = dogma.nextInt();
				System.out.println();

				if (agenda.size() < 20) {

					if (nombre != null && !nombre.isEmpty() && numeroTelefono > 0) {
						agenda.put(nombre, numeroTelefono);
					} else {
						System.out.println("Error al introducir los datos.");
					}
				} else {
					System.out.println("Agenda llena.");
				}

			}
			case 2 -> {

				System.out.println("Introduzca nombre para buscar el contacto:");
				nombre = dogma.nextLine();

				if (agenda.containsKey(nombre)) {
					System.out.println(agenda.get(nombre));
					System.out.println();

				} else {
					System.out.println("Contacto no existente.");
				}

			}
			case 3 -> {

				for (Entry<String, Integer> p : agenda.entrySet()) {
					System.out.println("Nombre: " + p.getKey());
					System.out.println("Numero telefono: " + p.getValue());
					System.out.println();
				}

			}
			case 4 -> {

				BufferedWriter escriba = null;
				try {
					escriba = new BufferedWriter(new FileWriter("src\\ejercicio7\\Agenda.txt", true));

					for (Entry<String, Integer> p : agenda.entrySet()) {

						escriba.write("Nombre: " + p.getKey());
						escriba.write(" Numero telefono: " + p.getValue());
						escriba.newLine();
					}

				} catch (IOException e) {
					System.out.println("Error al crear el archivo.");

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

					System.out.println("Programa cerrandose...");
				}
			}
			}
		}
		dogma.close();
	}

}
