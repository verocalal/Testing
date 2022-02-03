package B;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class MockTest {

	@Test
	public void testEmitirFactura() {
		EmailService emailService = mock(EmailService.class);
		PrinterService printerService = mock(PrinterService.class);
		Factura factura = mock(Factura.class);
		EmisorFactura emisorFactura = new EmisorFactura(printerService, emailService);
		String email = "";
		boolean opt = false;
		Cliente cliente = new Cliente(email, opt);
		
		assertFalse(cliente.prefiereEmails());
		//when(cliente.getEmail()).thenReturn("Recibido");
		//doThrow(new Exception()).when(emailService).sendFactura(factura, email);
		//doThrow(new Exception()).when(printerService).printFactura(factura);
		
		emisorFactura.emitirFactura(factura, cliente);
		
		//verify(printerService).printFactura(factura);
		//verify(emailService).sendFactura(factura, email);
	}

}
