package ar.unrn.parcial.modelo;

import java.time.LocalDateTime;

import javax.mail.MessagingException;

public interface Observer {

	void actualizar(String email, int cantidad, String descripcion, Double montoTotal, LocalDateTime fecha)
			throws MessagingException;

}
