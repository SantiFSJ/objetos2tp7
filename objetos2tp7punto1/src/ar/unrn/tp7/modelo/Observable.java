package ar.unrn.tp7.modelo;

import java.util.List;

public abstract class Observable {

	private List<Observer> observadores;

	public Observable(List<Observer> observadores) {
		this.observadores = observadores;
	}

	protected void notificar(String temperatura) {
		for (Observer o : observadores) {
			o.actualizar(temperatura);
		}
	}

}
