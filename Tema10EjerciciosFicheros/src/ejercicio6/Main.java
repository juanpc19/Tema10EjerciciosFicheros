package ejercicio6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		// archivo leer padsar lectura a LISTA ORDENADA! y de ahi a otro fichero

		Set<Integer> listaNumeros = new TreeSet<Integer>();

		BufferedWriter escriba = null;

		BufferedReader lector = null;

		String linea = "";

		int lineaInt = 0;

		try {
			escriba = new BufferedWriter(new FileWriter("src\\ejercicio6\\NumerosDesordenados.txt"));
			escriba.write(String.valueOf(10));
			escriba.newLine();

			for (int i = 0; i < 10; i++) {
				escriba.write(String.valueOf(i));
				escriba.newLine();
			}

		} catch (IOException e) {
			System.out.println("Error al crear el archivo.");

		} finally {
			if (escriba != null) {
				try {
					escriba.flush();
				} catch (IOException e) {
					System.out.println("Error, al hacer el flush.");
				}
				try {
					escriba.close();
				} catch (IOException e) {
					System.out.println("Error al cerrar el archivo.");
				}
			}
		}

		try {
			lector = new BufferedReader(new FileReader("src\\ejercicio6\\NumerosDesordenados.txt"));
			linea = lector.readLine();

			while (linea != null) {
				lineaInt = Integer.parseInt(linea);
				listaNumeros.add(lineaInt);
				linea = lector.readLine();
			}
			System.out.println(listaNumeros);

		} catch (FileNotFoundException e) {
			System.out.println("Error, no se puedo encontrar el archivo.");
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

		try {
			escriba = new BufferedWriter(new FileWriter("src\\ejercicio6\\NumerosOrdenados.txt"));

			for (int n : listaNumeros) {
				escriba.write(String.valueOf(n));
				escriba.newLine();
			}

		} catch (IOException e) {
			System.out.println("Error al crear el archivo.");

		} finally {
			if (escriba != null) {
				try {
					escriba.flush();
				} catch (IOException e) {
					System.out.println("Error, al hacer el flush.");
				}
				try {
					escriba.close();
				} catch (IOException e) {
					System.out.println("Error al cerrar el archivo.");
				}
			}
		}
	}

}
