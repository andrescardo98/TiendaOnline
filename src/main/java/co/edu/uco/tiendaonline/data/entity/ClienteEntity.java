package co.edu.uco.tiendaonline.data.entity;

import java.sql.Date;
import java.util.UUID;

import co.edu.uco.tiendaonline.data.entity.support.CorreoElectronicoClienteEntity;
import co.edu.uco.tiendaonline.data.entity.support.NombreCompletoClienteEntity;
import co.edu.uco.tiendaonline.data.entity.support.NumeroTelefonoMovilClienteEntity;

public class ClienteEntity {
	private UUID id;
	private TipoIdentificacionEntity tipoIdentificacion;
	private NombreCompletoClienteEntity nombreCompleto;
	private CorreoElectronicoClienteEntity correoElectronico;
	private NumeroTelefonoMovilClienteEntity numeroTelefonoMovil;
	private Date fechaNacimiento;
	
	
	private ClienteEntity(UUID id, TipoIdentificacionEntity tipoIdentificacion,	Date fechaNacimiento) {
		super();
		setId(id);
		setTipoIdentificacion(tipoIdentificacion);
		setFechaNacimiento(fechaNacimiento);
	}
	
	public static final ClienteEntity crear (UUID id, TipoIdentificacionEntity tipoIdentificacion, int numeroTelefonoMovil, boolean numeroTelefonoMovilConfirmado,
			Date fechaNacimiento) {
		return new ClienteEntity(id, tipoIdentificacion, fechaNacimiento);
	}


	public final UUID getId() {
		return id;
	}


	public final TipoIdentificacionEntity getTipoIdentificacion() {
		return tipoIdentificacion;
	}



	public final Date getFechaNacimiento() {
		return fechaNacimiento;
	}




	private final void setId(final UUID id) {
		this.id = id;
	}


	private final void setTipoIdentificacion(final TipoIdentificacionEntity tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}


	private final void setFechaNacimiento(final Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	
	
}
