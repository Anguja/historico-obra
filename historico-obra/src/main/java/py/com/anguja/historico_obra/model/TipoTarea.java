package py.com.anguja.historico_obra.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tipo_tarea database table.
 * 
 */
@Entity
@Table(name="tipo_tarea")
@NamedQuery(name="TipoTarea.findAll", query="SELECT t FROM TipoTarea t")
public class TipoTarea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TIPO_TAREA_IDTIPOTAREA_GENERATOR", sequenceName="TIPO_TAREA_ID_TIPO_TAREA_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TIPO_TAREA_IDTIPOTAREA_GENERATOR")
	@Column(name="id_tipo_tarea")
	private Long idTipoTarea;

	@Column(name="descripcion_tipo_tarea")
	private String descripcionTipoTarea;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_actualizacion")
	private Date fechaActualizacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_registro")
	private Date fechaRegistro;

	//bi-directional many-to-one association to ObraTarea
	@OneToMany(mappedBy="tipoTarea")
	private List<ObraTarea> obraTareas;

	public TipoTarea() {
	}

	public Long getIdTipoTarea() {
		return this.idTipoTarea;
	}

	public void setIdTipoTarea(Long idTipoTarea) {
		this.idTipoTarea = idTipoTarea;
	}

	public String getDescripcionTipoTarea() {
		return this.descripcionTipoTarea;
	}

	public void setDescripcionTipoTarea(String descripcionTipoTarea) {
		this.descripcionTipoTarea = descripcionTipoTarea;
	}

	public Date getFechaActualizacion() {
		return this.fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public List<ObraTarea> getObraTareas() {
		return this.obraTareas;
	}

	public void setObraTareas(List<ObraTarea> obraTareas) {
		this.obraTareas = obraTareas;
	}

	public ObraTarea addObraTarea(ObraTarea obraTarea) {
		getObraTareas().add(obraTarea);
		obraTarea.setTipoTarea(this);

		return obraTarea;
	}

	public ObraTarea removeObraTarea(ObraTarea obraTarea) {
		getObraTareas().remove(obraTarea);
		obraTarea.setTipoTarea(null);

		return obraTarea;
	}

}