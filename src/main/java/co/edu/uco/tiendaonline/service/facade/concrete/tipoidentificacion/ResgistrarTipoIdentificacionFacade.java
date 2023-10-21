package co.edu.uco.tiendaonline.service.facade.concrete.tipoidentificacion;

import co.edu.uco.tiendaonline.crosscutting.exception.TiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.data.dao.daofactory.DAOFactory;
import co.edu.uco.tiendaonline.data.dao.daofactory.TipoDAOFactory;
import co.edu.uco.tiendaonline.service.businesslogic.concrete.tipoidentificacion.RegistrarTipoIdentificacionUseCase;
import co.edu.uco.tiendaonline.service.businesslogic.validator.concrete.tipoidentificacion.RegistrarTipoIdentificacionValidator;
import co.edu.uco.tiendaonline.service.domain.TipoIdentificacionDomain;
import co.edu.uco.tiendaonline.service.dto.TipoIdentificacionDTO;
import co.edu.uco.tiendaonline.service.facade.Facade;
import co.edu.uco.tiendaonline.service.mapper.dto.concrete.TipoIdentificacionDTOMapper;

public final class ResgistrarTipoIdentificacionFacade implements Facade<TipoIdentificacionDTO>{

	@Override
	public void execute(final TipoIdentificacionDTO dto) {
		
		final TipoIdentificacionDomain domain = TipoIdentificacionDTOMapper.convertToDomain(dto);		
		RegistrarTipoIdentificacionValidator.ejecutarValidacion(domain);
		
		final DAOFactory daoFactory = DAOFactory.obtenerDAOFactory(TipoDAOFactory.SQLSERVER);
		
		try {
			daoFactory.iniciarTransaccion();
			
			var useCase = new RegistrarTipoIdentificacionUseCase(daoFactory);
			useCase.execute(domain);
			
			daoFactory.confirmarTransaccion();
		} catch (final TiendaOnlineException excepcion) {
			daoFactory.cancelarTransaccion();
			throw excepcion;
		} catch (final Exception excepcion) {
			daoFactory.cancelarTransaccion();
			var mensajeUsuario = "Se ha presentado un problema tratando de registar el nuevo tipo de identificación.";
			var mensajeTecnico = "Se ha presentado un problema inesperado en el método execute de la clase "
					+ "ResgistrarTipoIdentificacionFacade tratando de registrar el nuevo tipo de identificación. "
					+ "Por favor revise la traza para validar qué ocurrió...";
			throw ServiceTiendaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		} finally {
			daoFactory.cerrarConexion();
		}
		
	}

}
