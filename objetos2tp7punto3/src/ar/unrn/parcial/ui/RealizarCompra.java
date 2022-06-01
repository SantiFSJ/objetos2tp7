package ar.unrn.parcial.ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.mail.MessagingException;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import ar.unrn.parcial.modelo.Remera;
import ar.unrn.parcial.modelo.RepositorioVentas;
import ar.unrn.parcial.modelo.SistemaFechas;
import ar.unrn.parcial.modelo.SistemaVentas;

public class RealizarCompra {
	private JPanel contentPane;
	private JLabel lblCantidad;
	private JTextField txtCantidad;

	private JLabel lblEmail;
	private JTextField txtEmail;
	private JComboBox<String> comboBox;
	private JButton btnRealizarCompra;
	private JLabel lblRemeras;
	private JTextField textField;

	private SistemaVentas sistVentas;

	private RepositorioVentas repoVentas;

	private SistemaFechas sistFechas;

	private ArrayList<Remera> remeras;

	public RealizarCompra(SistemaVentas sistVentas, SistemaFechas sistFechas, RepositorioVentas repoVentas,
			ArrayList<Remera> listaRemeras) {
		this.sistFechas = sistFechas;
		this.sistVentas = sistVentas;
		this.repoVentas = repoVentas;

		this.remeras = listaRemeras;

		var frame = new JFrame("Realizar Compra");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 453, 251);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		formElements();
		layout();
		frame.setVisible(true);
	}

	private void formElements() {
		lblCantidad = new JLabel("Cantidad:");
		txtCantidad = new JTextField();
		txtCantidad.setColumns(10);

		lblEmail = new JLabel("Email:");
		txtEmail = new JTextField();
		txtEmail.setColumns(10);

		lblRemeras = new JLabel("Tipo Remera:");
		comboBox = new JComboBox<String>();
		añadirRemeras();

		btnRealizarCompra = new JButton("Realizar Compra");

		btnRealizarCompra.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnRealizarCompra.setEnabled(false);
				realizarCompra();
				btnRealizarCompra.setEnabled(true);
			}
		});

	}

	private void añadirRemeras() {
		for (Remera r : this.remeras) {
			this.comboBox.addItem(r.descripcion());
		}
	}

	private void realizarCompra() {
		if (validarComboBox()) {

			try {
				sistVentas.generarVenta(sistFechas, repoVentas, Integer.valueOf(txtCantidad.getText()),
						this.remeras.get(comboBox.getSelectedIndex()), txtEmail.getText());

				JOptionPane.showMessageDialog(new JFrame(), "La Venta se ha Realizado con Exito!", "Error",
						JOptionPane.INFORMATION_MESSAGE);

			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(new JFrame(), "La Cantidad de Remeras debe ser un valor Numerico",
						"Error", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(new JFrame(), "Sucedio un Fallo al intentar mandar un Correo", "Error",
						JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(new JFrame(), "Sucedio un Error al Crear o Encontrar un Archivo", "Error",
						JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}

		}
	}

	private void consultarMontoCompra() {
		if (validarComboBox()) {

			try {

				this.textField.setText("$" + sistVentas
						.consultarMontoVenta(sistFechas, Integer.valueOf(txtCantidad.getText()),
								this.remeras.get(comboBox.getSelectedIndex()), txtEmail.getText().toString())
						.toString());

			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(new JFrame(), "La Cantidad de Remeras debe ser un valor Numerico",
						"Error", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}

		}
	}

	private boolean validarComboBox() {
		if (this.comboBox.getSelectedIndex() < 0) {
			JOptionPane.showMessageDialog(this.contentPane, "Debe Elegir una Remera");
			return false;
		}
		return true;
	}

	private void layout() {

		JButton btnConsultarMonto = new JButton("Consultar Monto Total");
		btnConsultarMonto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				consultarMontoCompra();
			}
		});

		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Monto Total:");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblCantidad).addComponent(lblEmail).addComponent(lblRemeras))
								.addGap(45)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(txtEmail, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 298,
												Short.MAX_VALUE)
										.addComponent(txtCantidad, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 298,
												Short.MAX_VALUE)
										.addComponent(comboBox, Alignment.TRAILING, 0, 298, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(btnConsultarMonto, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblNewLabel)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(textField,
														GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)))
								.addPreferredGap(ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
								.addComponent(btnRealizarCompra, GroupLayout.PREFERRED_SIZE, 150,
										GroupLayout.PREFERRED_SIZE)))
				.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtCantidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCantidad))
				.addGap(18)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(lblEmail).addComponent(
						txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblRemeras))
				.addPreferredGap(ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_contentPane.createSequentialGroup().addComponent(btnConsultarMonto)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel)))
						.addComponent(btnRealizarCompra, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE))
				.addContainerGap()));
		contentPane.setLayout(gl_contentPane);
	}
}
