package com.ipartek.formacion.uf2216;



public class Revista implements Comparable<Revista>, Leible<Revista> {
	public static final int MIN_PAGINAS = 1;
	public static final int MIN_LONG_TITULO = 3;
	public static final int MAX_LONG_TITULO = 10;
	public static final int LONG_ISBN = 10;
	public static final int N_OPCIONES = 2;
	public static final String OPCION_DIGITAL = "1";
	public static final String OPCION_PAPEL = "2";
	public static final int MAX_PAGINAS = 999999998;
	
	

	String titulo; // > 3 ; < 10
	String isbn; // ==10
	int nPagina;// >1
	boolean formato; // true == digital ; false == papel
	
	

	public Revista() {
		super();
		
	}

	public Revista(String titulo, String isbn, int nPagina, boolean formato) {
		super();
		this.setTitulo(titulo);
		this.setIsbn(isbn);
		this.setnPagina(nPagina);
		this.setFormato(formato);
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		
		
		this.isbn = isbn;
	}

	public int getnPagina() {
		return nPagina;
	}

	public void setnPagina(int nPagina) {
		this.nPagina = nPagina;
	}

	public boolean isFormato() {
		return formato;
	}

	public void setFormato(boolean formato) {
		this.formato = formato;
	}
	
	

	@Override
	public String toString() {
		return "Revista [titulo=" + titulo + ", isbn=" + isbn + ", nPagina=" + nPagina + ", formato=" + formato + "]";
	}

	@Override
	public int compareTo(Revista o) {
		return o.getnPagina() - this.nPagina;

	}


}
