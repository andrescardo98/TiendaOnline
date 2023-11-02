package co.edu.uco.tiendaonline.controller.tipoidentificacion.concrete;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.tiendaonline.controller.support.response.Respuesta;
import co.edu.uco.tiendaonline.controller.tipoidentificacion.TipoIdentificacionController;
import co.edu.uco.tiendaonline.crosscutting.exception.TiendaOnlineException;
import co.edu.uco.tiendaonline.service.dto.TipoIdentificacionDTO;
import co.edu.uco.tiendaonline.service.facade.concrete.tipoidentificacion.ResgistrarTipoIdentificacionFacade;

@RestController
@RequestMapping("/api/v1/tipoidentificacion")
public final class TipoIdentificacionControllerImpl implements TipoIdentificacionController{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TipoIdentificacionControllerImpl.class);

	@GetMapping("/dummy")
	@Override
	public final TipoIdentificacionDTO obtenerDummy() {
		LOGGER.info("El dummy de tipo de identificación se generó");
		return TipoIdentificacionDTO.crear();
	}
	
	@PostMapping
	@Override
	public final ResponseEntity<Respuesta<TipoIdentificacionDTO>> registrar(@RequestBody TipoIdentificacionDTO dto) {
		
		Respuesta<TipoIdentificacionDTO> respuesta = new Respuesta<>();
		HttpStatusCode codigoHttp = HttpStatus.BAD_REQUEST;
		
		try {
			ResgistrarTipoIdentificacionFacade facade = new ResgistrarTipoIdentificacionFacade();
			facade.execute(dto);
			codigoHttp = HttpStatus.OK;
			respuesta.getMensajes().add("El tipo de identificación fue registrado exitosamente");
			LOGGER.info("El tipo de identificacion fue registrado exitosamente");
			
		} catch (final TiendaOnlineException excepcion) {
			respuesta.getMensajes().add(excepcion.getMensajeUsuario());
			LOGGER.error(excepcion.getMensajeTecnico(), excepcion.getExcepcionRaiz());
			
		} catch (final Exception excepcion) {
			codigoHttp = HttpStatus.INTERNAL_SERVER_ERROR;
			respuesta.getMensajes().add("Se ha presentado un problema inesperado tratando de registrar el tipo "
					+ "de identificación.");
			LOGGER.error("Se ha presentado un problema inesperado tratando de registrar el tipo "
					+ "de identificación.", excepcion);
		}
		return new ResponseEntity<>(respuesta, codigoHttp);
	}

	@GetMapping("/{id}")
	@Override
	public ResponseEntity<Respuesta<TipoIdentificacionDTO>> consultarPorId(@PathVariable("id") UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@GetMapping
	@Override
	public ResponseEntity<Respuesta<TipoIdentificacionDTO>> consultar(@RequestBody TipoIdentificacionDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@PutMapping("/{id}")
	@Override
	public ResponseEntity<Respuesta<TipoIdentificacionDTO>> modificar(@PathVariable("id")UUID id, 
			@RequestBody TipoIdentificacionDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@DeleteMapping("/{id}")
	@Override
	public ResponseEntity<Respuesta<TipoIdentificacionDTO>> eliminar(@PathVariable("id") UUID id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
