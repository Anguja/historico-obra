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

import py.com.anguja.historico_obra.controller.RolBC;
import py.com.anguja.historico_obra.model.Rol;

@Path("/roles")
public class RolRS {

	@Inject
	private RolBC rolBC;

	@GET
	@Path("/getRol/{idRol}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarRol(@PathParam("idRol") Long idRol) {
		return Response.ok(this.rolBC.buscarRol(idRol)).build();
	}

	@POST
	@Path("/crearRol")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crearRol(Rol rol) {
		this.rolBC.crearRol(rol);
		return Response.ok().build();
	}

	@PUT
	@Path("/actualizarRol")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response actualizarRol(Rol rol) {
		this.rolBC.actualizarRol(rol);
		return Response.ok().build();
	}

	@DELETE
	@Path("/eliminarRol/{idRol}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response eliminarRol(@PathParam("idRol") Long idRol) {
		this.rolBC.eliminarRol(idRol);
		return Response.ok().build();
	}
}


