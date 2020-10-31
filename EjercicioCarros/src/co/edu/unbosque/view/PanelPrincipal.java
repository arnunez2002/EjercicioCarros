package co.edu.unbosque.view;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelPrincipal extends JPanel{
	 private JButton botonRegistro;
	 private JButton botonVentas;
	 private JButton botonEliminar;
	 private JButton botonMostrar;
	 
	 
	 public PanelPrincipal () {
	    	setLayout(new GridLayout(4, 4, 2, 2));
	    	this.setVisible(true);
	    	TitledBorder borde = BorderFactory.createTitledBorder("Ventana Principal");
			setBorder(borde);
			setLayout(new GridLayout(4, 2));
		        
			botonRegistro = new JButton("Restrar");
			botonRegistro.setActionCommand("ACTIVARPANELREGISTRO");
		        add(botonRegistro);
		        
		        botonEliminar = new JButton("Eliminar");
		        botonEliminar.setActionCommand("ACTIVARPANELELIMINAR");
		        add(botonEliminar);
		        
		        botonVentas = new JButton("Ventas");
		        botonVentas.setActionCommand("ACTIVARPANELVENTAS");
		        add(botonVentas);
		        
		        botonMostrar = new JButton("Ventas");
		        botonMostrar.setActionCommand("ACTIVARPANELMOSTRAR");
		        add(botonMostrar);
	    }


	public JButton getBotonRegistro() {
		return botonRegistro;
	}


	public void setBotonRegistro(JButton botonRegistro) {
		this.botonRegistro = botonRegistro;
	}


	public JButton getBotonVentas() {
		return botonVentas;
	}


	public void setBotonVentas(JButton botonVentas) {
		this.botonVentas = botonVentas;
	}


	public JButton getBotonEliminar() {
		return botonEliminar;
	}


	public void setBotonEliminar(JButton botonEliminar) {
		this.botonEliminar = botonEliminar;
	}


	public JButton getBotonMostrar() {
		return botonMostrar;
	}


	public void setBotonMostrar(JButton botonMostrar) {
		this.botonMostrar = botonMostrar;
	}
	 
	 
	 
	 
	 
}
