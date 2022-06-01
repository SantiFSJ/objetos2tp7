package ar.unrn.tp7.main;

import java.util.List;

import ar.unrn.tp7.accesos.ObserverArchivo;
import ar.unrn.tp7.accesos.ObserverConsola;
import ar.unrn.tp7.modelo.ClimaOnline;
import ar.unrn.tp7.modelo.DecoratorMedidor;
import ar.unrn.tp7.modelo.Medidor;
import ar.unrn.tp7.modelo.WeatherChannelService;

public class Main {
	public static void main(String[] args) {
		System.out.println("Main con el Decorator");
		ClimaOnline weatherService = new WeatherChannelService();

		ObserverArchivo fileObserver = new ObserverArchivo();
		ObserverConsola consoleObserver = new ObserverConsola();

		DecoratorMedidor medidor = new DecoratorMedidor(List.of(fileObserver, consoleObserver),
				new Medidor(weatherService));

		medidor.leerTemperatura();
		medidor.leerTemperatura();
		medidor.leerTemperatura();
		medidor.leerTemperatura();
		medidor.leerTemperatura();
		medidor.leerTemperatura();

	}

}
