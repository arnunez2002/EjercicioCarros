package co.edu.unbosque.view;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class PanelRegistrar extends JPanel {
	private JLabel etiquetaMarca;
	private JLabel etiquetaModelo;
	private JLabel etiquetaAño;
	private JLabel etiquetaPlaca;
	private JLabel etiquetaPuertas;
	private JLabel etiquetaCapacidad;
	private JLabel etiquetaTipo;

	private JComboBox<String> comboNPuertas;
	private JComboBox<String> comboCapacidad;
	private JComboBox<String> comboTipo;

	private JTextField campoMarca;
	private JTextField campoModelo;
	private JTextField campoAño;
	private JTextField campoPlaca;

	private JButton registrar;
	private JButton cancelar;

	public PanelRegistrar() {
		this.setVisible(true);
		TitledBorder borde = BorderFactory.createTitledBorder("Registro de autos");
		setBorder(borde);
		setLayout(new GridLayout(4, 2));
		etiquetaMarca = new JLabel("Marca:");
		etiquetaModelo = new JLabel("Modelo: ");
		etiquetaAño = new JLabel("Año: ");
		etiquetaPlaca = new JLabel("Placa: ");
		etiquetaPuertas = new JLabel("Cantidad de puertas: ");
		etiquetaCapacidad = new JLabel("Capacidad");
		etiquetaTipo = new JLabel("Tipo:");

		campoMarca = new JTextField();
		campoModelo = new JTextField();
		campoAño = new JTextField();
		campoPlaca = new JTextField();

		comboNPuertas = new JComboBox<String>();
		comboNPuertas.addItem("Seleccione...");
		comboNPuertas.addItem("1");
		comboNPuertas.addItem("2");
		comboNPuertas.addItem("4");
		comboNPuertas.addItem("6");

		comboCapacidad = new JComboBox<String>();
		comboCapacidad.addItem("Seleccione...");
		comboCapacidad.addItem("1 personas");
		comboCapacidad.addItem("2 personas");
		comboCapacidad.addItem("4 personas");
		comboCapacidad.addItem("6 personas");
		comboCapacidad.addItem("8 personas");

		comboTipo = new JComboBox<String>();
		comboTipo.addItem("Seleccione...");
		comboTipo.addItem("Deportivo");
		comboTipo.addItem("Familiar");
		comboTipo.addItem("Todoterreno");
		comboTipo.addItem("Sedán");
		comboTipo.addItem("Bans");

		add(etiquetaMarca);
		add(campoMarca);
		add(etiquetaModelo);
		add(campoModelo);
		add(etiquetaAño);
		add(campoAño);
		add(etiquetaPlaca);
		add(campoPlaca);
		add(etiquetaPuertas);
		add(comboNPuertas);
		add(etiquetaCapacidad);
		add(comboCapacidad);
		add(etiquetaTipo);
		add(comboTipo);

		registrar = new JButton("Registrar");
		registrar.setActionCommand("REGISTRAR");
		add(registrar);

		cancelar = new JButton("Cancelar");
		cancelar.setActionCommand("CANCELAEREGISTRO");
		add(cancelar);
	}

	public JComboBox<String> getComboNPuertas() {
		return comboNPuertas;
	}

	public void setComboNPuertas(JComboBox<String> comboNPuertas) {
		this.comboNPuertas = comboNPuertas;
	}

	public JComboBox<String> getComboCapacidad() {
		return comboCapacidad;
	}

	public void setComboCapacidad(JComboBox<String> comboCapacidad) {
		this.comboCapacidad = comboCapacidad;
	}

	public JComboBox<String> getComboTipo() {
		return comboTipo;
	}

	public void setComboTipo(JComboBox<String> comboTipo) {
		this.comboTipo = comboTipo;
	}

	public JTextField getCampoMarca() {
		return campoMarca;
	}

	public void setCampoMarca(JTextField campoMarca) {
		this.campoMarca = campoMarca;
	}

	public JTextField getCampoModelo() {
		return campoModelo;
	}

	public void setCampoModelo(JTextField campoModelo) {
		this.campoModelo = campoModelo;
	}

	public JTextField getCampoAño() {
		return campoAño;
	}

	public void setCampoAño(JTextField campoAño) {
		this.campoAño = campoAño;
	}

	public JTextField getCampoPlaca() {
		return campoPlaca;
	}

	public void setCampoPlaca(JTextField campoPlaca) {
		this.campoPlaca = campoPlaca;
	}

	public JButton getRegistrar() {
		return registrar;
	}

	public void setRegistrar(JButton registrar) {
		this.registrar = registrar;
	}

	public JButton getCancelar() {
		return cancelar;
	}

	public void setCancelar(JButton cancelar) {
		this.cancelar = cancelar;
	}
	
	

}
