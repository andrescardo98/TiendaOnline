package co.edu.uco.tiendaonline.service.businesslogic.concrete.tipoidentificacion;

import java.util.Optional;
import java.util.UUID;


import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.tiendaonline.data.dao.TipoIdentificacionDAO;
import co.edu.uco.tiendaonline.data.dao.daofactory.DAOFactory;
import co.edu.uco.tiendaonline.data.entity.TipoIdentificacionEntity;
import co.edu.uco.tiendaonline.service.businesslogic.UseCase;
import co.edu.uco.tiendaonline.service.domain.TipoIdentificacionDomain;
import co.edu.uco.tiendaonline.service.mapper.entity.concrete.TipoIdentificacionEntityMapper;

public final class RegistrarTipoIdentificacionUseCase implements UseCase<TipoIdentificacionDomain>{

	private DAOFactory factoria;
	
	
	
	public RegistrarTipoIdentificacionUseCase(DAOFactory factoria) {
		setFactoria(factoria);
	}

	@Override
	public final void execute(TipoIdentificacionDomain domain) {
		// 1. Validar integridad de datos (tipo de dato, longitud, obligatoriedad, rango, etc.).
		// TODO: ¿Cómo lo hago?
		
		// 2. No debe existir otro tipo de identificación con el mismo código.
		validarNoExistenciaTipoIdentificacionConMismoCodigo(domain.getCodigo());
		
		// 3. No debe existir otro tipo de identificación con el mismo nombre.
		validarNoExistenciaTipoIdentificacionConMismoNombre(domain.getNombre());
		
		// 4. No debe existir otro tipo de identificación con el mismo identificador.
				domain = obtenerTipoIdentificacionDomain(domain);
		
		// 5. Insertar el nuevo tipo de identificación.
		registrarNuevoTipoIdentificacion(domain);
		
	}
	
	private final void registrarNuevoTipoIdentificacion(final TipoIdentificacionDomain domain) {
		var entity = TipoIdentificacionEntityMapper.convertToEntity(domain);
		getTipoIdentificacionDAO().crear(entity);
	}
	
	private final void validarNoExistenciaTipoIdentificacionConMismoNombre(final String nombre) {
		
		// TODO: ¿Cómo lograr que esto no quede tan feo?????
		var domain = TipoIdentificacionDomain.crear(null, null, nombre, false);
		var entity = TipoIdentificacionEntityMapper.convertToEntity(domain);
		var resultados = getTipoIdentificacionDAO().consultar(entity);
		
		if (!resultados.isEmpty()) {
			var mensajeUsuario = "Ya existe un tipo de identificación con el nombre " + nombre;
			throw ServiceTiendaOnlineException.crear(mensajeUsuario);
		}
	}
	
	private final void validarNoExistenciaTipoIdentificacionConMismoCodigo(final String codigo) {
		
		var domain = TipoIdentificacionDomain.crear(null, codigo, null, false);
		var entity = TipoIdentificacionEntityMapper.convertToEntity(domain);
		var resultados = getTipoIdentificacionDAO().consultar(entity);
		
		if (!resultados.isEmpty()) {
			var mensajeUsuario = "Ya existe un tipo de identificación con el codigo " + codigo;
			throw ServiceTiendaOnlineException.crear(mensajeUsuario);
		}
	}
	
	private final TipoIdentificacionDomain obtenerTipoIdentificacionDomain(final TipoIdentificacionDomain domain) {
		Optional<TipoIdentificacionEntity> optional;
		UUID uuid;
		
		do {
			uuid = UUID.randomUUID();
			optional = getTipoIdentificacionDAO().consultarPorId(uuid);
		} while (optional.isPresent());
		
		return TipoIdentificacionDomain.crear(uuid, domain.getCodigo(), domain.getNombre(), domain.isEstado());
	}
	

	private final DAOFactory getFactoria() {
		return factoria;
	}

	private final TipoIdentificacionDAO getTipoIdentificacionDAO() {
		return getFactoria().obtenerTipoIdentificacionDAO();
	}

	private final void setFactoria(final DAOFactory factoria) {
		if (UtilObjeto.esNulo(factoria)) {
			var mensajeUsuario = "Se ha presentado un problema tratando de llevar a cabo el registro de la información del "
					+ "nuevo tipo de identificación";
			var mensajeTecnico = "Se ha presentado un problema en el método setFactoría de la clase "
					+ "RegistrarTipoIdentificacionUseCase, debido a que la factoría con la cual se desea crear está nula";
			throw ServiceTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		}
		this.factoria = factoria;
	}
	
	
	
}
