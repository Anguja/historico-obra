package py.com.anguja.historico_obra.controller;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.util.SimpleByteSource;

import py.com.anguja.historico_obra.dto.Respuesta;
import py.com.anguja.historico_obra.model.Usuario;
import py.com.anguja.historico_obra.persistence.UsuarioDAO;

@RequestScoped
public class UsuarioBC {

	@Inject
	private UsuarioDAO usuarioDAO;

	public Usuario buscarUsuarioSesion() {

		return this.usuarioDAO.buscarUsuario(SecurityUtils.getSubject().getPrincipal().toString());
	}

	public Usuario buscarUsuario(String nombreUsuario) {
		return this.usuarioDAO.buscarUsuario(nombreUsuario);
	}

	public Respuesta crearUsuario(Usuario usuario) {
		Respuesta respuesta = new Respuesta();

		Boolean cumpleCondicion = verificarComplejidadContrasenha(usuario.getPassword());
		if (!cumpleCondicion) {
			return new Respuesta("Contraseña inválida.", false);
		}

		Usuario nombreUsuario = this.usuarioDAO.buscarUsuario(usuario.getNombreUsuario());

		if (nombreUsuario != null) {
			return new Respuesta("Nombre de usuario ya existe", false);
		}

		String salt = "random_salt_value_".concat(usuario.getNombreUsuario());
		Sha256Hash sha256Hash = generarContrasenha(usuario.getPassword(), salt);
		String result = sha256Hash.toHex();

		usuario.setSalt(salt);
		usuario.setPassword(result);
		usuario.setFechaRegistro(new Date());
		usuario.setActivo(true);

		this.usuarioDAO.crearUsuario(usuario);

		respuesta.setSuccess(true);
		respuesta.setMessage("Usuario creado.");

		return respuesta;
	}

	public void actualizarUsuario(Usuario usuario) {
		this.usuarioDAO.actualizarUsuario(usuario);

	}

	/**
	 * Método utilizado para verificar la complejidad de la contraseña,
	 * utilizando la clase {@link Pattern}
	 * 
	 * @author Ricardo Ramírez
	 * @param clave
	 *            Cadena a verificar.
	 * @return {@link Boolean}
	 */
	private Boolean verificarComplejidadContrasenha(String clave) {
		Pattern patternNumber = Pattern.compile("[0-9]+");
		Pattern patternUpperCase = Pattern.compile("[A-Z]+");
		Pattern patternLowerCase = Pattern.compile("[a-z]+");

		Matcher matcherNumber = patternNumber.matcher(clave);
		Matcher matcherUpperCase = patternUpperCase.matcher(clave);
		Matcher matcherLowerCase = patternLowerCase.matcher(clave);

		if (matcherNumber.find() && matcherUpperCase.find() && matcherLowerCase.find() && clave.length() >= 8
				&& clave.length() <= 15) {
			return true;
		}
		return false;
	}

	private Sha256Hash generarContrasenha(String contrasenha, String salt) {
		Sha256Hash sha256Hash = new Sha256Hash(contrasenha, (new SimpleByteSource(salt)).getBytes());
		return sha256Hash;
	}

}
