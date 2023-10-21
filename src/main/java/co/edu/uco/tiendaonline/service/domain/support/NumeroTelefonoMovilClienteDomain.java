package co.edu.uco.tiendaonline.service.domain.support;

public final class NumeroTelefonoMovilClienteDomain {
	private int numeroTelefonoMovil;
	private boolean numeroTelefonoMovilConfirmado;
	
	private NumeroTelefonoMovilClienteDomain(final int numeroTelefonoMovil, final boolean numeroTelefonoMovilConfirmado) {
		super();
		setNumeroTelefonoMovil(numeroTelefonoMovil);
		setNumeroTelefonoMovilConfirmado(numeroTelefonoMovilConfirmado);
	}
	
	public static final NumeroTelefonoMovilClienteDomain crear(final int numeroTelefonoMovil, 
			final boolean numeroTelefonoMovilConfirmado) {
		return new NumeroTelefonoMovilClienteDomain(numeroTelefonoMovil, numeroTelefonoMovilConfirmado);
	}

	
	
	public final int getNumeroTelefonoMovil() {
		return numeroTelefonoMovil;
	}



	public final boolean isNumeroTelefonoMovilConfirmado() {
		return numeroTelefonoMovilConfirmado;
	}



	private final void setNumeroTelefonoMovil(final int numeroTelefonoMovil) {
		this.numeroTelefonoMovil = numeroTelefonoMovil;
	}

	private final void setNumeroTelefonoMovilConfirmado(final boolean numeroTelefonoMovilConfirmado) {
		this.numeroTelefonoMovilConfirmado = numeroTelefonoMovilConfirmado;
	}

	
}