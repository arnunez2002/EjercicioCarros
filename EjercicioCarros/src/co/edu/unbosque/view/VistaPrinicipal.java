package co.edu.unbosque.view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class VistaPrinicipal extends JFrame{

	
	
	public VistaPrinicipal () {
		
}
	public void mostrarError (String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
	}
	
	public void mostrarMensaje (String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}

	public void imprimir(String mensaje) {
		System.out.println(mensaje);
	}
	
	

	
	
	
}
