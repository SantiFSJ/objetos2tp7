package ar.unrn.parcial.modelo;

import java.time.LocalDateTime;

public abstract class Remera {
	protected double precio;
	private String descripcion;

	public Remera(double d, String descripcion) {
		this.precio = d;
		this.descripcion = descripcion;
	}

	public String descripcion() {
		return descripcion;
	}

	public Double calcularPrecio(LocalDateTime fechaYHora) {
		return 0.0;
	}

	public Boolean evaluarDescuento(LocalDateTime fechaYHora) {
		return false;
	}

}
