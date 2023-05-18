package ejercicio1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader fichero = null;

		double suma;

		int contador;

		double mediaAritmetica;

		String linea = "";

		String numerosLinea[];

		try {
			fichero = new BufferedReader(new FileReader("src//ejercicio1"));
			linea = fichero.readLine();

			while (linea != null) {
				linea = fichero.readLine();
				numerosLinea = linea.split(" ");
				//for each
			}

		} finally {
			fichero.close();
		}

		/*
		 * FileWriter escribir = null; try { escribir = new
		 * FileWriter("src//ejercicio1"); for (int i =0; i<6;i++) { escribir.write(1); }
		 * 
		 * } catch (IOException e) { System.err.println(e.getMessage()); } finally {
		 * escribir.flush(); escribir.close(); }
		 */

	}

}
