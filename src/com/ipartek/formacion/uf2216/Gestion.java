package com.ipartek.formacion.uf2216;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Gestion {

	private static final int OPCION_CREAR = 1;
	private static final int OPCION_LISTAR = 2;
	private static final int OPCION_FICHERO = 3;
	private static final int OPCION_SALIR = 0;

	static Revista revista;
	static ArrayList<Revista> revistas = new ArrayList<Revista>();
	static Scanner sc;
	static int op;
	static String aux ="";
	static String titulo; // > 3 ; < 10
	static String isbn; // ==10
	static int nPagina;// >1
	static boolean formato; // true == digital ; false == papel

	/**
	 * Aplicacion principal del CMS para gestionar revistas
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("*********************************************");
		System.out.println("*************GESTION DE REVISTAS*************");
		System.out.println("*********************************************");
		System.out.println("\n");

		sc = new Scanner(System.in);

		do {
			System.out.println(OPCION_CREAR + " - Crear Revista");
			System.out.println(OPCION_LISTAR + " - Listar Revista");
			System.out.println(OPCION_FICHERO + " - Guardar en Fichero");
			System.out.println(OPCION_SALIR + " - Salir");

			System.out.println("Elige una opcion:");
			aux = sc.nextLine().trim();
			if("".equals(aux) ) {
				aux="-1";
				op = Integer.parseInt(aux);
			}else {
			op = Integer.parseInt(aux);
			}
			
			switch (op) {
			case OPCION_CREAR:
				crear();
				break;

			case OPCION_LISTAR:
				listar();
				break;
			case OPCION_FICHERO:
				generarFichero();
				break;

			case OPCION_SALIR:
				break;
			default:
				System.out.println("Nos elegido una opcion valida");
				break;
			}
		} while (op != OPCION_SALIR);

		sc.close();
	}

	/**
	 * Metodo que muestra una lista con todas las revistas creadas ordenadas por el numero de
	 * paginas
	 */

	public static void listar() {
		Collections.sort(revistas);
		for (int i = 0; i < revistas.size(); i++) {
			System.out.println(i + 1 + " - " + revistas.get(i).toString());

		}

	}

	/**
	 * Metodo para crear las revistas nuevas
	 */

	public static void crear() {

		String format;
		String salvar;

		// REGISTRAMOS EL TITULO
		do {
			System.out.println("Introduce el titulo de la revista (debe tener de " + Revista.MIN_LONG_TITULO + " a "
					+ Revista.MAX_LONG_TITULO + "  caracteres):");
			titulo = sc.nextLine();
		
		} while (titulo.length() < Revista.MIN_LONG_TITULO || titulo.length() > Revista.MAX_LONG_TITULO);
	
		// FIN NUMERO TITULO
		 
		// REGISTRAMOS EL ISBN
		do {
			System.out.println("Introduce el ISBN de la revista (debe tener " + Revista.LONG_ISBN + " caracteres):");
			isbn = sc.nextLine().trim();

			if (isbn.length() != Revista.LONG_ISBN) {
				System.out.println("El ISBN no tiene el formato solicitado.");
				System.out.println("-->Recuerda tiene que ser de " + Revista.LONG_ISBN + " caracteres.<--");
			}
		} while (isbn.length() != Revista.LONG_ISBN);
		// FIN NUMERO ISBN
		
		
		// REGISTRAMOS EL NUMERO DE PAGINAS
		do {

			System.out.println("Introduce el numero de paginas de la revista (Tiene que tener minimo " + Revista.MIN_PAGINAS
					+ " pagina/as):");
			nPagina = Integer.parseInt(sc.nextLine().trim());

			if (nPagina < Revista.MIN_PAGINAS ) {
				System.out.println("Tiene que tener al menos " + Revista.MIN_PAGINAS + " pagina/as.");
			}
		} while (nPagina < Revista.MIN_PAGINAS || nPagina > Integer.MAX_VALUE);
		// FIN NUMERO PAGINAS
	
		
		// REGISTRAMOS EL FORMATO DE LA REVISTA
		do {

			System.out.println("Elige el formato de la revista:");
			System.out.println(Revista.OPCION_DIGITAL + " -Digital");
			System.out.println(Revista.OPCION_PAPEL + " - Papel");
			format = sc.nextLine().trim();

			switch (format) {
			case Revista.OPCION_DIGITAL:
				formato = true;
				break;
			case Revista.OPCION_PAPEL:
				formato = false;
				break;
			default:
				System.out.println("No has elegido ninguna de las " + Revista.N_OPCIONES + " opciones posibles.");
			}

		} while (!Revista.OPCION_DIGITAL.equals(format) && !Revista.OPCION_PAPEL.equals(format));

		if (formato) {
			System.out.println("Formato: Digital");
		} else {
			System.out.println("Formato: Papel");
		}
		// FIN FORMATO
		
		revista = new Revista(titulo, isbn, nPagina, formato);
		
    	
		// OPCION GUARDAR
		System.out.println("Has creado la revista: " + revista.toString() );
		
		
		System.out.println("¿Quieres guardar la revista? (Y/n)");
		salvar = sc.nextLine().trim().toLowerCase();
		do {
			switch (salvar) {
			case "y":
				revistas.add(revista);
				break;
			case "n":
				break;
			default:
				System.out.println("No has elegido ninguna de las opciones posibles.");
			}
		} while (!"y".equals(salvar) && !"n".equals(salvar));
		// FIN OPCION DE GUARDAR
		
	}

	/**
	 * Metodo para guardar las revistas creadas en un fichero de texto
	 * 
	 * @throws IOException
	 */

	public static void generarFichero() {

		String ruta = "fichero.txt";
		File f = new File(ruta);
		System.out.println("Tu archivo se a guardado en " + f.getAbsolutePath());
		FileWriter fw;
		try {
			fw = new FileWriter(f);
			BufferedWriter escritura = new BufferedWriter(fw);
			for (int i = 0; i < revistas.size(); i++) {
				escritura.write(revistas.get(i).toString());
				escritura.newLine();

			}
			escritura.close();
		} catch (IOException e) {
			System.out.println("No se ha podido crear el archivo.");
			e.printStackTrace();
		}

		
	}

}
