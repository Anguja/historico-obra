package py.com.anguja.historico_obra.rest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;

import py.com.anguja.historico_obra.controller.UsuarioBC;
import py.com.anguja.historico_obra.dto.LoginDTO;
import py.com.anguja.historico_obra.dto.Respuesta;

/**
 * @author Ricardo Ramírez
 * 
 *         Clase que contiene todos los método REST FULL correspondiente a la
 *         seguridad.
 *
 */
@Path("/security")
@RequestScoped
public class SecurityRS {

	@Inject
	private UsuarioBC usuarioBC;

	/**
	 * @author Ricardo Ramírez
	 * 
	 *         Método que realiza el login del usuario utilizando la clase
	 *         {@link SecurityUtils} de Apache Shiro.
	 * 
	 *         En caso de que el login no sea exitoso, se atrapa una excepción
	 *         de tipo {@link AuthenticationException} para lanzar un mensaje
	 *         personalizado.
	 * 
	 * @param token
	 *            {@link UsernamePasswordToken}
	 * @return {@link Respuesta}
	 */
	@Path("/doLogin")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public LoginDTO doLogin(UsernamePasswordToken token) {
		LoginDTO loginDTO = new LoginDTO();
		try {

			SecurityUtils.getSubject().login(token);

			if (SecurityUtils.getSubject().isAuthenticated()) {
				loginDTO.setSuccess(true);
			}

			loginDTO.setUsuario(usuarioBC.buscarUsuario(token.getUsername()));

		} catch (AuthenticationException ex) {
			loginDTO.setSuccess(false);
			loginDTO.setMessage("Credenciales incorrectas.");
		}

		return loginDTO;
	}

	@Path("/doLogout")
	@GET
	public Respuesta doLogout() {
		SecurityUtils.getSubject().logout();
		return new Respuesta("Success!!", true);
	}

	/**
	 * @author Ricardo Ramírez
	 * 
	 *         Método que verifica si un usuario se encuentra autenticado en el
	 *         servidor.
	 * 
	 * @return {@link Respuesta}
	 */
	@Path("/verifySession")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Respuesta verifySession() {
		Respuesta respuesta = new Respuesta();

		if (SecurityUtils.getSubject().isAuthenticated()) {
			respuesta.setSuccess(true);
		} else {
			respuesta.setSuccess(false);
		}

		return respuesta;
	}

}
