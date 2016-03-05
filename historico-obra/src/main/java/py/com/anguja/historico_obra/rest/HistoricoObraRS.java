package py.com.anguja.historico_obra.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import py.com.anguja.historico_obra.controller.HistoricoObraBC;

@Path("/rest")
public class HistoricoObraRS {

	@Inject
	private HistoricoObraBC historicoBC;
	
	@GET
	@Path("/getHistorico/{idHistObra}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarHistoricoObra(
			@PathParam("idHistObra") Long idHistObra) {
		return Response.ok(this.historicoBC.buscarHistoricoObra(idHistObra)).build();
	}
}
