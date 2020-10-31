package co.edu.unbosque.model.persistance;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import co.edu.unbosque.model.Compra;

public class CompraDAO {
	
	private OperacionArchivo opArchivo;
	private ArrayList<Compra> listaCompra;
	
	public CompraDAO() {
		listaCompra = new  ArrayList<Compra> ();
		opArchivo = new OperacionArchivo();
	}
	public void registrarCarro (Compra nuevaCompra) {
		listaCompra.add(nuevaCompra);
		 File archivo = new File("Data/Compras.dat");
			opArchivo.escribirEnArchivoCompra(listaCompra, archivo);
	}
	
	
	public String agregarCarro (String marca, String modelo, int año, String placa, int puertas,  int capacidad, String tipo, int precio, boolean disponible) {
		Compra nuevaCompra = new Compra (marca, modelo, año,placa,  puertas, capacidad,tipo,  precio,disponible  );
		listaCompra.add(nuevaCompra);
		 File archivo = new File("Data/Compras.dat");
		opArchivo.escribirEnArchivoCompra(listaCompra, archivo);
		return "Se registró nueva compra";
	}
	
	public String buscarCarro (String placa) {
		String contenido = "Datos del auto con la placa: " + placa +" es: "+ "\n";
		for (int i = 0; i < listaCompra.size(); i++) {
			if(listaCompra.get(i).getPlaca().equals(placa)) {
				contenido = contenido +listaCompra.get(i).getMarca() + "\n"
				+"Modelo: "+listaCompra.get(i).getModelo() + "\n" 
				+"Año: "+ listaCompra.get(i).getAño() +  "\n" 
				+ "Número de puertas: "+listaCompra.get(i).getPuertas() + "\n"
				+"Capacidad: "+listaCompra.get(i).getCapacidad() + "\n"
				+ "Tipo de Auto: "+listaCompra.get(i).getTipo()+ "\n"
				+ "Precio de compra: "+listaCompra.get(i).getPrecio();
			}
		}
		return contenido;
	}
	
	
	
	public String  modificarCompra (String marca, String modelo, int año, String placa, int puertas,  int capacidad, String tipo, int precio, boolean disponible, File archivo) {
		
		for (int i = 0; i < listaCompra.size(); i++) {
			if(listaCompra.get(i).getPlaca().equals(placa)) {
				listaCompra.get(i).setAño(año);
				listaCompra.get(i).setMarca(marca);
				listaCompra.get(i).setModelo(modelo);
				listaCompra.get(i).setPlaca(placa);
				listaCompra.get(i).setPuertas(puertas);
				listaCompra.get(i).setCapacidad(capacidad);
				listaCompra.get(i).setTipo(tipo);
				listaCompra.get(i).setPrecio(precio);
			}
		}
		
		archivo.delete();
		try {
			archivo.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Ocurró un error");
		}
		
		opArchivo.escribirEnArchivoCompra(listaCompra, archivo);
		
		
		return "Se realizaron cambios";
	}
	
	public String eliminarCompra (String placa, File archivo) {
		for (int i = 0; i < listaCompra.size(); i++) {
			if (listaCompra.get(i).getPlaca().equals(placa)) {
				listaCompra.remove(i);
				archivo.delete();
				try {
					archivo.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				opArchivo.escribirEnArchivoCompra(listaCompra, archivo);
				
			}
			
		}
		
		
		
		return "Se eliminó el carro de la lista de los carros comprados";
		
	}
	
	public String  infoTodoslosVehiculos () {
		String contenido = "La informacion de todos los vehiculos comprados: " + "\n";
		for (int i = 0; i < listaCompra.size(); i++) {

			contenido = contenido +"Marca: ["+listaCompra.get(i).getMarca() + "] "
			+"Modelo: ["+listaCompra.get(i).getModelo() + "] " 
			+"Año: ["+ listaCompra.get(i).getAño() +  "] " 
			+ "Número de puertas: ["+listaCompra.get(i).getPuertas() + "] "
			+"Capacidad: ["+listaCompra.get(i).getCapacidad() + "] "
			+ "Tipo de Auto: ["+listaCompra.get(i).getTipo()+ "]"
			+ "Precio de compra: ["+listaCompra.get(i).getPrecio() +"]"+ "\n";
		
		}
		return contenido;
	}

	public OperacionArchivo getOpArchivo() {
		return opArchivo;
	}

	public void setOpArchivo(OperacionArchivo opArchivo) {
		this.opArchivo = opArchivo;
	}

	public ArrayList<Compra> getListaCompra() {
		return listaCompra;
	}

	public void setListaCompra(ArrayList<Compra> listaCompra) {
		this.listaCompra = listaCompra;
	}

}
