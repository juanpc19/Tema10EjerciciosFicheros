package ejercicio1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {

		FileWriter escribir = null;

		try {
			escribir = new FileWriter("C:\\Escritorio\\NumerosReales.txt");
			for (int i =0; i<6;i++) {
				escribir.write(1);
			}
			
		} catch (IOException e) {
			System.err.println(e.getMessage());
		} finally {
			escribir.flush();
			escribir.close();
		}

		
		
	}

}
