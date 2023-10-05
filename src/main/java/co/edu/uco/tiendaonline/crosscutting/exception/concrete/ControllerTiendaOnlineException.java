package co.edu.uco.tiendaonline.crosscutting.exception.concrete;

import co.edu.uco.tiendaonline.crosscutting.exception.TiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.exception.enumerator.LugarException;

public final class ControllerTiendaOnlineException extends TiendaOnlineException{

	private static final long serialVersionUID = 6744095626690529725L;
	
	protected ControllerTiendaOnlineException(final Throwable excepcionRaiz, final String mensajeUsuario,
			final String mensajeTecnico) {
		super(LugarException.CONTROLLER, excepcionRaiz, mensajeUsuario, mensajeTecnico);

	}
	
	public static final TiendaOnlineException crear(final String mensajeUsuario) {
		return new ControllerTiendaOnlineException(null, mensajeUsuario, mensajeUsuario);
	}
	
	public static final TiendaOnlineException crear(final String mensajeUsuario, final String mensajeTecnico) {
		return new ControllerTiendaOnlineException(null, mensajeUsuario, mensajeTecnico);
	}
	
	public static final TiendaOnlineException crear(final Throwable excepcionRaiz, final String mensajeUsuario, final String mensajeTecnico) {
		return new ControllerTiendaOnlineException(excepcionRaiz, mensajeUsuario, mensajeTecnico);
	}
}
