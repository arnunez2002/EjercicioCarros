package co.edu.unbosque.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import co.edu.unbosque.model.Compra;
import co.edu.unbosque.model.persistance.CompraDAO;
import co.edu.unbosque.model.persistance.OperacionArchivo;
import co.edu.unbosque.model.persistance.VentaDAO;
import co.edu.unbosque.view.VistaPrinicipal;


public class Controller  {
	private VistaPrinicipal vista;
	private CompraDAO comprarDAO;
	private VentaDAO ventaDAO;
	private File archivo = new File("Data/Compras.dat");
	private File archivoVenta = new File("Data/Venta.dat");
	private OperacionArchivo opArchivo;
	
	public Controller () {
		opArchivo = new OperacionArchivo();
		vista = new VistaPrinicipal ();
		comprarDAO = new CompraDAO();
		ventaDAO = new VentaDAO();
		ventaDAO.setListaVenta(opArchivo.leerArchivoVenta(archivoVenta));
		comprarDAO.setListaCompra(opArchivo.leerArchivoCompra(archivo));
	}
	
	public void operiaciones () {
		
		
		System.out.println(comprarDAO.infoTodoslosVehiculos());
		
	}
		
	
}
