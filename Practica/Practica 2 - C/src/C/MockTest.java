package C;


import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mockito.Mockito;

public class MockTest {

	@Test
	public void testCheckWeb() {
		//Creamos los mocks necesarios
		Logger log = mock(Logger.class);
		WebVerificator webVerificator = new WebVerificator(log);
		
		Server ser = Mockito.mock(Server.class);
		Result res = Mockito.mock(Result.class);
		Web web = Mockito.mock(Web.class);

		//Indicamos los valores que evolverán las sucesivas llamadas a lo métodos 
		//connect() e isOk()
		when(ser.connect(web)).thenReturn(res);
		when(res.isOk()).thenReturn(true);

		//Llamamos a la función checkWeb()
		webVerificator.checkWeb(ser, web);
		
		//Verificamos que la función registerWebisOk() se llama desde checkWeb() de log
		verify(log).registerWebisOk(web);
		
	}
	@Test
	public void testCheckWeb1() {
		//Creamos los mocks necesarios
		Logger log = mock(Logger.class);
		WebVerificator webVerificator = new WebVerificator(log);
		
		Server ser = Mockito.mock(Server.class);
		Result res = Mockito.mock(Result.class);
		Web web = Mockito.mock(Web.class);

		//Indicamos los valores que evolverán las sucesivas llamadas a lo métodos 
		//connect() e isOk()
		when(ser.connect(web)).thenReturn(res);
		when(res.isOk()).thenReturn(false);
		
		//Llamamos a la función checkWeb()
		webVerificator.checkWeb(ser, web);
		
		//Verificamos que la función registerWebReturnedError() se llama desde checkWeb() de log
		verify(log).registerWebReturnedError(web, res);
		
	}
}