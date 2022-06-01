package ar.unrn.parcial.modelo;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.mail.MessagingException;

public interface SistemaVentas {
	void generarVenta(SistemaFechas sistFechas, RepositorioVentas repoVentas, int cantidad, Remera remera, String email)
			throws MessagingException, FileNotFoundException, IOException;

	Double consultarMontoVenta(SistemaFechas sistFecha, int cantidad, Remera tipoRemera, String email)
			throws IOException;
}
