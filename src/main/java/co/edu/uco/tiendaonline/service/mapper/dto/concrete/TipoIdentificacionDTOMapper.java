package co.edu.uco.tiendaonline.service.mapper.dto.concrete;

import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.tiendaonline.service.domain.TipoIdentificacionDomain;
import co.edu.uco.tiendaonline.service.dto.TipoIdentificacionDTO;
import co.edu.uco.tiendaonline.service.mapper.dto.DTOMapper;

public final class TipoIdentificacionDTOMapper implements DTOMapper<TipoIdentificacionDTO, TipoIdentificacionDomain>{

private static final DTOMapper<TipoIdentificacionDTO, TipoIdentificacionDomain> instancia = new TipoIdentificacionDTOMapper();
	
	private TipoIdentificacionDTOMapper() {
		super();
	}
	
	@Override
	public TipoIdentificacionDomain toDomain(TipoIdentificacionDTO dto) {
		if (UtilObjeto.esNulo(dto)) {
			var mensajeUsuario = "";
			var mensajeTecnico = "";
		}
		return null;
	}

	@Override
	public TipoIdentificacionDTO toDto(TipoIdentificacionDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

	public static final TipoIdentificacionDomain convertToDomain(final TipoIdentificacionDTO dto) {
		return instancia.toDomain(dto);
	}
	
	public static final TipoIdentificacionDTO convertToDTO(final TipoIdentificacionDomain domain) {
		return instancia.toDto(domain);
	}
}