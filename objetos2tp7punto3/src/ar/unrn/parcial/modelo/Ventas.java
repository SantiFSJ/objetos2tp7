package ar.unrn.parcial.modelo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;

public class Ventas extends Observable implements SistemaVentas {

	public Ventas(List<Observer> observadores) {
		super(observadores);
	}

	@Override
	public void generarVenta(SistemaFechas sistFecha, RepositorioVentas repoVentas, int cantidad, Remera tipoRemera,
			String email) throws MessagingException, FileNotFoundException, IOException {

		Venta venta = new Venta(cantidad, tipoRemera, new Email(email), sistFecha.obtenerFecha());

		repoVentas.archivar(sistFecha.obtenerFecha(), cantidad, venta.montoTotal());

		this.notificar(email, cantidad, tipoRemera.descripcion(), venta.montoTotal(), sistFecha.obtenerFecha());
	}

	@Override
	public Double consultarMontoVenta(SistemaFechas sistFecha, int cantidad, Remera tipoRemera, String email)
			throws IOException {

		Venta venta = new Venta(cantidad, tipoRemera, new Email(email), sistFecha.obtenerFecha());

		return venta.montoTotal();
	}

}
