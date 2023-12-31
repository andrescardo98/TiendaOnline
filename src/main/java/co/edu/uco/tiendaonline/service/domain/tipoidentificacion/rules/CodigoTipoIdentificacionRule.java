package co.edu.uco.tiendaonline.service.domain.tipoidentificacion.rules;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.tiendaonline.crosscutting.util.UtilTexto;
import co.edu.uco.tiendaonline.service.domain.Rule;

public final class CodigoTipoIdentificacionRule implements Rule<String>{
	
	private static final Rule<String> instancia = new CodigoTipoIdentificacionRule();
	
	private CodigoTipoIdentificacionRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final String dato) {
		instancia.validar(dato);
	}

	@Override
	public final void validar(final String dato) {
		validarLongitud(dato);
		validarObligatoriedad(dato);
		validarFormato(dato);
		
	}
	
	private final void validarLongitud(final String dato) {
		if (UtilTexto.longitudMaximaValida(dato, 50)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000056);
			throw ServiceTiendaOnlineException.crear(mensajeUsuario);
		}
	}

	private final void validarObligatoriedad(final String dato) {
		if (UtilTexto.estaVacio(dato)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000057);
			throw ServiceTiendaOnlineException.crear(mensajeUsuario);
		}
	}
	
	private final void validarFormato(final String dato) {
		if (!UtilTexto.contieneSoloLetras(dato)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000064);
			throw ServiceTiendaOnlineException.crear(mensajeUsuario);
		}
	}
	
}
