package py.com.anguja.historico_obra.model;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.util.Date;


/**
 * The persistent class for the tipo_obra database table.
 * 
 */

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_EMPTY)
@Table(name="tipo_obra")
@NamedQuery(name="TipoObra.findAll", query="SELECT t FROM TipoObra t")
public class TipoObra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TIPO_OBRA_IDTIPOOBRA_GENERATOR", sequenceName="TIPO_OBRA_ID_TIPO_OBRA_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TIPO_OBRA_IDTIPOOBRA_GENERATOR")
	@Column(name="id_tipo_obra")
	private Long idTipoObra;

	@Column(name="descripcion_tipo_obra")
	private String descripcionTipoObra;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_actualizacion")
	private Date fechaActualizacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_registro")
	private Date fechaRegistro;

	public TipoObra() {
	}

	public TipoObra(Long idTipoObra, String descripcionTipoObra) {
		super();
		this.idTipoObra = idTipoObra;
		this.descripcionTipoObra = descripcionTipoObra;
	}

	public TipoObra(String descripcionTipoObra) {
		super();
		this.descripcionTipoObra = descripcionTipoObra;
	}

	public TipoObra(Long idTipoObra, String descripcionTipoObra, Date fechaActualizacion, Date fechaRegistro) {
		super();
		this.idTipoObra = idTipoObra;
		this.descripcionTipoObra = descripcionTipoObra;
		this.fechaActualizacion = fechaActualizacion;
		this.fechaRegistro = fechaRegistro;
	}

	public Long getIdTipoObra() {
		return this.idTipoObra;
	}

	public void setIdTipoObra(Long idTipoObra) {
		this.idTipoObra = idTipoObra;
	}

	public String getDescripcionTipoObra() {
		return this.descripcionTipoObra;
	}

	public void setDescripcionTipoObra(String descripcionTipoObra) {
		this.descripcionTipoObra = descripcionTipoObra;
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

}