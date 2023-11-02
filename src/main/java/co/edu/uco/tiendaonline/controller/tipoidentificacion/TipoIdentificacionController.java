package co.edu.uco.tiendaonline.controller.tipoidentificacion;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import co.edu.uco.tiendaonline.controller.support.response.Respuesta;
import co.edu.uco.tiendaonline.service.dto.TipoIdentificacionDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "NombreAPI", description = "DescripciónAPI")
public interface TipoIdentificacionController {
	
	@Operation(summary = "obtenerDummy", description = "Servicio encargado de obtener la estructura JSON básico de un TipoIdentificacion")
	TipoIdentificacionDTO obtenerDummy();
	
	@Operation(summary = "consultarPorId", description = "Servicio encargado de obtener la información del TipoIdentificacion asociado al id enviado como filtro de consulta")
	ResponseEntity<Respuesta<TipoIdentificacionDTO>> consultarPorId(@PathVariable("id") UUID id);
	
	@Operation(summary = "consultar", description = "Servicio encargado de obtener la información de un TipoIdentificacion")
	ResponseEntity<Respuesta<TipoIdentificacionDTO>> consultar(@RequestBody TipoIdentificacionDTO dto);
	
	@Operation(summary = "registrar", description = "Servicio encargado de registrar la información del nuevo tipo de identificación enviado como parámetro")
	
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Tipo de identifiacion registrado exitosamente"), 
		@ApiResponse(responseCode = "400", description = "Tipo de identifiacion no registrado exitosamente por algun problema desconocido"),
		 @ApiResponse(responseCode = "500", description = "Tipo de identifiacion no registrado exitosamente por un problema inesperado")})
	ResponseEntity<Respuesta<TipoIdentificacionDTO>> registrar(@RequestBody TipoIdentificacionDTO dto);
	
	@Operation(summary = "modificar", description = "Servicio encargado de modificar la información del tipo de identificación correspondiente al id enviado como parámetro")
	ResponseEntity<Respuesta<TipoIdentificacionDTO>> modificar(@PathVariable("id") UUID id, 
			@RequestBody TipoIdentificacionDTO dto);
	
	@Operation(summary = "eliminar", description = "Servicio encargado de eliminar de forma definitiva la información del tipo de identificación enviado como parámetro")
	ResponseEntity<Respuesta<TipoIdentificacionDTO>> eliminar(@PathVariable("id") UUID id);
}
