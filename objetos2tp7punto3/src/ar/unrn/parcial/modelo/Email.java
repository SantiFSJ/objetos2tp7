package ar.unrn.parcial.modelo;

import java.io.IOException;

public class Email {
	private String email;

	public Email(String email) throws IOException {
		validar(email);
		this.email = email;
	}

	private void validar(String email) throws IOException {
		if (email.equals(""))
			throw new IOException("Debe Cargar Un Email");

		if (!validarEmail(email))
			throw new IOException("El Email debe ser válido");
	}

	private boolean validarEmail(String email) {
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		return email.matches(regex);
	}

	public String email() {
		return this.email;
	}

}
