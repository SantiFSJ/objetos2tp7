package ar.unrn.tp7.accesos;

import ar.unrn.tp7.modelo.Observer;

public class ObserverConsola implements Observer {

	@Override
	public void actualizar(String temperatura) {
		int temperaturaValor = Integer.valueOf(temperatura.);
		System.out.println(temperaturaValor);
		if (temperaturaValor < 12)
			System.out.println("Hace frio, se encendera la Caldera");
		else if (temperaturaValor > 17)
			System.out.println("Hace calor, se encender� el aire acondicionado");

	}

}
