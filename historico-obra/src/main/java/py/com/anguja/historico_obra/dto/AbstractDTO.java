package py.com.anguja.historico_obra.dto;

import java.util.List;

public abstract class AbstractDTO<T> {


	public abstract int getTotalNumberOfPages();

	public abstract void setTotalNumberOfPages(int totalNumberOfPages);

	public abstract int getEstado();

	public abstract void setEstado(int estado);

	public abstract int getPageSize();

	public abstract void setPageSize(int pageSize);

	public abstract List<T> getLista();

	public abstract void setLista(List<T> lista);

}
