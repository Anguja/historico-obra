package py.com.anguja.historico_obra.persistence;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;

import py.com.anguja.historico_obra.model.Usuario;

@ApplicationScoped

public class UsuarioDAO {

	@Inject
	private EntityManager em;

	public Usuario buscarUsuario(Long idUsuario) {
		Session session = (Session) em.getDelegate();
		Query query = session
				.createQuery("SELECT new Usuario(nombreUsuario) FROM Usuario WHERE idUsuario = :idUsuario");
		query.setLong("idUsuario", idUsuario);
		return (Usuario) query.uniqueResult();
	}

	public Usuario buscarUsuario(String nombreUsuario) {
		Session session = (Session) em.getDelegate();
		Query query = session
				.createQuery("SELECT new Usuario(idUsuario) FROM Usuario WHERE nombreUsuario = :nombreUsuario");
		query.setString("nombreUsuario", nombreUsuario);
		return (Usuario) query.uniqueResult();
	}

	@Transactional
	public void crearUsuario(Usuario usuario) {
		em.persist(usuario);

	}

	@Transactional
	public void actualizarUsuario(Usuario usuario) {
		// em.merge(usuario);

	}
}
