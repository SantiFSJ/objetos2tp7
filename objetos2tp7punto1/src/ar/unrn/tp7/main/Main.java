package ar.unrn.tp7.main;

import java.util.List;

import ar.unrn.tp7.accesos.ObserverArchivo;
import ar.unrn.tp7.accesos.ObserverConsola;
import ar.unrn.tp7.modelo.Medidor;
import ar.unrn.tp7.modelo.WeatherChannelService;

public class Main {
	public static void main(String[] args) {
		WeatherChannelService weatherService = new WeatherChannelService();

		ObserverArchivo fileObserver = new ObserverArchivo();
		ObserverConsola consoleObserver = new ObserverConsola();

		Medidor medidor = new Medidor(weatherService, List.of(fileObserver, consoleObserver));

		medidor.leerTemperatura();
		medidor.leerTemperatura();
		medidor.leerTemperatura();
		medidor.leerTemperatura();
		medidor.leerTemperatura();
		medidor.leerTemperatura();

	}

}
