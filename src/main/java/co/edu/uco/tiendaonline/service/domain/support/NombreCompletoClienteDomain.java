package co.edu.uco.tiendaonline.service.domain.support;

public final class NombreCompletoClienteDomain {
	private String primerNombre;
	private String segundoNombre;
	private String primerApellido;
	private String segundoApellido;


	private NombreCompletoClienteDomain(final String primerNombre, final String segundoNombre, final String primerApellido,
			final String segundoApellido) {
		super();
		setPrimerNombre(primerNombre);
		setSegundoNombre(segundoNombre);
		setPrimerApellido(primerApellido);
		setSegundoApellido(segundoApellido);
	}
	
	public static final NombreCompletoClienteDomain crear(final String primerNombre, final String segundoNombre, 
			final String primerApellido, final String segundoApellido) {
		return new NombreCompletoClienteDomain(primerNombre, segundoNombre, primerApellido, segundoApellido);
	}


	public final String getPrimerNombre() {
		return primerNombre;
	}


	public final String getSegundoNombre() {
		return segundoNombre;
	}


	public final String getPrimerApellido() {
		return primerApellido;
	}


	public final String getSegundoApellido() {
		return segundoApellido;
	}


	private final void setPrimerNombre(final String primerNombre) {
		this.primerNombre = primerNombre;
	}


	private final void setSegundoNombre(final String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}


	private final void setPrimerApellido(final String primerApellido) {
		this.primerApellido = primerApellido;
	}


	private final void setSegundoApellido(final String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	
	
	
}