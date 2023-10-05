package co.edu.uco.tiendaonline.crosscutting.util;

import java.sql.Connection;
import java.sql.SQLException;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.CrossCuttingTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.CodigoMensaje;

public final class UtilSQL {
	
	private UtilSQL() {
		super();
	}

	public static final boolean conexionAbierta(final Connection conexion) {
		try {
			return UtilObjeto.esNulo(conexion) && !conexion.isClosed();
		} catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000005);
			throw CrossCuttingTiendaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		}catch (final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000006);
			throw CrossCuttingTiendaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		}
	}
	
	public static final void cerrarConexion(final Connection conexion) {
		if (UtilObjeto.esNulo(conexion)) {
			//lanzar excepcion
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = "No es posible cerrar una conexión que está nula";
			throw CrossCuttingTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		}
		try {
			if(!conexionAbierta(conexion)) {
				//lanzar excepcion
				var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
				var mensajeTecnico = "No es posible cerrar una conexión que ya fue cerrada";
				throw CrossCuttingTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico);
			}
			conexion.close();
		}catch (final CrossCuttingTiendaOnlineException excepcion) {
			throw excepcion;
		}catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = "Se ha presentado un problema intentando cerrar la conexión SQL.";
			throw CrossCuttingTiendaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		} catch(final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = "Se ha presentado un problema inesperado intentando cerrar la conexión SQL.";
			throw CrossCuttingTiendaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		}
	}
	
	public static final void iniciarTransaccion(final Connection conexion) {
		if (UtilObjeto.esNulo(conexion)) {
			//lanzar excepcion
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = "No es posible iniciar una transacción con una conexión nula...PPPPP";
			throw CrossCuttingTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		}
		try {
			if(!conexionAbierta(conexion)) {
				//lanzar excepcion
				var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
				var mensajeTecnico = "No es posible cerrar una conexión cerrada";
				throw CrossCuttingTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico);
			}
			
			if(conexion.getAutoCommit()) {
				//lanzar excepcion
				var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
				var mensajeTecnico = "No es posible cerrar una conexión que ya fue cerrada";
				throw CrossCuttingTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico);
			}
			conexion.setAutoCommit(false);
			
		}catch (final CrossCuttingTiendaOnlineException excepcion) {
			throw excepcion;
		}catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = "Se ha presentado un problema intentando cerrar la conexión SQL.";
			throw CrossCuttingTiendaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		} catch(final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = "Se ha presentado un problema inesperado intentando cerrar la conexión SQL.";
			throw CrossCuttingTiendaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		}
	}
}
