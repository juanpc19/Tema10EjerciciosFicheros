package ejercicio8;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// metodo de lectura y escritura simultanea valido, sino consigo hacerlo
		// funcionar probar con array String bidimensional [0][2],
		// posible problema al extender el array cpn nueva introduccion de datos

		Scanner dogma = null;

		FileWriter escriba = null;

		try {

			dogma = new Scanner(new FileReader("src\\ejercicio8\\RegistroMeteorologico.txt"));

		} catch (FileNotFoundException e) {

			System.out.println("a");
		}
	}

}
