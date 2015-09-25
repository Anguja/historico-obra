package py.com.anguja.historico_obra.persistence;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import py.com.anguja.historico_obra.model.TipoObra;

@ApplicationScoped
public class TipoObraDAO {
	
	@Inject
	private EntityManager em;
	
	public TipoObra buscarTipoObra(Long idTipoObra){
		return em.find(TipoObra.class, idTipoObra);
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
