package co.edu.uco.tiendaonline.service.domain.tipoidentificacion.rules;

import java.util.UUID;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.tiendaonline.crosscutting.util.UtilUUID;
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
		validarObligatoriedad(dato);
		validarIdPorDefecto(dato);
	}

	private final void validarObligatoriedad(final UUID dato) {
		if (UtilObjeto.esNulo(dato)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000060);
			throw ServiceTiendaOnlineException.crear(mensajeUsuario);
		}
	}
	
	private final void validarIdPorDefecto(final UUID dato) {
		if (UtilUUID.esUuidPorDefecto(dato)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000061);
			throw ServiceTiendaOnlineException.crear(mensajeUsuario);
		}
	}
	
}
