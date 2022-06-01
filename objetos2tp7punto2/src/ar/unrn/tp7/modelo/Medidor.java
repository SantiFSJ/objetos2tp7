package ar.unrn.tp7.modelo;

public class Medidor implements GestorMedidor {
	private String temperatura;
	private ClimaOnline clima;

	public Medidor(ClimaOnline clima) {
		this.clima = clima;

	}

	@Override
	public String leerTemperatura() {
		// leo la temperatura del servicio web
		this.temperatura = this.clima.temperatura();
		return this.temperatura;

	}

}
