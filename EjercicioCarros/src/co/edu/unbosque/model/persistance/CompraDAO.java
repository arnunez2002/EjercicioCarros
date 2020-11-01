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
	public String registrarCarro (Compra nuevaCompra) {
		;String mensaje = "";
		if(placaRepetida(nuevaCompra.getPlaca())) {
			mensaje = "[ERROR] Ya hay un auto con esa placa registrada";
		}else {
			listaCompra.add(nuevaCompra);
			 File archivo = new File("Data/Compras.dat");
				opArchivo.escribirEnArchivoCompra(listaCompra, archivo);
				mensaje =  "Se registró un nuevo auto";
		}
		return mensaje;
		
	}
	
	
	
	
	public boolean placaRepetida (String placa) {
		boolean repetido = false;
		for (int i = 0; i < listaCompra.size(); i++) {
			if(listaCompra.get(i).getPlaca().equals(placa)) {
				repetido = true;
			}
		}
		return repetido;
	}
	public String buscarCarro (String placa) {
		String contenido = "Datos del auto con la placa: " + placa +" es: "+ "\n";
		for (int i = 0; i < listaCompra.size(); i++) {
			if(listaCompra.get(i).getPlaca().equals(placa)) {
				contenido = contenido 
				+"Marca: "+listaCompra.get(i).getMarca() + "\n"
				+"Modelo: "+listaCompra.get(i).getModelo() + "\n" 
				+"Placa: "+listaCompra.get(i).getPlaca() + "\n"
				+"Año: "+ listaCompra.get(i).getAño() +  "\n" 
				+ "Número de puertas: "+listaCompra.get(i).getPuertas() + "\n"
				+"Capacidad: "+listaCompra.get(i).getCapacidad() + "\n"
				+ "Tipo de Auto: "+listaCompra.get(i).getTipo()+ "\n"
				+ "Precio de compra: "+listaCompra.get(i).getPrecio()+"\n";
				if(listaCompra.get(i).isDisponible()) {
					contenido = contenido +"Disponobilidad: Disponible"+"\n";
				}else {
					contenido = contenido +"Disponobilidad: Vendido"+"\n";
				}
			}
		}
		return contenido;}
	public int atributoCompra (String placa) {
		int pos = -1;
		for (int i = 0; i < listaCompra.size(); i++) {
			if(listaCompra.get(i).getPlaca().equals(placa)) {
				pos = i;
			}
		}
		return pos;
	}
	public String mostrarDisponibilidad () {
		String mensaje = "" + "\n";
		if(listaCompra.size()==0) {
			mensaje = "¡No hay ningun auto registrado!"+ "\n"+ "\n";
		}else {
			mensaje = mensaje + "Placas de los autos y su estado "+ "\n";
			for (int i = 0; i < listaCompra.size(); i++) {
				if(listaCompra.get(i).isDisponible()) {
					mensaje = mensaje + "["+listaCompra.get(i).getPlaca()+ "]  [Disponible]"+ "\n";
				}else {
					mensaje = mensaje + "["+listaCompra.get(i).getPlaca()+ "]  [Vendido]"+ "\n";
				}
			}
		}
		return mensaje;
	}
	public void cambiarDisponibilidad (int i, boolean disponibilidad, File archivo) {
		listaCompra.get(i).setDisponible(disponibilidad);
		archivo.delete();
		try {
			archivo.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		opArchivo.escribirEnArchivoCompra(listaCompra,archivo);
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
	
	public String  infoTodoslosVehiculos () {	String contenido = "La informacion de todos los vehiculos comprados: " + "\n";
	for (int i = 0; i < listaCompra.size(); i++) {

		contenido = contenido +"Marca: ["+listaCompra.get(i).getMarca() + "] "
		+"Modelo: ["+listaCompra.get(i).getModelo() + "] " 
		+"Año: ["+ listaCompra.get(i).getAño() +  "] " 
		+ "Número de puertas: ["+listaCompra.get(i).getPuertas() + "] "
		+"Capacidad: ["+listaCompra.get(i).getCapacidad() + "] "
		+ "Tipo de Auto: ["+listaCompra.get(i).getTipo()+ "]"
		+ "Precio de compra: ["+listaCompra.get(i).getPrecio() +"]";
		if(listaCompra.get(i).isDisponible()) {
			contenido = contenido + " disponibilidad: [Disponible]"+"\n"; ;
		}else {
			contenido = contenido + " disponibilidad: [Vendido]"+"\n"; ;
		}
	
	}
	return contenido;}

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
