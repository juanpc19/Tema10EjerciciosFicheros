package ejercicio3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) {

		BufferedReader lector = null;

		double sumaEdades = 0;

		double sumaAlturas = 0;

		int contador = 0;

		double mediaEdades = 0;

		double mediaAlturas = 0;

		String linea = "";

		String lineaSeparada[];

		Set<String> listaNombres = new LinkedHashSet<String>();

		try {
			lector = new BufferedReader(new FileReader("src/ejercicio3/Alumnos.txt"));

			linea = lector.readLine();

			while (linea != null) {
				lineaSeparada = linea.split(" ");

				for (int i = 0; i < lineaSeparada.length; i++) {

					switch (i) {

					case 0 -> {
						listaNombres.add(lineaSeparada[0]);
					}

					case 1 -> {
						sumaEdades += Integer.valueOf(lineaSeparada[1]);
					}

					case 2 -> {
						sumaAlturas += Double.valueOf(lineaSeparada[2]);
					}

					}
				}
				contador++;
				linea = lector.readLine();
			}

			mediaEdades = sumaEdades / contador;

			mediaAlturas = sumaAlturas / contador;

			for (String n : listaNombres) {
				System.out.println(n);
			}

			System.out.println(
					"La media de las edades es : " + mediaEdades + "\nLa media de las alturas es: " + mediaAlturas);

		} catch (FileNotFoundException e) {
			System.out.println("Error, el archivo no se ha encontrado.");

		} catch (IOException e) {
			System.out.println("Error, siguiente linea igual a null.");

		} finally {
			try {
				lector.close();

			} catch (IOException e) {
				System.out.println("Error, al cerrar el archivo.");
			}
		}

	}

}
