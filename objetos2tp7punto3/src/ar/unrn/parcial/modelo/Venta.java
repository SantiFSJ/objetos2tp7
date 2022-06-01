package ar.unrn.parcial.modelo;

import java.io.IOException;
import java.time.LocalDateTime;

public class Venta {
	private int cantidadRemeras;
	private Remera remera;
	private Email email;
	private LocalDateTime fechaVenta;
	private Double montoTotal;

	public Venta(int cantidad, Remera remera, Email email, LocalDateTime fechaVenta) throws IOException {
		validar(cantidad);
		this.cantidadRemeras = cantidad;
		this.remera = remera;
		this.email = email;
		this.fechaVenta = fechaVenta;
		montoTotal = calcularMontoTotal();
	}

	private void validar(int cantidad) throws IOException {
		if ("".equals(cantidad))
			throw new IOException("La Cantidad de Remeras no puede estar Vacia");
		if (cantidad <= 0)
			throw new IOException("La Cantidad de Remeras no puede ser Menor a 1");
	}

	private Double calcularMontoTotal() {
		Double sumaMonto = 0.0;
		for (int i = 0; i < this.cantidadRemeras; i++) {
			sumaMonto += remera.calcularPrecio(fechaVenta);
		}
		if (this.cantidadRemeras > 3 && remera.evaluarDescuento(fechaVenta))
			sumaMonto = sumaMonto - (sumaMonto / 100) * 12;
		return sumaMonto;
	}

	public Double montoTotal() {
		return this.montoTotal;
	}

}
