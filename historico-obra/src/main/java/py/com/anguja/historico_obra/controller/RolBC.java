package py.com.anguja.historico_obra.controler;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import py.com.anguja.historico_obra.model.Rol;
import py.com.anguja.historico_obra.persistence.RolDAO;

@RequestScoped
public class RolBC {

	@Inject
	private RolDAO rolDAO;

	public Rol buscarRol(Long idRol) {
		return this.rolDAO.buscarRol(idRol);
	}

	public void crearRol(Rol rol) {
		this.rolDAO.crearRol(rol);
	}

	public void actualizarRol(Rol rol) {
		this.rolDAO.actualizarRol(rol);
	}

	public void eliminarRol(Long idRol) {
		this.rolDAO.eliminarRol(idRol);
	}
}
