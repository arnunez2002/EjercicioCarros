package co.edu.unbosque.model.persistance;

import java.io.File;
import java.util.ArrayList;

import co.edu.unbosque.model.Venta;

public class VentaDAO {

	private OperacionArchivo opArchivo;
	private ArrayList<Venta> listaVenta;
	
	public VentaDAO () {
		listaVenta = new  ArrayList<Venta> ();
		opArchivo = new OperacionArchivo();
	}
	
	
	public String agregarVentas (String nombreCliente, String marca, String modelo, int año, String placa, int puertas, int capacidad,
			String tipo, boolean disponible, int valorVenta) {
		Venta nuevaVenta = new Venta (nombreCliente, marca, modelo, año,placa,  puertas,capacidad, tipo, disponible, valorVenta );
		listaVenta.add(nuevaVenta);
		opArchivo.escribirEnArchivoVenta(listaVenta, "Data/Venta.dat");
		return "Se registró una nueva venta";
	}
	
	public String buscarCarroVenta (String placa) {
		String contenido = "Datos del auto con la placa: " + placa +" es: "+ "\n";
		for (int i = 0; i < listaVenta.size(); i++) {
			if(listaVenta.get(i).getPlaca().equals(placa)) {
				contenido = contenido +listaVenta.get(i).getMarca() + "\n"
						+"Modelo: "+listaVenta.get(i).getModelo() + "\n" 
						+"Año: "+ listaVenta.get(i).getAño() +  "\n" 
						+ "Número de puertas: "+listaVenta.get(i).getPuertas() + "\n"
						+"Capacidad: "+listaVenta.get(i).getCapacidad() + "\n"
						+ "Tipo de Auto: "+listaVenta.get(i).getTipo()+ "\n"
						+ "Precio de venta: "+listaVenta.get(i).getValorVenta();
			}
		}
		return contenido;
	}
	
	public String  infoTodoslosVehiculos () {
		String contenido = "La informacion de todos los vehiculos comprados: " + "\n";
		for (int i = 0; i < listaVenta.size(); i++) {

			contenido = contenido +"Marca: ["+listaVenta.get(i).getMarca() + "] "
			+"Modelo: ["+listaVenta.get(i).getModelo() + "] " 
			+"Año: ["+ listaVenta.get(i).getAño() +  "] " 
			+ "Número de puertas: ["+listaVenta.get(i).getPuertas() + "] "
			+"Capacidad: ["+listaVenta.get(i).getCapacidad() + "] "
			+ "Tipo de Auto: ["+listaVenta.get(i).getTipo()+ "]"
			+ "Precio de compra: ["+listaVenta.get(i).getValorVenta() +"]"+ "\n";
		
		}
		return contenido;
	}


	public OperacionArchivo getOpArchivo() {
		return opArchivo;
	}


	public void setOpArchivo(OperacionArchivo opArchivo) {
		this.opArchivo = opArchivo;
	}


	public ArrayList<Venta> getListaVenta() {
		return listaVenta;
	}


	public void setListaVenta(ArrayList<Venta> listaVenta) {
		this.listaVenta = listaVenta;
	}
	
	
	
}
