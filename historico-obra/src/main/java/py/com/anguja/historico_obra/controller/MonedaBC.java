package py.com.anguja.historico_obra.controller;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import py.com.anguja.historico_obra.dto.Respuesta;
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
	
	public Respuesta crearMoneda(Moneda moneda){
		Respuesta respuesta = new Respuesta();
		
		monedaDAO.crearMoneda(moneda);
		respuesta.setSuccess(true);
		respuesta.setMessage("Moneda creada.");

		return respuesta;
	}
	
	public Respuesta eliminarMoneda(Long idMoneda){
		Respuesta respuesta = new Respuesta();
		monedaDAO.eliminarMoneda(idMoneda);
		
		respuesta.setSuccess(true);
		respuesta.setMessage("Moneda eliminada");
		
		return respuesta;
	}
	
	public Moneda buscarMoneda(Long idMoneda){
		return monedaDAO.buscarMoneda(idMoneda);
	}
	
	public Respuesta actualizarMoneda(Moneda moneda){
		Respuesta respuesta = new Respuesta();
		monedaDAO.actualizarMoneda(moneda);
		
		respuesta.setSuccess(true);
		respuesta.setMessage("Moneda Acutalizada");

		return respuesta;
	}
	
	public List<Moneda> listarMonedas(){
		return monedaDAO.listarMoneda();
	}
	
}
