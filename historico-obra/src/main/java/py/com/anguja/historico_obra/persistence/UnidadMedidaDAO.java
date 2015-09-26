package py.com.anguja.historico_obra.persistence;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import py.com.anguja.historico_obra.model.UnidadMedida;
import py.com.anguja.historico_obra.model.Usuario;

@ApplicationScoped

public class UnidadMedidaDAO {

	@Inject
	private EntityManager em;

	public UnidadMedida buscarUnidadMedida(Integer idUnidadMedida){
		return em.find(UnidadMedida.class, idUnidadMedida);
	}

	@Transactional
	public void crearUnidadMedida(UnidadMedida unidadMedida){
		em.persist(unidadMedida);

	}

	@Transactional
	public void actualizarUnidadMedida(UnidadMedida unidadMedida){
		em.merge(unidadMedida);

	}
	
		
	@Transactional
	public void eliminarUnidadMedida(Long idUnidadMedida){
		em.remove(idUnidadMedida);

	}


}
