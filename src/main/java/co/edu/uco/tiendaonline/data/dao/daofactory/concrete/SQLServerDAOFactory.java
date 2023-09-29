package co.edu.uco.tiendaonline.data.dao.daofactory.concrete;

import java.sql.Connection;

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
		// TODO: Your homework will be to obtain conncection with SQL Server Database
		conexion=null;
		
	}

	@Override
	public final void cerrarConexion() {
		// TODO: Your homework will be to close connection
		
	}

	@Override
	public void iniciarTransaccion() {
		// TODO: Your homework will be to init transaction
		
	}

	@Override
	public void confirmarTransaccion() {
		// TODO: Your homework will be to commit transaction
		
	}

	@Override
	public void cancelarTransaccion() {
		// TODO: Your homework will be to rollback transaction
		
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
