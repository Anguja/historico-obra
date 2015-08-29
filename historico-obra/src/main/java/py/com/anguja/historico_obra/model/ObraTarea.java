package py.com.anguja.historico_obra.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the obra_tarea database table.
 * 
 */
@Entity
@Table(name="obra_tarea")
@NamedQuery(name="ObraTarea.findAll", query="SELECT o FROM ObraTarea o")
public class ObraTarea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="OBRA_TAREA_IDOBRATAREA_GENERATOR", sequenceName="OBRA_TAREA_ID_OBRA_TAREA_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OBRA_TAREA_IDOBRATAREA_GENERATOR")
	@Column(name="id_obra_tarea")
	private Long idObraTarea;

	@Column(name="cantidad_ejecutada_contrato")
	private Double cantidadEjecutadaContrato;

	@Column(name="cantidad_ejecutada_real")
	private Double cantidadEjecutadaReal;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_actualizacion")
	private Date fechaActualizacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_registro")
	private Date fechaRegistro;

	@Column(name="grado_participacion")
	private Double gradoParticipacion;

	private String observacion;

	//bi-directional many-to-one association to HistObra
	@ManyToOne
	@JoinColumn(name="id_hist_obra")
	private HistObra histObra;

	//bi-directional many-to-one association to TipoTarea
	@ManyToOne
	@JoinColumn(name="id_tipo_tarea")
	private TipoTarea tipoTarea;

	//bi-directional many-to-one association to UnidadMedida
	@ManyToOne
	@JoinColumn(name="id_unidad_medida")
	private UnidadMedida unidadMedida;

	public ObraTarea() {
	}

	public Long getIdObraTarea() {
		return this.idObraTarea;
	}

	public void setIdObraTarea(Long idObraTarea) {
		this.idObraTarea = idObraTarea;
	}

	public Double getCantidadEjecutadaContrato() {
		return this.cantidadEjecutadaContrato;
	}

	public void setCantidadEjecutadaContrato(Double cantidadEjecutadaContrato) {
		this.cantidadEjecutadaContrato = cantidadEjecutadaContrato;
	}

	public Double getCantidadEjecutadaReal() {
		return this.cantidadEjecutadaReal;
	}

	public void setCantidadEjecutadaReal(Double cantidadEjecutadaReal) {
		this.cantidadEjecutadaReal = cantidadEjecutadaReal;
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

	public Double getGradoParticipacion() {
		return this.gradoParticipacion;
	}

	public void setGradoParticipacion(Double gradoParticipacion) {
		this.gradoParticipacion = gradoParticipacion;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public HistObra getHistObra() {
		return this.histObra;
	}

	public void setHistObra(HistObra histObra) {
		this.histObra = histObra;
	}

	public TipoTarea getTipoTarea() {
		return this.tipoTarea;
	}

	public void setTipoTarea(TipoTarea tipoTarea) {
		this.tipoTarea = tipoTarea;
	}

	public UnidadMedida getUnidadMedida() {
		return this.unidadMedida;
	}

	public void setUnidadMedida(UnidadMedida unidadMedida) {
		this.unidadMedida = unidadMedida;
	}

}