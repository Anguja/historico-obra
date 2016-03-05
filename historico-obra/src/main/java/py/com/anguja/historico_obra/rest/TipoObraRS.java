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

import py.com.anguja.historico_obra.controller.TipoObraBC;
import py.com.anguja.historico_obra.model.TipoObra;


@Path("/tipoObras")
public class TipoObraRS {

	@Inject
	private TipoObraBC tipoObraBC;

	@GET
	@Path("/getTipoObra/{idTipoObra}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarTipoObra(@PathParam("idTipoObra") Long idTipoObra) {
		return Response.ok(this.tipoObraBC.buscarTipoObra(idTipoObra)).build();
	}

	@POST
	@Path("/crearTipoObra")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crearTipoObra(TipoObra tipoObra) {
		return Response.ok().entity(this.tipoObraBC.crearTipoObra(tipoObra)).build();
	}

	@PUT
	@Path("/actualizarTipoObra")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response actualizarTipoObra(TipoObra tipoObra) {
		this.tipoObraBC.actualizarTipoObra(tipoObra);
		return Response.ok().build();
	}

	@DELETE
	@Path("/eliminarTipoObra/{idTipoObra}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response eliminarTipoObra(@PathParam("idTipoObra") Long idTipoObra) {
		this.tipoObraBC.eliminarTipoObra(idTipoObra);
		return Response.ok().build();
	}
}
