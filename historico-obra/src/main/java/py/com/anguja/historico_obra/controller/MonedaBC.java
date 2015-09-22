package py.com.anguja.historico_obra.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import py.com.anguja.historico_obra.model.Moneda;
import py.com.anguja.historico_obra.persistence.MonedaDAO;

/**
 * @author lucio 
 * RequestScoped vive durante la peticion
 * 
 * */

@RequestScoped
public class MonedaBC {

	@Inject
	private MonedaDAO monedaDAO;
	
	public void crearMoneda(Moneda moneda){
		monedaDAO.crearMoneda(moneda);
	}
	
	public void elimnarMoneda(Long idMoneda){
		monedaDAO.eliminarMoneda(idMoneda);
	}
	
	public Moneda buscarMoneda(Long idMoneda){
		return monedaDAO.buscarMoneda(idMoneda);
	}
	
	public void actualizarMoneda(Moneda moneda){
		monedaDAO.actualizarMoneda(moneda);
	}
	
}
