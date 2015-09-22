package py.com.anguja.historico_obra.controller;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import py.com.anguja.historico_obra.model.HistObra;
import py.com.anguja.historico_obra.persistence.HistoricoObraDAO;

/**
 * @author lucio 
 * RequestScoped vive durante la peticion
 * 
 * */

@RequestScoped
public class HistoricoObraBC {

	@Inject
	private HistoricoObraDAO historicoDao;
	
	public void crearHistoricoObra(HistObra historico){
		historicoDao.crearHistoricoObra(historico);
	}
	
	public List<HistObra> buscarHistoricoObra(HistObra historico){
		return historicoDao.buscarHistoricoObra(historico);
	}
	
	public HistObra buscarHistoricoObra(Long idHistObra){
		return historicoDao.buscarHistoricoObra(idHistObra);
	}
}
