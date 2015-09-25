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

import py.com.anguja.historico_obra.controller.UsuarioRolBC;

import py.com.anguja.historico_obra.model.UsuarioRol;

@Path("/usuarioRoles")

public class UsuarioRolRS {
	
	@Inject
	private UsuarioRolBC usuarioRolBC;
	
	@POST
	@Path("/crearUsuarioRoles")
	@Consumes(MediaType.APPLICATION_JSON)
	
	public Response crearUsuarioRol(UsuarioRol usuarioRol) {
		this.usuarioRolBC.crearUsuarioRol(usuarioRol);
		return Response.ok().build();
	}
	
	@GET
	@Path("/getUsuarioRol/{idUsuarioRol}/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response obtener(@PathParam("idUsuarioRol") Integer idUsuarioRol) {
		return Response.ok(this.usuarioRolBC.buscarUsuarioRol(idUsuarioRol)).build();
	
	}
	
	@PUT
	@Path("/actualizarUsuarioRoles")
	@Consumes(MediaType.APPLICATION_JSON)
	
	public Response actualizarUsuarioRol(UsuarioRol usuarioRol) {
		this.usuarioRolBC.actualizarUsuarioRol(usuarioRol);
		return Response.ok().build();
	}

	@DELETE
	@Path("/eliminarUsuarioRoles")
	@Consumes(MediaType.APPLICATION_JSON)
	
	public Response eliminarUsuarioRol(Long idUsuarioRol) {
		this.usuarioRolBC.eliminarUsuarioRol(idUsuarioRol);
		return Response.ok().build();
	}

}
