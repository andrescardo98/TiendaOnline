package co.edu.uco.tiendaonline.service.businesslogic.validator.concrete.tipoidentificacion;

import co.edu.uco.tiendaonline.service.businesslogic.validator.Validator;
import co.edu.uco.tiendaonline.service.domain.TipoIdentificacionDomain;
import co.edu.uco.tiendaonline.service.domain.tipoidentificacion.rules.CodigoTipoIdentificacionRule;
import co.edu.uco.tiendaonline.service.domain.tipoidentificacion.rules.IdTipoIdentificacionRule;
import co.edu.uco.tiendaonline.service.domain.tipoidentificacion.rules.NombreTipoIdentificacionRule;
import co.edu.uco.tiendaonline.service.mapper.entity.concrete.TipoIdentificacionEntityMapper;

public final class RegistrarTipoIdentificacionValidator implements Validator<TipoIdentificacionDomain>{

	private static final Validator<TipoIdentificacionDomain> instancia = new RegistrarTipoIdentificacionValidator();
	
	private RegistrarTipoIdentificacionValidator() {
		super();
	}
	
	public static final void ejecutarValidacion(final TipoIdentificacionDomain dato) {
		instancia.execute(dato);
	}
	
	@Override
	public final void execute(final TipoIdentificacionDomain data) {
		// 1. Validar integirdad de datos
		
		
		CodigoTipoIdentificacionRule.ejecutarValidacion(data.getCodigo());
		NombreTipoIdentificacionRule.ejecutarValidacion(data.getNombre());
		
	}
	
	private final void registrarNuevoTipoIdentificacion(final TipoIdentificacionDomain domain) {
		var entity = TipoIdentificacionEntityMapper.convertToEntity(domain);
		getTipoIdentificacionDAO().crear(entity);
	}
	
	
}
