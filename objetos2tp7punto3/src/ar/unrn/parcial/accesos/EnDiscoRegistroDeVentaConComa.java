package ar.unrn.parcial.accesos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

import ar.unrn.parcial.modelo.RepositorioVentas;

public class EnDiscoRegistroDeVentaConComa implements RepositorioVentas {

	@Override
	public void archivar(LocalDateTime fechaVenta, int cantidad, Double montoTotal)
			throws FileNotFoundException, IOException {
		File miArchivo = new File("RegistroDeVentas.txt");

		miArchivo.createNewFile();
		FileOutputStream oFile = new FileOutputStream(miArchivo, true);

		FileWriter myWriter = new FileWriter(miArchivo, true);
		myWriter.write(" Fecha de Venta: " + fechaVenta.getDayOfMonth() + "/" + fechaVenta.getMonthValue() + "/"
				+ fechaVenta.getYear() + "," + " Cantidad de Remeras: " + cantidad + "," + " Monto Total: " + montoTotal
				+ ",");
		myWriter.close();

	}

}
