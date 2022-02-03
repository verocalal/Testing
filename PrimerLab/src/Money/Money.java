package Money;

public class Money implements Comparable {
	
	private int cantidad;
	private Divisa divisa;

	/**
	 * @param cantidad	
	 * @param divisa	
	 */
	Money (int cantidad, Divisa divisa) {
		this.cantidad = cantidad;
		this.divisa = divisa;
	}
	
	/**
	 * Return Cantidad.
	 * @return Cantidad.
	 */
	public int getCantidad() {
		return cantidad;
	}
	
	/**
	 * Returns Divisa.
	 * @return Divisa asociada a esta cantidad
	 */
	public Divisa getDivisa() {
		return divisa;
	}
	
	/**
	 * Devuelve un String "cantidad nombre de divisa", e.g. "10.5 SEK".
	 * Los numeros decimales se representan con enteros, e.g "10.5 SEK" se almacena como 1050
	 * 
	 *  @return String con información de la moneda.
	 */
	public String toString() {
		return String.format("cantidad nombre de divisa " + cantidad + "SEK");
	}
	
	/**
	 * Valor universal de la cantidad de acuerdo al rate asociado a la divisa
	 * @return Valor universal de la cantidad
	 */
	public Double valorUniversal() {
		return divisa.getRate();
	}
	
	/**
	 * Chequea si el valor universal de otro objeto Money es equivalente al actual
	 * @param Objeto Money a comparar
	 * @return Boolean indicando equivalencia
	 */
	public Boolean equals(Money otra) {
		return otra.cantidad == this.cantidad;
	}
	
	/**
	 * Añade un objeto Money al actual
	 * @param Objeto Money a añadir.
	 * @return Un nuevo objeto Money con la divisa del actual, y la cantidad acumulada con el importe del objeto Money recibido.
	 **/
	public Money add(Money otra) {
		Money nuevo = null;
		nuevo.divisa=this.divisa;
		nuevo.cantidad=otra.cantidad;
		return nuevo;
	}

		
	/**
	 * 
	 * @return True si cantidad es cero, false e.o.c.
	 */
	public Boolean isZero() {
		boolean ok;
		if(cantidad == 0) ok = true;
		else ok = false;
		return ok;
	}
	/**
	 * Convierte la cantidad del objeto actual a negativo
	 * @return Un nuevo objeto Money con la cantidad en negativo
	 */
	public Money negate() {
		Money m = null;
		m.cantidad = m.cantidad - (2*m.cantidad);
		return m;
	}

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
	 * Compara dos objetos Money
	 * @return 0  si sus valores son iguales
	 * Un entero negativo si el objeto actual tiene menos valor que el recibido
	 * Un entero positivo si el objeto actual tiene más valor que el recibido
	 */
}