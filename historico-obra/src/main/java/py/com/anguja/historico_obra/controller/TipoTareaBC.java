package py.com.anguja.historico_obra.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import py.com.anguja.historico_obra.model.TipoTarea;
import py.com.anguja.historico_obra.persistence.TipoTareaDAO;

@RequestScoped
public class TipoTareaBC {
	
	@Inject
	private TipoTareaDAO tipoTareaDAO;

	public TipoTarea buscarTipoTarea(Long idTipoTarea) {
		return this.tipoTareaDAO.buscarTipoTarea(idTipoTarea);
	}

	public void crearTipoTarea(TipoTarea tipoTarea) {
		this.tipoTareaDAO.crearTipoTarea(tipoTarea);
	}

	public void actualizarTipoTarea(TipoTarea tipoTarea) {
		this.tipoTareaDAO.actualizarTipoTarea(tipoTarea);
	}

	public void eliminarTipoTarea(Long idTipoTarea) {
		this.tipoTareaDAO.eliminarTipoTarea(idTipoTarea);
	}

}
