package py.com.anguja.historico_obra.rest;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;

import py.com.anguja.historico_obra.dto.Respuesta;

@Path("/security")
@RequestScoped
public class SecurityRS {

	@Path("/doLogin")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Respuesta doLogin(UsernamePasswordToken token) {
		Respuesta respuesta = new Respuesta();
		try {

			SecurityUtils.getSubject().login(token);

			if (SecurityUtils.getSubject().isAuthenticated()) {
				respuesta.setSuccess(true);
			}

		} catch (AuthenticationException ex) {
			respuesta.setSuccess(false);
			respuesta.setMessage("Credenciales incorrectas.");
		}

		return respuesta;
	}

	@Path("/doLogout")
	@GET
	public Respuesta doLogout() {
		SecurityUtils.getSubject().logout();
		return new Respuesta("Success!!", true);
	}

}
