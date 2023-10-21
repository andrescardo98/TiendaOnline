package co.edu.uco.tiendaonline.service.domain.support;

public final class CorreoElectronicoClienteDomain {
	private String correoElectronico;
	private boolean correoElectronicoConfirmado;
	
	
	private CorreoElectronicoClienteDomain(final String correoElectronico, final boolean correoElectronicoConfirmado) {
		super();
		setCorreoElectronico(correoElectronico);
		setCorreoElectronicoConfirmado(correoElectronicoConfirmado);
	}
	
	public static final CorreoElectronicoClienteDomain crear(final String correoElectronico, final boolean correoElectronicoConfirmado) {
		
		return new CorreoElectronicoClienteDomain(correoElectronico, correoElectronicoConfirmado);
	}


	public final String getCorreoElectronico() {
		return correoElectronico;
	}


	public final boolean isCorreoElectronicoConfirmado() {
		return correoElectronicoConfirmado;
	}


	private final void setCorreoElectronico(final String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}


	private final void setCorreoElectronicoConfirmado(final boolean correoElectronicoConfirmado) {
		this.correoElectronicoConfirmado = correoElectronicoConfirmado;
	}
	
}