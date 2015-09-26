package py.com.anguja.historico_obra.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;



import py.com.anguja.historico_obra.model.Usuario;
import py.com.anguja.historico_obra.persistence.UsuarioDAO;

@RequestScoped

public class UsuarioBC {
	
	@Inject
	private UsuarioDAO usuarioDAO;
	
	public Usuario buscarUsuario(Integer idUsuario) {
		return this.usuarioDAO.buscarUsuario(idUsuario);
		 
	}
	
	public void crearUsuario(Usuario usuario){
		this.usuarioDAO.crearUsuario(usuario);
		
	}
	
	public void actualizarUsuario(Usuario usuario){
		this.usuarioDAO.actualizarUsuario(usuario);
		
	}
	
	public void eliminarUsuario(Long idUsuario){
		this.usuarioDAO.eliminarUsuario(idUsuario);
		
	}

}
