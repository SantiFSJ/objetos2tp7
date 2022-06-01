package ar.unrn.parcial.modelo;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;

public class RemeraEstampada extends Remera {

	public RemeraEstampada(double d, String descripcion) {
		super(d, descripcion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Double calcularPrecio(LocalDateTime fechaYHora) {
		if (fechaYHora.get(ChronoField.DAY_OF_WEEK) == 7)
			return this.precio - ((this.precio / 100) * 10);
		return this.precio;
	}

	@Override
	public Boolean evaluarDescuento(LocalDateTime fechaYHora) {
		if (fechaYHora.get(ChronoField.DAY_OF_WEEK) == 6)
			return true;
		return false;
	}

}
