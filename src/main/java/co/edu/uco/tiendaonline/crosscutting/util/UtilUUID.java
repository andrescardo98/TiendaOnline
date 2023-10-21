package co.edu.uco.tiendaonline.crosscutting.util;

import java.util.UUID;

public final class UtilUUID {
	
	public static final UUID UUID_DEFECTO = new UUID(0L, 0L);
	
	private UtilUUID() {
		super();
	}
	
	public static final UUID nuevoId() {
		UUID uuid;
		
		do {
			uuid = UUID.randomUUID();
		}while (esUuidPorDefecto(uuid));
		
		return uuid;
	}
	
	public static final boolean esIgual(final UUID uuidUno, final UUID uuidDos) {
		return obtenerValorDefecto(uuidUno).equals(obtenerValorDefecto(uuidDos));
	}
	
	public static final boolean esUuidPorDefecto(final UUID uuid) {
		return esIgual(uuid, UUID_DEFECTO);
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
