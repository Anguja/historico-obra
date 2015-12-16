package py.com.anguja.historico_obra.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
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
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crearMoneda(Moneda moneda){
		return Response.ok("Creado...").entity(this.monedaBC.crearMoneda(moneda)).build();
	} 
	
	@GET
	@Path("/listarMonedas")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response listarMonedas(){
		return Response.ok("listar...").entity(this.monedaBC.listarMonedas()).build();
	}
	
	@POST
	@Path("/actualizarMoneda")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response actualizarMoneda(Moneda moneda){
		return Response.ok("Actualizado...").entity(this.monedaBC.actualizarMoneda(moneda)).build();
	}
	
	@POST
	@Path("/eliminarMoneda")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response eliminarMoneda(Moneda moneda){
		return Response.ok("Eliminado...").entity(this.monedaBC.eliminarMoneda(moneda.getIdMoneda())).build();
	}
	
}
