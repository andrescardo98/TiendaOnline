package co.edu.uco.tiendaonline.data.dao.daofactory.concrete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import co.edu.uco.tiendaonline.data.dao.ClienteDAO;
import co.edu.uco.tiendaonline.data.dao.TipoIdentificacionDAO;
import co.edu.uco.tiendaonline.data.dao.concrete.sqlserver.ClienteSQLServerDAO;
import co.edu.uco.tiendaonline.data.dao.concrete.sqlserver.TipoidentificacionSQLServerDAO;
import co.edu.uco.tiendaonline.data.dao.daofactory.DAOFactory;

public final class SQLServerDAOFactory extends DAOFactory{

	private Connection conexion;
	private boolean enTransaccion = false;
	
	public SQLServerDAOFactory() {
		abrirConexion();
	}
	
	@Override
	public final void abrirConexion() {

		final String url = "jdbc:sqlserver://localhost:1433;databaseName=databaseDOO";
		final String usuario = "usersql";
		final String contrasenia = "+javasql2023";
		
		try {
			conexion = DriverManager.getConnection(url, usuario, contrasenia);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	@Override
	public final void cerrarConexion() {
		try {
			if (conexion != null && !conexion.isClosed()) {
				conexion.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void iniciarTransaccion() {
		try {
			if (!enTransaccion) {
				conexion.setAutoCommit(false);
				enTransaccion = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void confirmarTransaccion() {
		try {
			if (enTransaccion) {
				conexion.commit();
				conexion.setAutoCommit(true);
				enTransaccion = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void cancelarTransaccion() {
		try {
			if (enTransaccion) {
				conexion.rollback();
				conexion.setAutoCommit(true);
				enTransaccion = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
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
