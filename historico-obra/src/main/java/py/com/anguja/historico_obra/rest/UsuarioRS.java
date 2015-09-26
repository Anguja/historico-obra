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

import py.com.anguja.historico_obra.controller.UsuarioBC;
import py.com.anguja.historico_obra.model.Usuario;

@Path("/usuarios")

public class UsuarioRS {
	
	@Inject
	private UsuarioBC usuarioBC;
	
	@POST
	@Path("/crearUsuarios")
	@Consumes(MediaType.APPLICATION_JSON)
	
	public Response crearUsuario(Usuario usuario) {
		this.usuarioBC.crearUsuario(usuario);
		return Response.ok().build();
	}
	
	@GET
	@Path("/getUsuario/{idUsuario}/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response obtener(@PathParam("idUsuario") Integer idUsuario) {
		return Response.ok(this.usuarioBC.buscarUsuario(idUsuario)).build();
	
	}
	
	@PUT
	@Path("/actualizarUsuarios")
	@Consumes(MediaType.APPLICATION_JSON)
	
	public Response actualizarUsuario(Usuario usuario) {
		this.usuarioBC.actualizarUsuario(usuario);
		return Response.ok().build();
	}

	@DELETE
	@Path("/eliminarUsuarios")
	@Consumes(MediaType.APPLICATION_JSON)
	
	public Response eliminarUsuario(Long idUsuario) {
		this.usuarioBC.eliminarUsuario(idUsuario);
		return Response.ok().build();
	}
}
