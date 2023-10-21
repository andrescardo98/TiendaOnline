package co.edu.uco.tiendaonline.service.domain;

import java.sql.Date;
import java.util.UUID;

import co.edu.uco.tiendaonline.service.domain.support.CorreoElectronicoClienteDomain;
import co.edu.uco.tiendaonline.service.domain.support.NombreCompletoClienteDomain;
import co.edu.uco.tiendaonline.service.domain.support.NumeroTelefonoMovilClienteDomain;


public class ClienteDomain {
	private UUID id;
	private TipoIdentificacionDomain tipoIdentificacion;
	private String identificacion;
	private NombreCompletoClienteDomain nombreCompleto;
	private CorreoElectronicoClienteDomain correoElectronico;
	private NumeroTelefonoMovilClienteDomain numeroTelefonoMovil;
	private Date fechaNacimiento;
	
	
	private ClienteDomain(final UUID id, final TipoIdentificacionDomain tipoIdentificacion, final String identificacion, 
			final NombreCompletoClienteDomain nombreCompleto, final CorreoElectronicoClienteDomain correoElectronico,
			final NumeroTelefonoMovilClienteDomain numeroTelefonoMovil, final Date fechaNacimiento) {
		super();
		setId(id);
		setTipoIdentificacion(tipoIdentificacion);
		setNombreCompleto(nombreCompleto);
		setCorreoElectronico(correoElectronico);
		setNumeroTelefonoMovil(numeroTelefonoMovil);
		setFechaNacimiento(fechaNacimiento);
	}


	public static final ClienteDomain crear (final UUID id, final TipoIdentificacionDomain tipoIdentificacion, final String identificacion,
			final NombreCompletoClienteDomain nombreCompleto, final CorreoElectronicoClienteDomain correoElectronico,
			final NumeroTelefonoMovilClienteDomain numeroTelefonoMovil, final Date fechaNacimiento) {
		
		return new ClienteDomain(id, tipoIdentificacion, identificacion, nombreCompleto, correoElectronico, numeroTelefonoMovil, 
				fechaNacimiento);
	}


	

	public final UUID getId() {
		return id;
	}


	public final TipoIdentificacionDomain getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public final NombreCompletoClienteDomain getNombreCompleto() {
		return nombreCompleto;
	}


	public final CorreoElectronicoClienteDomain getCorreoElectronico() {
		return correoElectronico;
	}


	public final NumeroTelefonoMovilClienteDomain getNumeroTelefonoMovil() {
		return numeroTelefonoMovil;
	}


	public final Date getFechaNacimiento() {
		return fechaNacimiento;
	}


	private final void setId(final UUID id) {
		this.id = id;
	}


	private final void setTipoIdentificacion(final TipoIdentificacionDomain tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}
	
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}


	private final void setNombreCompleto(final NombreCompletoClienteDomain nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}


	private final void setCorreoElectronico(final CorreoElectronicoClienteDomain correoElectronico) {
		this.correoElectronico = correoElectronico;
	}


	private final void setNumeroTelefonoMovil(final NumeroTelefonoMovilClienteDomain numeroTelefonoMovil) {
		this.numeroTelefonoMovil = numeroTelefonoMovil;
	}


	private final void setFechaNacimiento(final Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	
	
	
}
