package co.edu.uco.tiendaonline.crosscutting.util;

public final class UtilTexto {
	
	public static final String VACIO = "";
	public static final String PATTERN_SOLO_LETRAS = "^[A-Za-záéíóúÁÉÍÓÚ]+$";
	public static final String PATTERN_SOLO_LETRAS_DIGITOS_ESPACIOS = "^[0-9A-Za-záéíóúÁÉÍÓÚ ]+$";
	
	private UtilTexto() {
		super();
	}
	
	public static final String obtenerValorPorDefecto(final String valor, final String valorPorDefecto) {
		return UtilObjeto.obtenerValorDefecto(valor, valorPorDefecto);
	}
	
	public static final String obtenerValorPorDefecto(final String valor) {
		return obtenerValorPorDefecto(valor, VACIO);
	}
	
	public static final String aplicarTrim(final String valor) {
		return obtenerValorPorDefecto(valor).trim();
	}
	
	public static final boolean validarIgualdadSinTrim(final String valor, final String valor2) {
		return obtenerValorPorDefecto(valor).equals(obtenerValorPorDefecto(valor2));
	}
	
	public static final boolean validarIgualdadConTrim(final String valor, final String valor2) {
		return aplicarTrim(valor).equals(aplicarTrim(valor2));
	}
	
	public static final boolean validarIgualdadSinTrimIgnoreCase(final String valor, final String valor2) {
		return obtenerValorPorDefecto(valor).equalsIgnoreCase(obtenerValorPorDefecto(valor2));
	}
	
	public static final boolean validarIgualdadConTrimIgnoreCase(final String valor, final String valor2) {
		return aplicarTrim(valor).equalsIgnoreCase(aplicarTrim(valor2));
	}
	
	public static final boolean estaNulo(final String valor) {
		return UtilObjeto.esNulo(valor);
	}
	
	public static final boolean estaVacio(final String valor) {
		return !estaNulo(valor) && validarIgualdadConTrim(valor, VACIO);
	}
	
	public static final boolean longitudMinimaValida(final String valor, final int longitud) {
		return aplicarTrim(valor).length() >= longitud;
	}
	
	public static final boolean longitudMaximaValida(final String valor, final int longitud) {
		return aplicarTrim(valor).length() <= longitud;
	}
	
	public static final boolean longitudValida(final String valor, final int longitudMinima, final int longitudMaxima) {
		return longitudMinimaValida(valor, longitudMinima) && longitudMaximaValida(valor, longitudMaxima); 
	}
	
	public static final boolean contieneSoloLetras(final String valor) {
		return obtenerValorPorDefecto(valor).matches(PATTERN_SOLO_LETRAS);
	}
	
	public static final boolean contieneLetrasDigitosEspacios(final String valor) {
		return obtenerValorPorDefecto(valor).matches(PATTERN_SOLO_LETRAS_DIGITOS_ESPACIOS);
	}
}
