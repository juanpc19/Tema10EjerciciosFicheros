package ejercicio1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = null;

		double suma = 0;

		int contador = 0;

		double mediaAritmetica = 0;

		String linea = "";

		String numerosLinea[];

		try {
			reader = new BufferedReader(new FileReader("src/ejercicio1/NumerosReales.txt"));

			linea = reader.readLine();

			numerosLinea = linea.split(" ");

			for (int i = 0; i < numerosLinea.length; i++) {
				suma += Double.parseDouble(numerosLinea[i]);
				contador++;
			}
			mediaAritmetica = suma / contador;

		} catch (FileNotFoundException e) {
			System.out.println("Error, archivo no encontrado.");

		} finally {
			if (reader != null) {
				try {
					reader.close();

				} catch (IOException e) {
					System.out.println("Error al cerrar el archivo.");
				}
			}
		}
		System.out.println("La suma total es igual a : " + suma + "\nLa media es: " + mediaAritmetica);
	}

}
