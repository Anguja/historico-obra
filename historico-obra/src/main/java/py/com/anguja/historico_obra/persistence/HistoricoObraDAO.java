package py.com.anguja.historico_obra.persistence;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import py.com.anguja.historico_obra.model.HistObra;

/**
 * @author lucio
 * */

@ApplicationScoped
public class HistoricoObraDAO {
	
	@Inject
	private EntityManager em;

	@Transactional
	public void crearHistoricoObra(HistObra historico){
		em.persist(historico);
	}
	
	//nombre, fecha_fin, fecha_inicio, tipo de obra, obra tarea, monto de contrato, ubicacion, consorcio, descripcion de la obra
	@SuppressWarnings("unchecked")
	public List<HistObra> buscarHistoricoObra(HistObra historico){
		Session session = (Session) em.getDelegate();
		Criteria criteria  = session.createCriteria(HistObra.class);
		
		Disjunction disjunction = Restrictions.disjunction();
		
		if(historico.getNombre() != null)
			disjunction.add(Restrictions.ilike("nombre", historico.getNombre(), MatchMode.ANYWHERE));	
		
		if(historico.getUbicacion() != null)
			disjunction.add(Restrictions.ilike("ubicacion", historico.getUbicacion(), MatchMode.ANYWHERE));
		
		if(historico.getConsorcio() != null)
			disjunction.add(Restrictions.ilike("consorcio", historico.getConsorcio(), MatchMode.ANYWHERE));
		
		if(historico.getDescripcionObra() != null)
			disjunction.add(Restrictions.ilike("descripcionObra", historico.getDescripcionObra(), MatchMode.ANYWHERE));
		
		
		Conjunction conjunction = Restrictions.conjunction();
		if(historico.getFechaFinContrato() != null)
			conjunction.add(Restrictions.eq("fechaFinContrato", historico.getFechaFinContrato()));
		
		if(historico.getFechaInicioContrato() != null)
			conjunction.add(Restrictions.eq("fechaInicioContrato", historico.getFechaInicioContrato()));
				
		if(historico.getMontoContrato() != null)
			conjunction.add(Restrictions.eq("montoContrato", historico.getMontoContrato()));
				
		conjunction.add(conjunction);
		
		return criteria.list();
	}
	
	public HistObra buscarHistoricoObra(Long idHistObra){
		return em.find(HistObra.class, idHistObra);
	}
	
	@Transactional
	public void actualizarHistoricoObra(HistObra historico){
		if(historico == null)
			return;
		
		em.merge(historico);
	}	
	
}
