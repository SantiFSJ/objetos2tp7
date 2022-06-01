package ar.unrn.parcial.modelo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;

public interface RepositorioVentas {
	void archivar(LocalDateTime fechaVenta, int cantidad, Double montoTotal) throws FileNotFoundException, IOException;

}
