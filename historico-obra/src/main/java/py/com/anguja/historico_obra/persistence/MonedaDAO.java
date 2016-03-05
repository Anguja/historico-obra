package py.com.anguja.historico_obra.persistence;

import java.util.Date;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;

import py.com.anguja.historico_obra.model.HistObra;
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
		Moneda currentMoneda = buscarMoneda(moneda.getIdMoneda());
		currentMoneda.setCotizacion(moneda.getCotizacion());
		currentMoneda.setDescripcionMoneda(moneda.getDescripcionMoneda());
		currentMoneda.setFechaActualizacion(new Date());
	}
	
	public Moneda buscarMoneda(Long idMoneda){
		return em.find(Moneda.class, idMoneda);
	}
	
	@SuppressWarnings("unchecked")
	public List<Moneda> listarMoneda(){
		Session session = (Session) em.getDelegate();
		Criteria criteria = session.createCriteria(Moneda.class);
		
		return criteria.list();
	}
}
