package py.com.anguja.historico_obra.persistence;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import py.com.anguja.historico_obra.model.Usuario;

@ApplicationScoped
public class UsuarioDAO {

	@Inject
	private EntityManager em;

	public List<Usuario> obtenerUsuarios(int pageSize, int start, String sortField, boolean sortAsc,
			Map<String, String> filters) {
		Session session = (Session) em.getDelegate();
		List<Usuario> listaRetorno = new ArrayList<Usuario>();

		Criteria criteria = session.createCriteria(Usuario.class, "usuario");

		ProjectionList projections = Projections.projectionList();

		projections.add(Projections.property("idUsuario"), "idUsuario");
		projections.add(Projections.property("nombres"), "nombres");
		projections.add(Projections.property("apellido"), "apellido");
		projections.add(Projections.property("nombreUsuario"), "nombreUsuario");
		projections.add(Projections.property("correo"), "correo");
		projections.add(Projections.property("cedula"), "cedula");
		projections.add(Projections.property("activo"), "activo");

		criteria.setProjection(projections);

		if (sortField != null && !sortField.isEmpty()) {
			Order order = Order.asc(sortField);

			if (sortAsc) {
				order = Order.desc(sortField);
			}
			criteria.addOrder(order);
		} else {
			Order order = Order.asc("idUsuario");
			criteria.addOrder(order);
		}

		Disjunction clausulaOR = Restrictions.disjunction();

		if (!filters.isEmpty()) {
			Set<String> keySet = filters.keySet();
			for (String stringKey : keySet) {

				clausulaOR.add(Restrictions.ilike(stringKey, filters.get(stringKey), MatchMode.ANYWHERE));
			}
		}

		criteria.add(clausulaOR);
		criteria.setFirstResult(start);
		criteria.setMaxResults(pageSize);

		criteria.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);

		Iterator<?> iter = criteria.list().iterator();

		while (iter.hasNext()) {

			Map<?, ?> map = (Map<?, ?>) iter.next();

			Usuario usuario = new Usuario((Long) map.get("usuarioId"), (Boolean) map.get("activo"),
					(String) map.get("apellido"), (String) map.get("cedula"), (String) map.get("correo"),
					(String) map.get("nombres"), (String) map.get("nombreUsuario"));

			listaRetorno.add(usuario);

		}

		return listaRetorno;
	}
	
	/**
	 * Método que obtiene el total de registros al filtrar {@link int}
	 * 
	 * @author Ricardo Ramírez
	 * 
	 * @param filters
	 *            Objeto de tipo {@link Map} que contiene los campos con los
	 *            filtros enviados por el cliente.
	 * 
	 * @result {@link int} Cantidad de registros.
	 **/
	public int obtenerCantidadPorFiltro(Map<String, String> filters) {

		Session session = (Session) em.getDelegate();

		Criteria criteria = session.createCriteria(Usuario.class, "usuario");

		Disjunction clausulaOR = Restrictions.disjunction();

		if (!filters.isEmpty()) {
			Set<String> keySet = filters.keySet();
			for (String stringKey : keySet) {

				clausulaOR.add(Restrictions.ilike(stringKey, filters.get(stringKey), MatchMode.ANYWHERE));
			}
			criteria.add(clausulaOR);
		}

		return ((Number) criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
	}

	public Usuario buscarUsuario(Long idUsuario) {
		Session session = (Session) em.getDelegate();
		Query query = session
				.createQuery("SELECT new Usuario(idUsuario, nombreUsuario) FROM Usuario WHERE idUsuario = :idUsuario");
		query.setLong("idUsuario", idUsuario);
		return (Usuario) query.uniqueResult();
	}

	public Usuario buscarUsuario(String nombreUsuario) {
		Session session = (Session) em.getDelegate();
		Query query = session.createQuery(
				"SELECT new Usuario(idUsuario, nombreUsuario) FROM Usuario WHERE nombreUsuario = :nombreUsuario");
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
