package py.com.anguja.historico_obra.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import py.com.anguja.historico_obra.model.ObraTarea;
import py.com.anguja.historico_obra.persistence.ObraTareaDAO;

/**
 * @author lucio 
 * RequestScoped vive durante la peticion
 * 
 * */

@RequestScoped
public class ObraTareaBC {

	@Inject
	private ObraTareaDAO obraTareaDao;
	
	public void crearObraTarea(ObraTarea obraTarea){
		obraTareaDao.crearObraTarea(obraTarea);
	}
	
	public void eliminarObraTarea(Long idObraTarea){
		obraTareaDao.eliminarObraTarea(idObraTarea);
	}
	
	public void actualizarObraTarea(ObraTarea obraTarea){
		obraTareaDao.actualizarObraTarea(obraTarea);
	}
	
	public ObraTarea buscarObraTarea(Long idObraTarea){
		return obraTareaDao.buscarObraTarea(idObraTarea);
	}
}
