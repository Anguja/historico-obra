package py.com.anguja.historico_obra.persistence;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import py.com.anguja.historico_obra.model.Cliente;

@ApplicationScoped //se comporta como un singleton
public class ClienteDAO {

	@Inject
	private EntityManager em;
	
	public Cliente buscarCliente(Long idCliente){
		return em.find(Cliente.class, idCliente);
	}
	
	@Transactional
	public void crearCliente(Cliente cliente){
		em.persist(cliente);
	}
}
