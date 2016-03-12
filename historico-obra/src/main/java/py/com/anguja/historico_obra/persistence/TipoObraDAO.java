package py.com.anguja.historico_obra.persistence;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;

import py.com.anguja.historico_obra.model.TipoObra;
import py.com.anguja.historico_obra.model.Usuario;

@ApplicationScoped
public class TipoObraDAO {
	
	@Inject
	private EntityManager em;
	
	public TipoObra buscarTipoObra(Long idTipoObra){
		return em.find(TipoObra.class, idTipoObra);
	}
	
	public TipoObra buscarTipoObra(String descripcionTipoObra){
	Session session = (Session) em.getDelegate();
	Query query = session.createQuery(
			"SELECT new TipoObra(idTipoObra, descripcionTipoObra, fechaActualizacion, fechaRegistro) FROM TipoObra WHERE descripcionTipoObra = :descripcionTipoObra");
	query.setString("descripcionTipoObra", descripcionTipoObra);
	return (TipoObra) query.uniqueResult();
}

	
	@Transactional
	public void crearTipoObra(TipoObra tipoObra) {
		em.persist(tipoObra);
	}
	
	@Transactional
	public void actualizarTipoObra(TipoObra tipoObra) {
		em.merge(tipoObra);
	}
	
	@Transactional
	public void eliminarTipoObra(Long idTipoObra) {
		em.remove(idTipoObra);
	}

}
