package co.edu.uco.tiendaonline.service.domain.tipoidentificacion.rules;

import java.util.UUID;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.tiendaonline.crosscutting.util.UtilTexto;
import co.edu.uco.tiendaonline.service.domain.Rule;

public final class IdTipoIdentificacionRule implements Rule<UUID>{
	
	private static final Rule<UUID> instancia = new IdTipoIdentificacionRule();
	
	private IdTipoIdentificacionRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final UUID dato) {
		instancia.validar(dato);
	}

	@Override
	public final void validar(final UUID dato) {
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
			var mensajeUsuario = "El código del tipo de identificación solo puede contener letras.";
			throw ServiceTiendaOnlineException.crear(mensajeUsuario);
		}
	}
	
}
