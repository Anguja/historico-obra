package py.com.anguja.historico_obra.persistence;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import py.com.anguja.historico_obra.model.Usuario;
import py.com.anguja.historico_obra.model.UsuarioRol;

@ApplicationScoped

public class UsuarioRolDAO {

	@Inject
	private EntityManager em;

	public UsuarioRol buscarUsuarioRol(Integer idUsuarioRol){
		return em.find(UsuarioRol.class, idUsuarioRol);
	}

	@Transactional
	public void crearUsuarioRol(UsuarioRol usuarioRol){
		em.persist(usuarioRol);

	}

	@Transactional
	public void actualizarUsuarioRol(UsuarioRol usuarioRol){
		em.merge(usuarioRol);

	}
	
	
	@Transactional
	public void eliminarUsuarioRol(Long idUsuarioRol){
		em.remove(idUsuarioRol);

	}


}
