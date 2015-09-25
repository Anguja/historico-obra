package py.com.anguja.historico_obra.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;




import py.com.anguja.historico_obra.model.UnidadMedida;
import py.com.anguja.historico_obra.model.Usuario;
import py.com.anguja.historico_obra.persistence.UnidadMedidaDAO;

@RequestScoped

public class UnidadMedidaBC {
	
	@Inject
	
	private UnidadMedidaDAO unidadMedidaDAO;
	
	public UnidadMedida buscarUnidadMedida(Integer idUnidadMedida) {
		return this.unidadMedidaDAO.buscarUnidadMedida(idUnidadMedida);
		 
	}
	
	public void crearUnidadMedida(UnidadMedida unidadMedida){
		this.unidadMedidaDAO.crearUnidadMedida(unidadMedida);
		
	}
	
	public void actualizarUnidadMedida(UnidadMedida unidadMedida){
		this.unidadMedidaDAO.actualizarUnidadMedida(unidadMedida);
		
	}
	
	
	public void eliminarUnidadMedida(Long idUnidadMedida){
		this.unidadMedidaDAO.eliminarUnidadMedida(idUnidadMedida);
		
	}
	

}
