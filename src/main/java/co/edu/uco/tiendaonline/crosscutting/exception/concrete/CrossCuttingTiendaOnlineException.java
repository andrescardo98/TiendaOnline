package co.edu.uco.tiendaonline.crosscutting.exception.concrete;

import co.edu.uco.tiendaonline.crosscutting.exception.TiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.exception.enumerator.LugarException;

public class CrossCuttingTiendaOnlineException extends TiendaOnlineException{
	
	private static final long serialVersionUID = -2727036418055792587L;
	
	protected CrossCuttingTiendaOnlineException(final Throwable excepcionRaiz, final String mensajeUsuario,
			String mensajeTecnico) {
		super(LugarException.CROSSCUTTING, excepcionRaiz, mensajeUsuario, mensajeTecnico);
	}
	
	public static final TiendaOnlineException crear(final String mensajeUsuario) {
		return new CrossCuttingTiendaOnlineException(null, mensajeUsuario, mensajeUsuario);
	}
	
	public static final TiendaOnlineException crear(final String mensajeUsuario, final String mensajeTecnico) {
		return new CrossCuttingTiendaOnlineException(null, mensajeUsuario, mensajeTecnico);
	}
	
	public static final TiendaOnlineException crear(final Throwable excepcionRaiz, final String mensajeUsuario, final String mensajeTecnico) {
		return new CrossCuttingTiendaOnlineException(excepcionRaiz, mensajeUsuario, mensajeTecnico);
	}
}
