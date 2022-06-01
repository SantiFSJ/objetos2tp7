package ar.unrn.parcial.accesos;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;

import ar.unrn.parcial.modelo.RepositorioVentas;

public class StubEnDiscoRegistroDeVenta implements RepositorioVentas {

	String mensajeArchivado;

	@Override
	public void archivar(LocalDateTime fechaVenta, int cantidad, Double montoTotal)
			throws FileNotFoundException, IOException {
		mensajeArchivado = " Fecha de Venta: " + fechaVenta.getDayOfMonth() + "/" + fechaVenta.getMonthValue() + "/"
				+ fechaVenta.getYear() + " Cantidad de Remeras: " + cantidad + " Monto Total: " + montoTotal;
	}

	public String mensajeArchivado() {
		return mensajeArchivado;
	}

}
