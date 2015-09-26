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

import py.com.anguja.historico_obra.controler.TipoObraBC;
import py.com.anguja.historico_obra.controler.TipoTareaBC;
import py.com.anguja.historico_obra.model.TipoObra;
import py.com.anguja.historico_obra.model.TipoTarea;

@Path("/tipoTareas")
public class TipoTareaRS {

	@Inject
	private TipoTareaBC tipoTareaBC;

	@GET
	@Path("/getTipoTarea/{idTipoTarea}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarTipoTarea(@PathParam("idTipoTarea") Long idTipoTarea) {
		return Response.ok(this.tipoTareaBC.buscarTipoTarea(idTipoTarea)).build();
	}

	@POST
	@Path("/crearTipoTarea")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crearTipoTarea(TipoTarea tipoTarea) {
		this.tipoTareaBC.crearTipoTarea(tipoTarea);
		return Response.ok().build();
	}

	@PUT
	@Path("/actualizarTipoTarea")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response actualizarTipoTarea(TipoTarea tipoTarea) {
		this.tipoTareaBC.actualizarTipoTarea(tipoTarea);
		return Response.ok().build();
	}

	@DELETE
	@Path("/eliminarTipoTarea/{idTipoTarea}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response eliminarTipoTarea(@PathParam("idTipoTarea") Long idTipoTarea) {
		this.tipoTareaBC.eliminarTipoTarea(idTipoTarea);
		return Response.ok().build();
	}


}
