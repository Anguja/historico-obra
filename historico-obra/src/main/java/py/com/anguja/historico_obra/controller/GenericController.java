package py.com.anguja.historico_obra.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import py.com.anguja.historico_obra.dto.AbstractDTO;

/**
 * Clase abstracta creada para contener los métodos comunes de los
 * controladores.
 * 
 * @author Ricardo Ramírez.
 *
 * @param <T>
 */
public abstract class GenericController<T> {

	/**
	 * Método que convierte un entity a un entityDTO.
	 * 
	 * @param entityList
	 *            Lista de objetos de una determinadad entidad.
	 * 
	 * @param totalNumberOfRows
	 *            Cantidad de filas obtenidas en la consulta.
	 * 
	 * @param pageSize
	 *            Cantidad de filas por páginas.
	 * 
	 * 
	 * @param abstractDTO
	 *            Objeto de tipo {@link AbstractDTO<?>}
	 * 
	 * @return {@link AbstractDTO<?>}
	 */
	protected AbstractDTO<T> marshallDTO(List<T> entityList,
			int totalNumberOfRows, int pageSize, AbstractDTO<T> abstractDTO) {

		abstractDTO.setLista(entityList);
		abstractDTO.setPageSize(pageSize);
		abstractDTO.setTotalNumberOfPages(this.calcularCantidadPaginas(
				totalNumberOfRows, pageSize));

		return abstractDTO;
	}

	/**
	 * Método genérico utilizado para limpiar los filtros enviados desde el
	 * cliente.
	 * 
	 * @author Ricardo Ramírez
	 * 
	 * @param filtro
	 *            Cadena de texto a utilizar en la cláusula ILIKE.
	 * 
	 * @param argumentos
	 *            Columnas en la tabla por el cuál se realizará el filtro.
	 * 
	 * @return {@link Map}
	 */
	protected Map<String, String> parseFilters(String filtro,
			String... argumentos) {

		Map<String, String> filtros = new HashMap<String, String>();

		if (filtro != null && !filtro.isEmpty() && filtro.contains(":")) {

			String tmpFiltro = this.limpiarFiltro(filtro);
			List<String> listaColumnaFiltro = Arrays.asList(argumentos);
			Iterator<String> iterator = listaColumnaFiltro.iterator();

			while (iterator.hasNext()) {
				filtros.put(iterator.next(), tmpFiltro);
			}
		}

		return filtros;
	}

	/**
	 * Método que calcula la cantidad de páginas que debe contener el table; de
	 * acuerdo a la cantidad filas filtradas y la cantidad de elementos
	 * mostrados en una página.
	 * 
	 * @author Ricardo Ramírez
	 * 
	 * @param totalFilas
	 *            Cantidad de filas filtradas
	 * 
	 * @param cantidadFilasConfiguradas
	 *            Cantidad de filas mostradas en una página.
	 * 
	 * @return Cantidad de páginas.
	 */
	protected int calcularCantidadPaginas(int totalFilas,
			int cantidadFilasConfiguradas) {

		if (totalFilas <= cantidadFilasConfiguradas) {
			return 1;
		}

		if ((totalFilas % cantidadFilasConfiguradas) == 0) {

			return Math.abs(totalFilas / cantidadFilasConfiguradas);

		} else {
			return (Math.abs(totalFilas / cantidadFilasConfiguradas) + 1);
		}

	}

	/**
	 * Método que "limpia" el filtro enviado por el smart-table; debido a que el
	 * mismo envía con el siguiente formato {"$": "ejemplo"}
	 * 
	 * @param filtro
	 *            Con formato: {"$": "ejemplo"}
	 * 
	 * @return resultado del filtro: ejemplo
	 */
	protected String limpiarFiltro(String filtro) {
		String[] temp = filtro.split(":");
		int lenghtString = temp[1].length();
		String stringResult = temp[1].substring(1, (lenghtString - 2));
		return stringResult;
	}

}
