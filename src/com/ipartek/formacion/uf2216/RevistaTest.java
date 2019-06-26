package com.ipartek.formacion.uf2216;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RevistaTest {
	Revista revista = new Revista();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		revista.setFormato(false);
		revista.setIsbn("1524Z68T90");
		revista.setTitulo("ipartek");
		revista.setnPagina(13);
	}

	@After
	public void tearDown() throws Exception {
		revista=null;
		
	}

	@Test
	public void testGetTitulo() {
		assertEquals("ipartek",revista.getTitulo());
	}

	@Test
	public void testSetTitulo() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetIsbn() {
		assertEquals("1524Z68T90",revista.getIsbn());
	}

	@Test
	public void testSetIsbn() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetnPagina() {
		assertEquals(13,revista.getnPagina());

	}

	@Test 	public void testSetnPagina() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsFormato() {
		assertEquals(false,revista.isFormato());

	}

	@Test
	public void testSetFormato() {
		fail("Not yet implemented");
	}

}
