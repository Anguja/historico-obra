package py.com.anguja.historico_obra.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.util.SimpleByteSource;

import py.com.anguja.historico_obra.dto.Respuesta;
import py.com.anguja.historico_obra.dto.UsuarioDTO;
import py.com.anguja.historico_obra.model.Usuario;
import py.com.anguja.historico_obra.persistence.UsuarioDAO;

@RequestScoped
public class UsuarioBC extends GenericController<Usuario> {

	@Inject
	private UsuarioDAO usuarioDAO;

	/**
	 * Método que obtiene la lista de usuarios, aplicando determinados filtros.
	 * 
	 * @author Ricardo Ramírez
	 * 
	 * @param filtro
	 * 
	 * @param pageSize
	 *            Cantidad de filas por páginasactualizarContrasenha
	 * @param start
	 *            Número de página del table (OFFSET)
	 * @param sortField
	 *            Columna por el cuál se debe realizar el ORDER BY
	 * @param sortAsc
	 *            Valor booleano en caso que sea TRUE el ORDER BY será ASC; en
	 *            caso contrario será DESC
	 * 
	 * @return {@link UsuarioDTO} Listado de usuarios, con su cabecera.
	 */
	public UsuarioDTO filtrarUsuarios(String filtro, int pageSize, int start, String sortField, boolean sortAsc) {
		Map<String, String> filters = this.parseFilters(filtro, "usuario.nombres", "usuario.apellido",
				"usuario.nombreUsuario", "usuario.cedula");

		List<Usuario> usuarios = this.usuarioDAO.obtenerUsuarios(pageSize, start, sortField, sortAsc, filters);
		int totalNumberOfRows = this.usuarioDAO.obtenerCantidadPorFiltro(filters);

		return (UsuarioDTO) this.marshallDTO(usuarios, totalNumberOfRows, pageSize, new UsuarioDTO());
	}

	/**
	 * @return {@link Usuario}
	 */
	public Usuario buscarUsuarioSesion() {

		return this.usuarioDAO.buscarUsuario(SecurityUtils.getSubject().getPrincipal().toString());
	}

	/**
	 * @param nombreUsuario
	 * @return {@link Usuario}
	 */
	public Usuario buscarUsuario(String nombreUsuario) {
		return this.usuarioDAO.buscarUsuario(nombreUsuario);
	}

	/**
	 * @param usuario
	 *            ver {@link Usuario}
	 * @return {@link Respuesta}
	 */
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

	/**
	 * @param usuario
	 *            ver {@link Usuario}
	 */
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
