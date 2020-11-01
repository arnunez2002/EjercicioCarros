package co.edu.unbosque.model.persistance;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import co.edu.unbosque.model.Venta;

public class VentaDAO {

	private OperacionArchivo opArchivo;
	private ArrayList<Venta> listaVenta;
	
	public VentaDAO () {
		listaVenta = new  ArrayList<Venta> ();
		opArchivo = new OperacionArchivo();
	}
	
	
	public String agregarVentas (Venta nuevaVenta) {
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
				if(listaVenta.get(i).isDisponible()) {
					contenido = contenido +"disponibilidad: Disponible";
				}else {
					contenido = contenido +"disponibilidad: No Disponible";
				}
			}
		}
		return contenido;
	}
	
	
	public String  infoTodoslosVehiculos () {
		String contenido = "La informacion de todos los vehiculos vendidos: " + "\n";
		for (int i = 0; i < listaVenta.size(); i++) {

			contenido = contenido  +"Cliente: ["+listaVenta.get(i).getNombreCliente()+ "] "
			+"Marca: ["+listaVenta.get(i).getMarca() + "] "
			+"Modelo: ["+listaVenta.get(i).getModelo() + "] " 
			+"Placa: [" +  listaVenta.get(i).getPlaca() + "] "
			+"Año: ["+ listaVenta.get(i).getAño() +  "] " 
			+ "Número de puertas: ["+listaVenta.get(i).getPuertas() + "] "
			+"Capacidad: ["+listaVenta.get(i).getCapacidad() + "] "
			+ "Tipo de Auto: ["+listaVenta.get(i).getTipo()+ "]"
			+ "Precio de Venta: ["+listaVenta.get(i).getValorVenta() +"] ";
			if(listaVenta.get(i).isDisponible()) {
				contenido = contenido + "Disponibilidad: [Disponible]"+ "\n";
			}else {
				contenido = contenido + "Disponibilidad: [No Disponible]"+ "\n";
			}
		
		}
		return contenido;
	}
	
	
	
	public String  eliminarVenta(String placa, File archivo) {
		for (int i = 0; i < listaVenta.size(); i++) {
			if (listaVenta.get(i).getPlaca().equals(placa)) {
				listaVenta.remove(i);
				archivo.delete();
				try {
					archivo.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				opArchivo.escribirEnArchivoVentaLeeFile(listaVenta, archivo);
			}
		}
		return "Se eliminó el carro de la lista de los carros comprados";
		
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
