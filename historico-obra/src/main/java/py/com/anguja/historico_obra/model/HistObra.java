package py.com.anguja.historico_obra.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the hist_obra database table.
 * 
 */
@Entity
@Table(name="hist_obra")
@NamedQuery(name="HistObra.findAll", query="SELECT h FROM HistObra h")
public class HistObra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HIST_OBRA_IDHISTOBRA_GENERATOR", sequenceName="HIST_OBRA_ID_HIST_OBRA_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HIST_OBRA_IDHISTOBRA_GENERATOR")
	@Column(name="id_hist_obra")
	private Long idHistObra;

	private Boolean activo;

	private String consorcio;

	@Column(name="descripcion_obra")
	private String descripcionObra;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_actualizacion")
	private Date fechaActualizacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_fin_contrato")
	private Date fechaFinContrato;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_fin_real")
	private Date fechaFinReal;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_inicio_contrato")
	private Date fechaInicioContrato;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_inicio_real")
	private Date fechaInicioReal;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_registro")
	private Date fechaRegistro;

	@Column(name="grado_participacion")
	private Double gradoParticipacion;

	@Column(name="id_tipo_obra")
	private Long idTipoObra;

	@Column(name="monto_contrato")
	private Double montoContrato;

	@Column(name="monto_real")
	private Double montoReal;

	private String nombre;

	private String observacion;

	@Column(name="plazo_contrato")
	private Integer plazoContrato;

	@Column(name="plazo_real")
	private Integer plazoReal;

	private String ubicacion;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente cliente;

	//bi-directional one-to-one association to HistObra
	@OneToOne
	@JoinColumn(name="id_hist_obra")
	private HistObra histObra1;

	//bi-directional one-to-one association to HistObra
	@OneToOne(mappedBy="histObra1")
	private HistObra histObra2;

	//bi-directional many-to-one association to Moneda
	@OneToMany(mappedBy="histObra")
	private List<Moneda> monedas;

	//bi-directional many-to-one association to ObraTarea
	@OneToMany(mappedBy="histObra")
	private List<ObraTarea> obraTareas;

	public HistObra() {
	}

	public Long getIdHistObra() {
		return this.idHistObra;
	}

	public void setIdHistObra(Long idHistObra) {
		this.idHistObra = idHistObra;
	}

	public Boolean getActivo() {
		return this.activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public String getConsorcio() {
		return this.consorcio;
	}

	public void setConsorcio(String consorcio) {
		this.consorcio = consorcio;
	}

	public String getDescripcionObra() {
		return this.descripcionObra;
	}

	public void setDescripcionObra(String descripcionObra) {
		this.descripcionObra = descripcionObra;
	}

	public Date getFechaActualizacion() {
		return this.fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public Date getFechaFinContrato() {
		return this.fechaFinContrato;
	}

	public void setFechaFinContrato(Date fechaFinContrato) {
		this.fechaFinContrato = fechaFinContrato;
	}

	public Date getFechaFinReal() {
		return this.fechaFinReal;
	}

	public void setFechaFinReal(Date fechaFinReal) {
		this.fechaFinReal = fechaFinReal;
	}

	public Date getFechaInicioContrato() {
		return this.fechaInicioContrato;
	}

	public void setFechaInicioContrato(Date fechaInicioContrato) {
		this.fechaInicioContrato = fechaInicioContrato;
	}

	public Date getFechaInicioReal() {
		return this.fechaInicioReal;
	}

	public void setFechaInicioReal(Date fechaInicioReal) {
		this.fechaInicioReal = fechaInicioReal;
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

	public Long getIdTipoObra() {
		return this.idTipoObra;
	}

	public void setIdTipoObra(Long idTipoObra) {
		this.idTipoObra = idTipoObra;
	}

	public Double getMontoContrato() {
		return this.montoContrato;
	}

	public void setMontoContrato(Double montoContrato) {
		this.montoContrato = montoContrato;
	}

	public Double getMontoReal() {
		return this.montoReal;
	}

	public void setMontoReal(Double montoReal) {
		this.montoReal = montoReal;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Integer getPlazoContrato() {
		return this.plazoContrato;
	}

	public void setPlazoContrato(Integer plazoContrato) {
		this.plazoContrato = plazoContrato;
	}

	public Integer getPlazoReal() {
		return this.plazoReal;
	}

	public void setPlazoReal(Integer plazoReal) {
		this.plazoReal = plazoReal;
	}

	public String getUbicacion() {
		return this.ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public HistObra getHistObra1() {
		return this.histObra1;
	}

	public void setHistObra1(HistObra histObra1) {
		this.histObra1 = histObra1;
	}

	public HistObra getHistObra2() {
		return this.histObra2;
	}

	public void setHistObra2(HistObra histObra2) {
		this.histObra2 = histObra2;
	}

	public List<Moneda> getMonedas() {
		return this.monedas;
	}

	public void setMonedas(List<Moneda> monedas) {
		this.monedas = monedas;
	}

	public Moneda addMoneda(Moneda moneda) {
		getMonedas().add(moneda);
		moneda.setHistObra(this);

		return moneda;
	}

	public Moneda removeMoneda(Moneda moneda) {
		getMonedas().remove(moneda);
		moneda.setHistObra(null);

		return moneda;
	}

	public List<ObraTarea> getObraTareas() {
		return this.obraTareas;
	}

	public void setObraTareas(List<ObraTarea> obraTareas) {
		this.obraTareas = obraTareas;
	}

	public ObraTarea addObraTarea(ObraTarea obraTarea) {
		getObraTareas().add(obraTarea);
		obraTarea.setHistObra(this);

		return obraTarea;
	}

	public ObraTarea removeObraTarea(ObraTarea obraTarea) {
		getObraTareas().remove(obraTarea);
		obraTarea.setHistObra(null);

		return obraTarea;
	}

}