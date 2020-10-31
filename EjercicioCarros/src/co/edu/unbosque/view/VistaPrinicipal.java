package co.edu.unbosque.view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class VistaPrinicipal extends JFrame{

	private PanelPrincipal panelPrincipal;
	private PanelRegistrar panelRegistrar;
	
	
	public VistaPrinicipal () {
		inicializarComponentes();
		this.setSize(350, 200);
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
}
	public void mostrarError (String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
	}
	
	public void mostrarMensaje (String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}

	public void inicializarComponentes () {
		
		panelPrincipal = new PanelPrincipal ();
		getContentPane().add(panelPrincipal);
		panelRegistrar = new PanelRegistrar ();
	}





	public PanelPrincipal getPanelPrincipal() {
		return panelPrincipal;
	}
	
	public void imprimir (String menaje) {
		System.out.println(menaje);
	}

	public void setPanelPrincipal(PanelPrincipal panelPrincipal) {
		this.panelPrincipal = panelPrincipal;
	}
	public PanelRegistrar getPanelRegistrar() {
		return panelRegistrar;
	}
	public void setPanelRegistrar(PanelRegistrar panelRegistrar) {
		this.panelRegistrar = panelRegistrar;
	}
	
	
	

	
	
	
}
