package co.edu.uco.tiendaonline.data.entity.support;

public final class NumeroTelefonoMovilClienteEntity {
	private int numeroTelefonoMovil;
	private boolean numeroTelefonoMovilConfirmado;
	
	private NumeroTelefonoMovilClienteEntity(final int numeroTelefonoMovil, final boolean numeroTelefonoMovilConfirmado) {
		super();
		setNumeroTelefonoMovil(numeroTelefonoMovil);
		setNumeroTelefonoMovilConfirmado(numeroTelefonoMovilConfirmado);
	}
	
	public static final NumeroTelefonoMovilClienteEntity crear(final int numeroTelefonoMovil, 
			final boolean numeroTelefonoMovilConfirmado) {
		return new NumeroTelefonoMovilClienteEntity(numeroTelefonoMovil, numeroTelefonoMovilConfirmado);
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