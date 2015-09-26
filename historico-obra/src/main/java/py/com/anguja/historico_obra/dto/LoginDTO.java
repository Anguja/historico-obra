package py.com.anguja.historico_obra.dto;

import py.com.anguja.historico_obra.model.Usuario;

public class LoginDTO {

	private Boolean success;

	private String message;

	private Usuario usuario;

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
