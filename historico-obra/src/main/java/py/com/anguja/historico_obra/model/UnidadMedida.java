package py.com.anguja.historico_obra.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the unidad_medida database table.
 * 
 */
@Entity
@Table(name="unidad_medida")
@NamedQuery(name="UnidadMedida.findAll", query="SELECT u FROM UnidadMedida u")
public class UnidadMedida implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="UNIDAD_MEDIDA_IDUNIDADMEDIDA_GENERATOR", sequenceName="UNIDAD_MEDIDA_ID_UNIDAD_MEDIDA_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UNIDAD_MEDIDA_IDUNIDADMEDIDA_GENERATOR")
	@Column(name="id_unidad_medida")
	private Long idUnidadMedida;

	@Column(name="descripcion_unidad_medida")
	private String descripcionUnidadMedida;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_actualizacion")
	private Date fechaActualizacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_registro")
	private Date fechaRegistro;

	//bi-directional many-to-one association to ObraTarea
	@OneToMany(mappedBy="unidadMedida")
	private List<ObraTarea> obraTareas;

	public UnidadMedida() {
	}

	public Long getIdUnidadMedida() {
		return this.idUnidadMedida;
	}

	public void setIdUnidadMedida(Long idUnidadMedida) {
		this.idUnidadMedida = idUnidadMedida;
	}

	public String getDescripcionUnidadMedida() {
		return this.descripcionUnidadMedida;
	}

	public void setDescripcionUnidadMedida(String descripcionUnidadMedida) {
		this.descripcionUnidadMedida = descripcionUnidadMedida;
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
		obraTarea.setUnidadMedida(this);

		return obraTarea;
	}

	public ObraTarea removeObraTarea(ObraTarea obraTarea) {
		getObraTareas().remove(obraTarea);
		obraTarea.setUnidadMedida(null);

		return obraTarea;
	}

}