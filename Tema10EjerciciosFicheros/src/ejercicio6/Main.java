package ejercicio6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		// archivo leer padsar lectura a LISTA ORDENADA! y de ahi a otro fichero

		BufferedWriter escriba = null;

		BufferedReader lector = null;
		int numeroRandom=0;

		try {
			escriba = new BufferedWriter(new FileWriter("src\\ejercicio6\\NumerosDesordenados.txt"));

			for (int i = 0; i < 10; i++) {
				numeroRandom = (int) (Math.random() * 100);
				escriba.write(String.valueOf(numeroRandom));
				escriba.newLine();
			}

		} catch (IOException e) {
			System.out.println("Error al crear el archivo");
			
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
	//aqui leo archivo

	}

}
