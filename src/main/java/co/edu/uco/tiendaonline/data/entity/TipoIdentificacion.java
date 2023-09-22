package co.edu.uco.tiendaonline.data.entity;

import java.util.UUID;

public final class TipoIdentificacion {
	private UUID id;
	private String codigo;
	private String nombre;
	private boolean estado;
	
	private TipoIdentificacion(final UUID id, final String codigo, final String nombre, final boolean estado) {
		super();
		setId(id);
		setCodigo(codigo);
		setNombre(nombre);
		setEstado(estado);
	}
	
	public static final TipoIdentificacion crear(final UUID id, final String codigo, final String nombre, 
			final boolean estado) {
		return new TipoIdentificacion(id,codigo,nombre,estado);
	}
	
	public final UUID getId() {
		return id;
	}


	public final String getCodigo() {
		return codigo;
	}


	public final String getNombre() {
		return nombre;
	}


	public final boolean isEstado() {
		return estado;
	}


	private final void setId(final UUID id) {
		this.id = id;
	}

	private final void setCodigo(final String codigo) {
		this.codigo = codigo;
	}

	private final void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	private final void setEstado(final boolean estado) {
		this.estado = estado;
	}
	
	
	
}
