package co.edu.uco.tiendaonline.crosscutting.util;

import java.util.UUID;

public final class UtilUUID {
	
	public static final UUID UUID_DEFECTO = new UUID(0L, 0L);
	
	private UtilUUID() {
		super();
	}
	
	
	public static final UUID obtenerValorDefecto(final UUID valor, final UUID valorDefecto) {
		return UtilObjeto.obtenerValorDefecto(valor, valorDefecto);
	}
	
	public static final UUID obtenerValorDefecto(final UUID valor) {
		return obtenerValorDefecto(valor, UUID_DEFECTO);
	}
	
	public static final UUID generarUUIDVacio() {
		return UUID_DEFECTO;
	}
}
