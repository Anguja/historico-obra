package py.com.anguja.historico_obra.controller;

import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import py.com.anguja.historico_obra.dto.Respuesta;
import py.com.anguja.historico_obra.model.TipoObra;
import py.com.anguja.historico_obra.model.TipoTarea;
import py.com.anguja.historico_obra.persistence.TipoTareaDAO;

@RequestScoped
public class TipoTareaBC {
	
	@Inject
	private TipoTareaDAO tipoTareaDAO;

	public TipoTarea buscarTipoTarea(Long idTipoTarea) {
		return this.tipoTareaDAO.buscarTipoTarea(idTipoTarea);
	}

	public Respuesta crearTipoTarea(TipoTarea tipoTarea) {
		TipoTarea tt = this.tipoTareaDAO.buscarTipoTarea(tipoTarea.getDescripcionTipoTarea());

		if (tt != null) {
			return new Respuesta("Descripcion para Tipo Tarea ya existe", false);
		}
		
		tipoTarea.setFechaRegistro(new Date());
		tipoTarea.setFechaRegistro(new Date());
		this.tipoTareaDAO.crearTipoTarea(tipoTarea);
		
		return new Respuesta("Tipo Obra creado", true);
	}

	public void actualizarTipoTarea(TipoTarea tipoTarea) {
		this.tipoTareaDAO.actualizarTipoTarea(tipoTarea);
	}

	public void eliminarTipoTarea(Long idTipoTarea) {
		this.tipoTareaDAO.eliminarTipoTarea(idTipoTarea);
	}

}
