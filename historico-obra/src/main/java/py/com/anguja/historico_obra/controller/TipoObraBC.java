package py.com.anguja.historico_obra.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import py.com.anguja.historico_obra.dto.Respuesta;
import py.com.anguja.historico_obra.model.TipoObra;
import py.com.anguja.historico_obra.model.Usuario;
import py.com.anguja.historico_obra.persistence.TipoObraDAO;

@RequestScoped
public class TipoObraBC {

	@Inject
	private TipoObraDAO tipoObraDAO;

	public TipoObra buscarTipoObra(Long idTipoObra) {
		return this.tipoObraDAO.buscarTipoObra(idTipoObra);
	}

	public Respuesta crearTipoObra(TipoObra tipoObra) {	
		TipoObra tp = this.tipoObraDAO.buscarTipoObra(tipoObra.getDescripcionTipoObra());

		if (tp != null) {
			return new Respuesta("Descripcion para Tipo Obra ya existe", false);
		}
		
		this.tipoObraDAO.crearTipoObra(tipoObra);
		
		return new Respuesta("Tipo Obra creado", true);
	}

	public void actualizarTipoObra(TipoObra tipoObra) {
		this.tipoObraDAO.actualizarTipoObra(tipoObra);
	}

	public void eliminarTipoObra(Long idTipoObra) {
		this.tipoObraDAO.eliminarTipoObra(idTipoObra);
	}
}
