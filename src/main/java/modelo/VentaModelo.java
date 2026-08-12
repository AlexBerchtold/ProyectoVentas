package modelo;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity(name = "tb_ventas")
public class VentaModelo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private LocalDateTime fecha;
	
	@Column(nullable = false)
	private Double total;
	
	@Column
	private LocalDateTime fechaRegistro;
	
	@Column
	private Boolean anulada;
	
	@Column(columnDefinition = "TEXT")
	private String observacion;
	
	// === Muchos a Uno
	
	@ManyToOne
	private ClienteModelo cliente;
	
	// Uno a Muchos
	
	@OneToMany(mappedBy = "venta", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<DetalleVentaModelo> detalles;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public LocalDateTime getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(LocalDateTime fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Boolean getAnulada() {
		return anulada;
	}

	public void setAnulada(Boolean anulada) {
		this.anulada = anulada;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public ClienteModelo getCliente() {
		return cliente;
	}

	public void setCliente(ClienteModelo cliente) {
		this.cliente = cliente;
	}

	public List<DetalleVentaModelo> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalleVentaModelo> detalles) {
		this.detalles = detalles;
	}

}
