package py.com.anguja.historico_obra.persistence;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import py.com.anguja.historico_obra.model.Moneda;

/**
 * @author lucio
 * */

@ApplicationScoped
public class MonedaDAO {

	@Inject
	private EntityManager em;
	
	@Transactional
	public void crearMoneda(Moneda modena){
		em.persist(modena);
	}
	
	@Transactional
	public void eliminarMoneda(Long idMoneda){
		Moneda moneda = new Moneda();
		moneda.setIdMoneda(idMoneda);
		em.remove(moneda);
	}
	
	@Transactional
	public void actualizarMoneda(Moneda moneda){
		em.merge(moneda);
	}
	
	public Moneda buscarMoneda(Long idMoneda){
		return em.find(Moneda.class, idMoneda);
	}
}
