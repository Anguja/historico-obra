package py.com.anguja.historico_obra.persistence;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;

import py.com.anguja.historico_obra.model.TipoObra;
import py.com.anguja.historico_obra.model.TipoTarea;

@ApplicationScoped
public class TipoTareaDAO {

	@Inject
	private EntityManager em;
	
	public TipoTarea buscarTipoTarea(Long idTipoTarea){
		return em.find(TipoTarea.class, idTipoTarea);
	}
	
	public TipoTarea buscarTipoTarea(String descripcionTipoTarea){
		Session session = (Session) em.getDelegate();
		Query query = session.createQuery(
				"SELECT new TipoTarea(idTipoTarea, descripcionTipoTarea, fechaActualizacion, fechaRegistro) FROM TipoTarea WHERE descripcionTipoTarea = :descripcionTipoTarea");
		query.setString("descripcionTipoTarea", descripcionTipoTarea);
		return (TipoTarea) query.uniqueResult();
	}


	@Transactional
	public void crearTipoTarea(TipoTarea tipoTarea) {
		em.persist(tipoTarea);
	}

	@Transactional
	public void actualizarTipoTarea(TipoTarea tipoTarea) {
		em.merge(tipoTarea);
	}

	@Transactional
	public void eliminarTipoTarea(Long idTipoTarea) {
		em.remove(idTipoTarea);
	}

}
