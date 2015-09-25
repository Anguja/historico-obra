package py.com.anguja.historico_obra.persistence;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import py.com.anguja.historico_obra.model.Usuario;

@ApplicationScoped

public class UsuarioDAO {

	@Inject
	private EntityManager em;

	public Usuario buscarUsuario(Integer idUsuario){
		return em.find(Usuario.class, idUsuario);
	}

	@Transactional
	public void crearUsuario(Usuario usuario){
		em.persist(usuario);

	}
	
	@Transactional
	public void actualizarUsuario(Usuario usuario){
		em.merge(usuario);

	}
	
		
	@Transactional
	public void eliminarUsuario(Long idUsuario){
		em.remove(idUsuario);

	}



}
