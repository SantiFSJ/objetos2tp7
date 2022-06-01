package ar.unrn.parcial.modelo;

import java.time.LocalDateTime;

public class RemeraLisa extends Remera {

	public RemeraLisa(double precio, String descripcion) {
		super(precio, descripcion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Double calcularPrecio(LocalDateTime fechaYHora) {
		if (fechaYHora.getHour() >= 8 && fechaYHora.getHour() <= 10)
			return (this.precio - ((this.precio / 100) * 5));
		return this.precio;
	}

}
