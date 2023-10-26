package co.edu.uco.tiendaonline.service.domain.tipoidentificacion.rules;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.tiendaonline.service.domain.Rule;
import co.edu.uco.tiendaonline.service.domain.TipoIdentificacionDomain;

public final class TipoIdentificacionRule implements Rule<TipoIdentificacionDomain>{
	
	private static final Rule<TipoIdentificacionDomain> instancia = new TipoIdentificacionRule();
	
	private TipoIdentificacionRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final TipoIdentificacionDomain dato) {
		instancia.validar(dato);
	}

	@Override
	public final void validar(final TipoIdentificacionDomain dato) {
		if (UtilObjeto.esNulo(dato)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000066);
			throw ServiceTiendaOnlineException.crear(mensajeUsuario);
		}
		
	}
	
}
