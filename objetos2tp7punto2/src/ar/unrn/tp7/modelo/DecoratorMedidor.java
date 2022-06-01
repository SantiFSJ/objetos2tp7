package ar.unrn.tp7.modelo;

import java.util.List;

public class DecoratorMedidor extends Observable implements GestorMedidor {
	private GestorMedidor medidor;

	public DecoratorMedidor(List<Observer> observadores, GestorMedidor medidor) {
		super(observadores);
		this.medidor = medidor;
	}

	@Override
	public String leerTemperatura() {
		// leo la temperatura del servicio web
		String temperatura = medidor.leerTemperatura();
		super.notificar(temperatura);
		return temperatura;
	}

}
