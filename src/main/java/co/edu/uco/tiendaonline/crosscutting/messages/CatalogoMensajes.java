package co.edu.uco.tiendaonline.crosscutting.messages;

import java.util.HashMap;
import java.util.Map;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.CrossCuttingTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.CategoriaMensaje;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.TipoMensaje;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;

public class CatalogoMensajes {
	
	private static final Map<CodigoMensaje, Mensaje> MENSAJES = new HashMap<>();
	
	static {
		cargarMensajes();
	}
	
	private CatalogoMensajes() {
		super();
	}
	
	private static final void cargarMensajes() {
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000001, TipoMensaje.TECNICO, 
				CategoriaMensaje.FATAL, "No se recibió el código de mensaje que se quería crear. No es posible continuar con el proceso..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000002, TipoMensaje.TECNICO, 
				CategoriaMensaje.FATAL, "No existe un mensaje con el código indicado. No es posible continuar con el proceso..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000003, TipoMensaje.TECNICO, 
				CategoriaMensaje.FATAL, "No es posible otener un mensaje con el código vacío o nulo. No es posible continuar con el proceso..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000004, TipoMensaje.USUARIO, 
				CategoriaMensaje.FATAL, "Se ha presentado un problema inesperado tratando de llevar a cabo la operación..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000005, TipoMensaje.TECNICO, 
				CategoriaMensaje.ERROR, "Se ha presentado un problema tratando de validar si la conexión SQL estaba abierta. "
						+ "Se presentó una excepción de tipo SQLException. Por favor verifique la traza completa del error "
						+ "presentado para así poder diagnosticar con certeza qué sucedió..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000006, TipoMensaje.TECNICO, 
				CategoriaMensaje.ERROR, "Se ha presentado un problema inesperado tratando de validar si la conexión SQL estaba abierta. "
						+ "Se presentó una excepción genérica de tipo Exception. Por favor verifique la traza completa del error "
						+ "presentado para así poder diagnosticar con certeza qué sucedió..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000007, TipoMensaje.TECNICO, 
				CategoriaMensaje.FATAL, "No es posible cerrar una conexión que está nula"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000008, TipoMensaje.TECNICO, 
				CategoriaMensaje.FATAL, "No es posible cerrar una conexión que ya está cerrada"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000009, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, 
				"No es posible validar si una conexión está abierta cuando es nula..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000010, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, 
				"Se ha presentado un problema tratando de cerrar una conexión SQL. Se presentó una excepeción de SQLException. "
				+ "Por favor verifique la traza completa del error presentado, para así poder diagnosticar con mayor certeza, "
				+ "qué sucedió..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000011, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema inesperado tratando de cerrar la conexión. Se presentó una excepeción genérica "
				+ "de tipo Exception. Por favor verifique la traza completa del error presentado, para así poder "
				+ "diagnosticar con mayor certeza, qué sucedió..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000012, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, 
				"No es posible iniciar una transacción con una conexión que está nula..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000013, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, 
				"No es posible iniciar una transaccion con una conexión cerrada..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000014, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, 
				"No es posible iniciar una transaccion que ya ha sido iniciada..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000015, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, 
				"Se ha presentado un problema tratando de iniciar la transacción de una conexión SQL. Se presentó una excepeción de SQLException. "
				+ "Por favor verifique la traza completa del error presentado, para así poder diagnosticar con mayor "
				+ "certeza, qué sucedió..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000016, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema inesperado tratando de iniciar una transacción de una conexión. Se presentó una excepeción genérica "
				+ "de tipo Exception. Por favor verifique la traza completa del error presentado, para así poder diagnosticar "
				+ "con mayor certeza, qué sucedió..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000017, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, 
				"No es posible confirmar una transacción con una conexión que está nula..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000018, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, 
				"No es posible confirmar una transaccion con una conexión cerrada..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000019, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, 
				"No es posible confirmar una transaccion que no fue iniciada..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000020, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, 
				"Se ha presentado un problema tratando de confirmar la transacción de una conexión SQL. Se presentó una excepeción de SQLException. "
				+ "Por favor verifique la traza completa del error presentado, para así poder diagnosticar con mayor "
				+ "certeza, qué sucedió..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000021, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema inesperado tratando de confirmar la transacción de una conexión. Se presentó una excepeción genérica "
				+ "de tipo Exception. Por favor verifique la traza completa del error presentado, para así poder diagnosticar "
				+ "con mayor certeza, qué sucedió..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000022, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, 
				"No es posible cancelar una transacción con una conexión que está nula..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000023, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, 
				"No es posible cancelar una transaccion con una conexión cerrada..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000024, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, 
				"No es posible cancelar una transaccion que no fue iniciada..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000025, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, 
				"Se ha presentado un problema tratando de cancelar la transacción de una conexión SQL. Se presentó una excepeción de SQLException. "
				+ "Por favor verifique la traza completa del error presentado, para así poder diagnosticar con mayor "
				+ "certeza, qué sucedió..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000026, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema inesperado tratando de cancelar la transacción de una conexión. Se presentó una excepeción genérica "
				+ "de tipo Exception. Por favor verifique la traza completa del error presentado, para así poder diagnosticar "
				+ "con mayor certeza, qué sucedió..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000027, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, 
				"No es posible abrir la conexión. Se ha presentado un prooblema SQL..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000028, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, 
				"No es posible encontrar la clase para abrir la conexión..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000029, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema inesperado tratando de abrir la conexión. Se presentó una excepeción genérica "
				+ "de tipo Exception. Por favor verifique la traza completa del error presentado, para así poder diagnosticar "
				+ "con mayor certeza, qué sucedió..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000030, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de registar la información del nuevo tipo de identificación."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000031, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema de tipo SQLException en el método crear de la clase TipoIdentificacion SQLServer "
				+ "tratando de llevar a cabo el registro del nuevo Tipo de Identificación. Por favor revise la traza completa "
				+ "del problema presentado para así poder identificar qué sucedió..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000032, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema inesperado de tipo Exception en el método crear de la clase TipoIdentificacion SQLServer "
				+ "tratando de llevar a cabo el registro del nuevo Tipo de Identificación. Por favor revise la traza completa "
				+ "del problema presentado para así poder identificar qué sucedió..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000033, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de consultar la información del tipo de identificación por el identificador deseado."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000034, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema de tipo SQLException en el método consultar por id de la clase TipoIdentificacion SQLServer "
				+ "tratando de llevar a cabo la consulta del Tipo de Identificación. Por favor revise la traza completa "
				+ "del problema presentado para así poder identificar qué sucedió..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000035, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema de tipo SQLException en el método consultar por id de la clase TipoIdentificacion SQLServer "
				+ "tratando de preparar la sentencia SQL de la consulta del tipo de identificación deseado. Por favor revise la traza completa "
				+ "del problema presentado para así poder identificar qué sucedió..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000036, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema inesperado de tipo Exception en el método consultar por id de la clase TipoIdentificacion SQLServer "
				+ "tratando de preparar la sentencia SQL de la consulta del tipo de identificación deseado. Por favor revise la traza completa "
				+ "del problema presentado para así poder identificar qué sucedió..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000037, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema tratando de crear el DAO deseado, debido a que la conexiòn actualmente está cerrada, "
				+ "por lo que no hay una conexiòn vàlida disponible..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000038, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de actualizar la información del tipo de identificación deseado."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000039, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema de tipo SQLException en el método modificar de la clase TipoIdentificacionSQLServer "
				+ "tratando de llevar a cabo la actualización del Tipo de Identificación deseado. Por favor revise la traza completa "
				+ "del problema presentado para así poder identificar qué sucedió..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000040, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema inesperado de tipo Exception en el método modificar de la clase TipoIdentificacionSQLServer "
				+ "tratando de llevar a cabo la actualización del Tipo de Identificación deseado. Por favor revise la traza completa "
				+ "del problema presentado para así poder identificar qué sucedió..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000041, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de eliminar la información del tipo de identificación por el identificador deseado."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000042, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema de tipo SQLException en el método eliminar de la clase TipoIdentificacionSQLServer "
				+ "tratando de llevar a cabo la eliminación del Tipo de Identificación deseado. Por favor revise la traza completa "
				+ "del problema presentado para así poder identificar qué sucedió..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000043, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema inesperado de tipo Exception en el método eliminar de la clase TipoIdentificacionSQLServer "
				+ "tratando de llevar a cabo la eliminación del Tipo de Identificación deseado. Por favor revise la traza completa "
				+ "del problema presentado para así poder identificar qué sucedió..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000044, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema inesperado de tipo Exception en el método ejecutarConsultaPorId."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000045, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de llevar a cabo la consulta de los Tipos de Identificación..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000046, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema de tipo SQLExcepcion en el método colocarParametrosConsulta de la clase "
				+ "TipoIdentificacionSQLServerDAO tratando de colocar los parámetros de la consulta SQL.  Por favor revise la "
				+ "traza completa del problema presentado para así poder identificar qué sucedió... ..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000047, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema inesperado de tipo SQLExcepcion en el método colocarParametrosConsulta de la clase "
				+ "TipoIdentificacionSQLServerDAO tratando de colocar los parámetros de la consulta SQL.  Por favor revise la "
				+ "traza completa del problema presentado para así poder identificar qué sucedió... ..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000048, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema de tipo SQLExcepcion en el método consultar de la clase "
				+ "TipoIdentificacionSQLServerDAO tratando de preparar la sentencia SQL.  Por favor revise la "
				+ "traza completa del problema presentado para así poder identificar qué sucedió... ..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000049, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema inesperado de tipo SQLExcepcion en el método consultar de la clase "
						+ "TipoIdentificacionSQLServerDAO tratando de preparar la sentencia SQL.  Por favor revise la "
						+ "traza completa del problema presentado para así poder identificar qué sucedió... ..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000050, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema de tipo SQLExcepcion en el método ejecutarConsulta de la clase "
				+ "TipoIdentificacionSQLServerDAO tratando de ejecutar la consulta SQL.  Por favor revise la "
				+ "traza completa del problema presentado para así poder identificar qué sucedió... ..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000051, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema inesperado de tipo SQLExcepcion en el método ejecutarConsulta de la clase "
				+ "TipoIdentificacionSQLServerDAO tratando de ejecutar la consulta SQL.  Por favor revise la "
				+ "traza completa del problema presentado para así poder identificar qué sucedió... ..."));
	}
	
	private static final void agregarMensaje(final Mensaje mensaje) {
		MENSAJES.put(mensaje.getCodigo(), mensaje);
	}
	
	public static final Mensaje obtenerMensaje(final CodigoMensaje codigo) {
		if (UtilObjeto.esNulo(codigo)) {
			var mensajeUsuario = obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = obtenerContenidoMensaje(CodigoMensaje.M0000000003);
			throw CrossCuttingTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico);
			
		}
		
		if (!MENSAJES.containsKey(codigo)) {
			var mensajeUsuario = obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = obtenerContenidoMensaje(CodigoMensaje.M0000000002);
			throw CrossCuttingTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		}
		return MENSAJES.get(codigo);
	}
	
	public static final String obtenerContenidoMensaje(final CodigoMensaje codigo) {
		return obtenerMensaje(codigo).getContenido();
	}
	
	public static void main(String[] args) {
		System.out.println(obtenerContenidoMensaje(CodigoMensaje.M0000000001));
	}
}
