package py.com.anguja.historico_obra.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import py.com.anguja.historico_obra.model.TipoObra;
import py.com.anguja.historico_obra.persistence.TipoObraDAO;

@RequestScoped
public class TipoObraBC {

	@Inject
	private TipoObraDAO tipoObraDAO;

	public TipoObra buscarTipoObra(Long idTipoObra) {
		return this.tipoObraDAO.buscarTipoObra(idTipoObra);
	}

	public void crearTipoObra(TipoObra tipoObra) {
		this.tipoObraDAO.crearTipoObra(tipoObra);
	}

	public void actualizarTipoObra(TipoObra tipoObra) {
		this.tipoObraDAO.actualizarTipoObra(tipoObra);
	}

	public void eliminarTipoObra(Long idTipoObra) {
		this.tipoObraDAO.eliminarTipoObra(idTipoObra);
	}
}
