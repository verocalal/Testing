package AgendaBreak;

import static org.junit.Assert.assertEquals;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import AgendaBreak.DatoException;
import AgendaBreak.Cita;
import AgendaBreak.Dia;

class DiaTest {
	Dia d;
	Cita c;
	Cita citas;
	Dia dias;

	//CACC
	@Test
	void testDia() {
		// a = true, b= false
		try {
			d = new Dia(2020);
		} catch (DatoException expected) {
			assertEquals("El dia debe tomar valor entre 1 y 366", expected.getMessage());
		}
		// a = false, b= true
		try {
			Dia d2 = new Dia(-2);
		} catch (DatoException expected) {
			assertEquals("El dia debe tomar valor entre 1 y 366", expected.getMessage());
		}
	}

	//PPC
	@Test
	void testBuscaSlot() throws DatoException {
		d = new Dia(4);
		dias = new Dia(5);
		c = new Cita("Cabecera", 9);
		citas = new Cita("Epidemiologo", 1);
		d.asignarCita(9, c);
		dias.asignarCita(9, citas);
		assertEquals(10, dias.buscaSlot(1)); //[1,2,3,5,2,3,4,6,11]
		assertEquals(10, dias.buscaSlot(2)); //[1,2,3,5,2,3,4,7,8,9,10,12]
		assertEquals(-1, d.buscaSlot(1)); //[1,2,3,5,2,3,4,7,8,9,11,2,12]
	}
	

	//CACC
	@Test
	void testAsignarCita() throws DatoException {
		dias = new Dia(5);
		c = new Cita("Cabecera", 4);
		//a=true b=true c=true
		assertTrue(dias.asignarCita(9, c));
		//a=true b=true c=false
		assertFalse(dias.asignarCita(1, c));
		//a=false b=true c=true
		assertFalse(dias.asignarCita(5, c));
	}
	//CACC
	@Test
	void testMuestraCita1() throws DatoException {
		d = new Dia(1);
		c = new Cita("Otorrinolaringolo", 1);
		d.asignarCita(9, c);
		//a = true b = true
        assertEquals("9:00 Otorrinolaringolo", d.muestraCita(9));
        //a = true b = false
        assertEquals("No existe", d.muestraCita(10));
	}
	//BCC
	@Test
	void testGetCita() throws DatoException {
		d = new Dia(1);
		c = new Cita("Fisioneurologo", 1);
		d.asignarCita(9, c);
        assertEquals(null, d.getCita (7));
        assertEquals(null, d.getCita (19));
        assertEquals(c, d.getCita (9));
	}

	//BCC
	@Test
	void testMuestraCita() throws DatoException {
		d = new Dia(1);
		c = new Cita("Nefrologo", 1);
		d.asignarCita(9, c);
        assertEquals("Hora no valida", d.muestraCita (5));
        assertEquals("No existe", d.muestraCita(10));
        assertEquals("9:00 Nefrologo", d.muestraCita(9));
	}

	@Test
	void testGetDiaNumero() {
		fail("Not yet implemented");
	}

	//BBC
	@Test
	void testValidaHora() throws DatoException {
		Dia d = new Dia(1);
        assertFalse(d.validaHora (5));
        assertTrue(d.validaHora (15));
        assertFalse(d.validaHora (25));
	}

	@Test
	void testHuecoLibre() {
		fail("Not yet implemented");
	}

}
