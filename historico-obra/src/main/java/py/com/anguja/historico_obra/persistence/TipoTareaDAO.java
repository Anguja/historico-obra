package py.com.anguja.historico_obra.persistence;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import py.com.anguja.historico_obra.model.TipoTarea;

@ApplicationScoped
public class TipoTareaDAO {

	@Inject
	private EntityManager em;
	
	public TipoTarea buscarTipoTarea(Long idTipoTarea){
		return em.find(TipoTarea.class, idTipoTarea);
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
