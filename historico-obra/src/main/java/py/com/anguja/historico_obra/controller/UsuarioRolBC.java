package py.com.anguja.historico_obra.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import py.com.anguja.historico_obra.model.UsuarioRol;
import py.com.anguja.historico_obra.persistence.UsuarioRolDAO;

@RequestScoped

public class UsuarioRolBC {
	
	@Inject
	
	private UsuarioRolDAO usuarioRolDAO;
	
	public UsuarioRol buscarUsuarioRol(Integer idUsuarioRol) {
		return this.usuarioRolDAO.buscarUsuarioRol(idUsuarioRol);
		 
	}
	
	public void crearUsuarioRol(UsuarioRol usuarioRol){
		this.usuarioRolDAO.crearUsuarioRol(usuarioRol);
		
	}
	
	public void actualizarUsuarioRol(UsuarioRol usuarioRol){
		this.usuarioRolDAO.actualizarUsuarioRol(usuarioRol);
		
	}
	
	
	
	public void eliminarUsuarioRol(Long idUsuarioRol){
		this.usuarioRolDAO.eliminarUsuarioRol(idUsuarioRol);
		
	}
	

}
