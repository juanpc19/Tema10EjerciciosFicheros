package ejercicio2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner dogma = null;
		
		double suma = 0;
		
		int contador = 0;
		
		double mediaAritmetica = 0;

		try {
			dogma = new Scanner(new FileReader("src/ejercicio2/Enteros.txt"));

			while (dogma.hasNextInt()) {

				suma += dogma.nextInt();
				contador++;
			}
			mediaAritmetica = suma / contador;

		} catch (FileNotFoundException e) {
			System.out.println("Error archivo no encontrado");

		} finally {
			try {
				dogma.close();

			} catch (Exception e) {
				System.out.println("Error al cerrar el archivo.");
			}
		}
		System.out.println("La suma total es igual a : " + suma + "\nLa media es: " + mediaAritmetica);
	}

}
