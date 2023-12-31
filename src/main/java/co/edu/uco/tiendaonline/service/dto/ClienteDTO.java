package co.edu.uco.tiendaonline.service.dto;

import java.util.Date;
import java.util.UUID;

import co.edu.uco.tiendaonline.crosscutting.util.UtilFecha;
import co.edu.uco.tiendaonline.crosscutting.util.UtilTexto;
import co.edu.uco.tiendaonline.crosscutting.util.UtilUUID;
import co.edu.uco.tiendaonline.service.dto.support.CorreoElectronicoClienteDTO;
import co.edu.uco.tiendaonline.service.dto.support.NombreCompletoClienteDTO;
import co.edu.uco.tiendaonline.service.dto.support.NumeroTelefonoMovilClienteDTO;


public final class ClienteDTO {
	
	private UUID id;
	private TipoIdentificacionDTO tipoIdentificacion;
	private String identificacion;
	private NombreCompletoClienteDTO nombreCompleto;
	private CorreoElectronicoClienteDTO correoElectronico;
	private NumeroTelefonoMovilClienteDTO numeroTelefonoMovil;
	private Date fechaNacimiento;
	
	
	public ClienteDTO() {
		setId(UtilUUID.generarUUIDVacio());
		setTipoIdentificacion(new TipoIdentificacionDTO());
		setIdentificacion(UtilTexto.VACIO);
		setNombreCompleto(new NombreCompletoClienteDTO());
		setCorreoElectronico(new CorreoElectronicoClienteDTO());
		setNumeroTelefonoMovil(new NumeroTelefonoMovilClienteDTO());
		setFechaNacimiento(UtilFecha.FECHA_NACIMIENTO_DEFECTO);
	}
	

	public ClienteDTO(final UUID id, final TipoIdentificacionDTO tipoIdentificacion, final String identificacion,
			final NombreCompletoClienteDTO nombreCompleto, final CorreoElectronicoClienteDTO correoElectronico,
			final NumeroTelefonoMovilClienteDTO numeroTelefonoMovil, final Date fechaNacimiento) {
		setId(id);
		setTipoIdentificacion(tipoIdentificacion);
		setIdentificacion(identificacion);
		setNombreCompleto(nombreCompleto);
		setCorreoElectronico(correoElectronico);
		setNumeroTelefonoMovil(numeroTelefonoMovil);
		setFechaNacimiento(fechaNacimiento);
	}
	
	
	public final UUID getId() {
		return id;
	}
	public final TipoIdentificacionDTO getTipoIdentificacion() {
		return tipoIdentificacion;
	}
	public String getIdentificacion() {
		return identificacion;
	}
	public final NombreCompletoClienteDTO getNombreCompleto() {
		return nombreCompleto;
	}
	public final CorreoElectronicoClienteDTO getCorreoElectronico() {
		return correoElectronico;
	}
	public final NumeroTelefonoMovilClienteDTO getNumeroTelefonoMovil() {
		return numeroTelefonoMovil;
	}
	public final Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	
	public final ClienteDTO setId(final UUID id) {
		this.id = id;
		return this;
	}
	public final ClienteDTO setTipoIdentificacion(final TipoIdentificacionDTO tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
		return this;
	}
	public ClienteDTO setIdentificacion(final String identificacion) {
		this.identificacion = identificacion;
		return this;
	}
	public final ClienteDTO setNombreCompleto(final NombreCompletoClienteDTO nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
		return this;
	}
	public final ClienteDTO setCorreoElectronico(final CorreoElectronicoClienteDTO correoElectronico) {
		this.correoElectronico = correoElectronico;
		return this;
	}
	public final ClienteDTO setNumeroTelefonoMovil(final NumeroTelefonoMovilClienteDTO numeroTelefonoMovil) {
		this.numeroTelefonoMovil = numeroTelefonoMovil;
		return this;
	}
	public final ClienteDTO setFechaNacimiento(final Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
		return this;
	}
}
