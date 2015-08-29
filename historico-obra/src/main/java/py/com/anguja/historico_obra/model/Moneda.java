package py.com.anguja.historico_obra.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the moneda database table.
 * 
 */
@Entity
@NamedQuery(name="Moneda.findAll", query="SELECT m FROM Moneda m")
public class Moneda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MONEDA_IDMONEDA_GENERATOR", sequenceName="MONEDA_ID_MONEDA_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MONEDA_IDMONEDA_GENERATOR")
	@Column(name="id_moneda")
	private Long idMoneda;

	private Double cotizacion;

	@Column(name="descripcion_moneda")
	private String descripcionMoneda;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_actualizacion")
	private Date fechaActualizacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_registro")
	private Date fechaRegistro;

	//bi-directional many-to-one association to HistObra
	@ManyToOne
	@JoinColumn(name="id_hist_obra")
	private HistObra histObra;

	public Moneda() {
	}

	public Long getIdMoneda() {
		return this.idMoneda;
	}

	public void setIdMoneda(Long idMoneda) {
		this.idMoneda = idMoneda;
	}

	public Double getCotizacion() {
		return this.cotizacion;
	}

	public void setCotizacion(Double cotizacion) {
		this.cotizacion = cotizacion;
	}

	public String getDescripcionMoneda() {
		return this.descripcionMoneda;
	}

	public void setDescripcionMoneda(String descripcionMoneda) {
		this.descripcionMoneda = descripcionMoneda;
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

	public HistObra getHistObra() {
		return this.histObra;
	}

	public void setHistObra(HistObra histObra) {
		this.histObra = histObra;
	}

}