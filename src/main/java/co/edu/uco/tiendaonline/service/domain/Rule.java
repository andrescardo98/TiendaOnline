package co.edu.uco.tiendaonline.service.domain;

public interface Rule<T> {

	void validar(T dato);
}
