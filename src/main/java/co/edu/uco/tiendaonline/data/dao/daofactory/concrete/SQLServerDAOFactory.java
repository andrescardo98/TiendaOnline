package co.edu.uco.tiendaonline.data.dao.daofactory.concrete;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.DataTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.tiendaonline.crosscutting.util.UtilSQL;
import co.edu.uco.tiendaonline.data.dao.ClienteDAO;
import co.edu.uco.tiendaonline.data.dao.TipoIdentificacionDAO;
import co.edu.uco.tiendaonline.data.dao.concrete.sqlserver.ClienteSQLServerDAO;
import co.edu.uco.tiendaonline.data.dao.concrete.sqlserver.TipoidentificacionSQLServerDAO;
import co.edu.uco.tiendaonline.data.dao.daofactory.DAOFactory;

public final class SQLServerDAOFactory extends DAOFactory{

	private Connection conexion;
	
	public SQLServerDAOFactory() {
		abrirConexion();
	}
	
	@Override
	public final void abrirConexion() {
		
		try {
			Properties prop = new Properties();
			InputStream input = getClass().getResourceAsStream("/application.properties");
			prop.load(input);
			String url = prop.getProperty("db.url");
			String usuario = prop.getProperty("db.usuario");
			String contrasenia = prop.getProperty("db.contrasenia");
            
            if (url == null || url.isEmpty() || usuario == null || usuario.isEmpty() || contrasenia == null || contrasenia.isEmpty()) {
            	var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
            	var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000073);
    			throw DataTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico);
            }
			
			conexion = DriverManager.getConnection(url, usuario, contrasenia);
		} catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000027);
			throw DataTiendaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		} catch (final Exception excepcion){
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000029);
			throw DataTiendaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		}
	}

	
	@Override
	public final void cerrarConexion() {
		UtilSQL.cerrarConexion(conexion);
	}

	@Override
	public void iniciarTransaccion() {
		UtilSQL.iniciarTransaccion(conexion);
	}

	@Override
	public void confirmarTransaccion() {
		UtilSQL.confirmarTransaccion(conexion);		
	}

	@Override
	public void cancelarTransaccion() {
		UtilSQL.cancelarTransaccion(conexion);		
	}

	@Override
	public ClienteDAO obtenerClienteDAO() {
		return new ClienteSQLServerDAO(conexion);
	}

	@Override
	public TipoIdentificacionDAO obtenerTipoIdentificacionDAO() {
		return new TipoidentificacionSQLServerDAO(conexion);
	}
	

}
