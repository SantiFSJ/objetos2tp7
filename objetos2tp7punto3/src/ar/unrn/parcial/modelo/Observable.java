package ar.unrn.parcial.modelo;

import java.time.LocalDateTime;
import java.util.List;

import javax.mail.MessagingException;

public abstract class Observable {
	private List<Observer> observadores;

	public Observable(List<Observer> observadores) {
		this.observadores = observadores;
	}

	protected void notificar(String email, int cantidad, String descripcion, Double montoTotal, LocalDateTime fecha)
			throws MessagingException {
		for (Observer o : observadores) {
			o.actualizar(email, cantidad, descripcion, montoTotal, fecha);
		}
	}
}
