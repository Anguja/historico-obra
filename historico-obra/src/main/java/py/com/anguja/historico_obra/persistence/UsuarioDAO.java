package py.com.anguja.historico_obra.persistence;

import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import py.com.anguja.historico_obra.model.Usuario;

@ApplicationScoped

public class UsuarioDAO {

	@Inject
	private EntityManager em;

	public Usuario buscarUsuario(Long idUsuario) {
		return em.find(Usuario.class, idUsuario);
	}

	public Usuario buscarUsuario(String nombreUsuario) {
		Session session = (Session) em.getDelegate();
		Criteria criteria = session.createCriteria(Usuario.class);
		ProjectionList projection = Projections.projectionList();
		projection.add(Projections.property("idUsuario"), "idUsuario");

		criteria.setProjection(projection);
		criteria.add(Restrictions.eq("nombreUsuario", nombreUsuario));

		criteria.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);

		Map<?, ?> mapper = (Map<?, ?>) criteria.uniqueResult();
		Usuario usuario = new Usuario((Long) mapper.get("idUsuario"));

		return usuario;
	}

	@Transactional
	public void crearUsuario(Usuario usuario) {
		em.persist(usuario);

	}

	@Transactional
	public void actualizarUsuario(Usuario usuario) {
		em.merge(usuario);

	}

	@Transactional
	public void eliminarUsuario(Long idUsuario) {
		em.remove(idUsuario);

	}

}
