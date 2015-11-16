package py.com.anguja.historico_obra.rest;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import py.com.anguja.historico_obra.controller.MonedaBC;
import py.com.anguja.historico_obra.model.Moneda;

@Path("/moneda")
public class MonedaRS {

	@Inject
	private MonedaBC monedaBC;
	
	@POST
	@Path("/crearMoneda")
	@Produces(MediaType.APPLICATION_JSON)
	public Response crearMoneda(Moneda moneda){
		monedaBC.crearMoneda(moneda);
		return Response.ok("Creado...").build();
	} 
}
