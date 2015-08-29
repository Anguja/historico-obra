package py.com.anguja.historico_obra.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CLIENTE_IDCLIENTE_GENERATOR", sequenceName="CLIENTE_ID_CLIENTE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CLIENTE_IDCLIENTE_GENERATOR")
	@Column(name="id_cliente")
	private Long idCliente;

	private String celular;

	@Column(name="ci_ruc")
	private String ciRuc;

	private String contacto;

	private String direccion;

	private String dv;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_actualizacion")
	private Date fechaActualizacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_registro")
	private Date fechaRegistro;

	@Column(name="nombre_razon")
	private String nombreRazon;

	private String telefono;

	@Column(name="telefono_contacto")
	private String telefonoContacto;

	//bi-directional many-to-one association to HistObra
	@OneToMany(mappedBy="cliente")
	private List<HistObra> histObras;

	public Cliente() {
	}

	public Long getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getCelular() {
		return this.celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCiRuc() {
		return this.ciRuc;
	}

	public void setCiRuc(String ciRuc) {
		this.ciRuc = ciRuc;
	}

	public String getContacto() {
		return this.contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDv() {
		return this.dv;
	}

	public void setDv(String dv) {
		this.dv = dv;
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

	public String getNombreRazon() {
		return this.nombreRazon;
	}

	public void setNombreRazon(String nombreRazon) {
		this.nombreRazon = nombreRazon;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getTelefonoContacto() {
		return this.telefonoContacto;
	}

	public void setTelefonoContacto(String telefonoContacto) {
		this.telefonoContacto = telefonoContacto;
	}

	public List<HistObra> getHistObras() {
		return this.histObras;
	}

	public void setHistObras(List<HistObra> histObras) {
		this.histObras = histObras;
	}

	public HistObra addHistObra(HistObra histObra) {
		getHistObras().add(histObra);
		histObra.setCliente(this);

		return histObra;
	}

	public HistObra removeHistObra(HistObra histObra) {
		getHistObras().remove(histObra);
		histObra.setCliente(null);

		return histObra;
	}

}