package ar.unrn.parcial.main;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import ar.unrn.parcial.accesos.EnDiscoRegistroDeVentaConComa;
import ar.unrn.parcial.emailServices.ObserverVentasEmailSender;
import ar.unrn.parcial.modelo.DateManager;
import ar.unrn.parcial.modelo.Remera;
import ar.unrn.parcial.modelo.RemeraEstampada;
import ar.unrn.parcial.modelo.RemeraLisa;
import ar.unrn.parcial.modelo.Ventas;
import ar.unrn.parcial.ui.RealizarCompra;

public class MainConComa {
	public static void main(String[] args) {
		ArrayList<Remera> remeras = new ArrayList<Remera>();

		RemeraEstampada remEst = new RemeraEstampada(2500.0, "Remera Estampada");
		RemeraLisa remLisa = new RemeraLisa(2000, "Remera Lisa");

		remeras.add(remLisa);
		remeras.add(remEst);

		EnDiscoRegistroDeVentaConComa registroVenta = new EnDiscoRegistroDeVentaConComa();

		ObserverVentasEmailSender observador = new ObserverVentasEmailSender();

		Ventas sistVentas = new Ventas(List.of(observador));

		DateManager adminFecha = new DateManager(LocalDateTime.now());

		RealizarCompra ui = new RealizarCompra(sistVentas, adminFecha, registroVenta, remeras);

	}
}
