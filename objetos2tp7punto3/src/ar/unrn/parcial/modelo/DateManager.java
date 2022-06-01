package ar.unrn.parcial.modelo;

import java.time.LocalDateTime;

public class DateManager implements SistemaFechas {
	private LocalDateTime fecha;

	public DateManager(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	@Override
	public LocalDateTime obtenerFecha() {
		return fecha;
	}
}
