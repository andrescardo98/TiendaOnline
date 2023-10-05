package co.edu.uco.tiendaonline.crosscutting.util;

public final class UtilTexto {
	
	public static final String VACIO = "";
	
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

}
