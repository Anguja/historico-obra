package py.com.anguja.historico_obra.rest;


import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import py.com.anguja.historico_obra.controller.UnidadMedidaBC;
import py.com.anguja.historico_obra.model.UnidadMedida;


@Path("/unidadMedidas")

public class UnidadMedidaRS {
	
	@Inject
	private UnidadMedidaBC unidadMedidaBC;
	
	@POST
	@Path("/crearUnidadMedidas")
	@Consumes(MediaType.APPLICATION_JSON)
	
	public Response crearUnidadMedida(UnidadMedida unidadMedida) {
		this.unidadMedidaBC.crearUnidadMedida(unidadMedida);
		return Response.ok().build();
	}
	
	@GET
	@Path("/getUnidadMedida/{idUnidadMedida}/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response obtener(@PathParam("idUnidadMedida") Integer idUnidadMedida) {
		return Response.ok(this.unidadMedidaBC.buscarUnidadMedida(idUnidadMedida)).build();
	
	}
	
	@PUT
	@Path("/actualizarUnidadMedidas")
	@Consumes(MediaType.APPLICATION_JSON)
	
	public Response actualizarUnidadMedida(UnidadMedida unidadMedida) {
		this.unidadMedidaBC.actualizarUnidadMedida(unidadMedida);
		return Response.ok().build();
	}

	@DELETE
	@Path("/eliminarUnidadMedidas")
	@Consumes(MediaType.APPLICATION_JSON)
	
	public Response eliminarUnidadMedida(Long idUnidadMedida) {
		this.unidadMedidaBC.eliminarUnidadMedida(idUnidadMedida);
		return Response.ok().build();
	}

}
