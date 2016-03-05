package py.com.anguja.historico_obra.dto;

import java.util.List;

import py.com.anguja.historico_obra.model.Usuario;

/**
 * Clase concreta que extiende de la clase AbstractDTO
 * 
 * @author María José González
 *
 */
public class UsuarioDTO extends AbstractDTO<Usuario> {

	private int pageSize;

	private int totalNumberOfPages;

	private int estado;

	private List<Usuario> lista;

	@Override
	public int getTotalNumberOfPages() {
		// TODO Auto-generated method stub
		return this.totalNumberOfPages;
	}

	@Override
	public void setTotalNumberOfPages(int totalNumberOfPages) {
		// TODO Auto-generated method stub
		this.totalNumberOfPages = totalNumberOfPages;
	}

	@Override
	public int getEstado() {
		// TODO Auto-generated method stub
		return this.estado;
	}

	@Override
	public void setEstado(int estado) {
		// TODO Auto-generated method stub
		this.estado = estado;
	}

	@Override
	public int getPageSize() {
		// TODO Auto-generated method stub
		return this.pageSize;
	}

	@Override
	public void setPageSize(int pageSize) {
		// TODO Auto-generated method stub
		this.pageSize = pageSize;
	}

	@Override
	public List<Usuario> getLista() {
		// TODO Auto-generated method stub
		return this.lista;
	}

	@Override
	public void setLista(List<Usuario> lista) {
		// TODO Auto-generated method stub
		this.lista = lista;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UsuarioDTO [pageSize=");
		builder.append(pageSize);
		builder.append(", totalNumberOfPages=");
		builder.append(totalNumberOfPages);
		builder.append(", estado=");
		builder.append(estado);
		builder.append("]");
		return builder.toString();
	}

}
