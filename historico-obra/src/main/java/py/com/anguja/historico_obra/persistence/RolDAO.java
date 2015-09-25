package py.com.anguja.historico_obra.persistence;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import py.com.anguja.historico_obra.model.Rol;

@ApplicationScoped
public class RolDAO {
	
	@Inject
	private EntityManager em;
	
	public Rol buscarRol(Long idRol){
		return em.find(Rol.class, idRol);
	}
	
	@Transactional
	public void crearRol(Rol rol) {
		em.persist(rol);
	}
	
	@Transactional
	public void actualizarRol(Rol rol) {
		em.merge(rol);
	}
	
	@Transactional
	public void eliminarRol(Long idRol) {
		em.remove(idRol);
	}

}
