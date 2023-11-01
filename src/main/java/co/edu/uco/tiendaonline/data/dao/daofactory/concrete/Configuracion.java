package co.edu.uco.tiendaonline.data.dao.daofactory.concrete;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.DataTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.CodigoMensaje;

public final class Configuracion {

	private static final Properties PROPIEDADES = new Properties();
	
	static {
		try(InputStream input = ClassLoader.getSystemResourceAsStream("config.properties")) {
			PROPIEDADES.load(input);
		} catch (final IOException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000071);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000072);
			throw DataTiendaOnlineException.crear(excepcion, mensajeUsuario,mensajeTecnico);
		}
	}
	
	public static String obtenerUrl() {
		return PROPIEDADES.getProperty("db.url");
	}
	
	public static String obtenerUsuario() {
		return PROPIEDADES.getProperty("db.usuario");
	}
	
	public static String obtenerContrasenia() {
		return PROPIEDADES.getProperty("db.contrasenia");
	}
}
