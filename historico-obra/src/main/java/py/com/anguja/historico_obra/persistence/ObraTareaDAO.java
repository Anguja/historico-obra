package py.com.anguja.historico_obra.persistence;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import py.com.anguja.historico_obra.model.ObraTarea;

/**
 * @author lucio
 * */

@ApplicationScoped
public class ObraTareaDAO {

	@Inject
	private EntityManager em;
	
	@Transactional
	public void crearObraTarea(ObraTarea obraTarea){
		em.persist(obraTarea);
	}
	
	@Transactional
	public void actualizarObraTarea(ObraTarea obraTarea){
		em.merge(obraTarea);
	}
	
	@Transactional
	public void eliminarObraTarea(Long idObraTarea){
		ObraTarea obraTarea = new ObraTarea();
		obraTarea.setIdObraTarea(idObraTarea);
		em.remove(obraTarea);
	}
	
	public ObraTarea buscarObraTarea(Long idObraTarea){
		return em.find(ObraTarea.class, idObraTarea);
	}
}
