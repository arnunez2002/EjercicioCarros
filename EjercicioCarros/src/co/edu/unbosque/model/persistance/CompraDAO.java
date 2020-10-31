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
				mensaje =  "Se registr� un nuevo auto";
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
				contenido = contenido +listaCompra.get(i).getMarca() + "\n"
				+"Modelo: "+listaCompra.get(i).getModelo() + "\n" 
				+"A�o: "+ listaCompra.get(i).getA�o() +  "\n" 
				+ "N�mero de puertas: "+listaCompra.get(i).getPuertas() + "\n"
				+"Capacidad: "+listaCompra.get(i).getCapacidad() + "\n"
				+ "Tipo de Auto: "+listaCompra.get(i).getTipo()+ "\n"
				+ "Precio de compra: "+listaCompra.get(i).getPrecio()+"\n";
				if(listaCompra.get(i).isDisponible()) {
					contenido = contenido +"Disponobilidad: Disponible"+"\n";
				}else {
					contenido = contenido +"Disponobilidad: No Disponible"+"\n";
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
	
	
	public String  modificarCompra (String marca, String modelo, int a�o, String placa, int puertas,  int capacidad, String tipo, int precio, boolean disponible, File archivo) {
		
		for (int i = 0; i < listaCompra.size(); i++) {
			if(listaCompra.get(i).getPlaca().equals(placa)) {
				listaCompra.get(i).setA�o(a�o);
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
			System.out.println("Ocurr� un error");
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
		
		
		
		return "Se elimin� el carro de la lista de los carros comprados";
		
	}
	
	public String  infoTodoslosVehiculos () {	String contenido = "La informacion de todos los vehiculos comprados: " + "\n";
	for (int i = 0; i < listaCompra.size(); i++) {

		contenido = contenido +"Marca: ["+listaCompra.get(i).getMarca() + "] "
		+"Modelo: ["+listaCompra.get(i).getModelo() + "] " 
		+"A�o: ["+ listaCompra.get(i).getA�o() +  "] " 
		+ "N�mero de puertas: ["+listaCompra.get(i).getPuertas() + "] "
		+"Capacidad: ["+listaCompra.get(i).getCapacidad() + "] "
		+ "Tipo de Auto: ["+listaCompra.get(i).getTipo()+ "]"
		+ "Precio de compra: ["+listaCompra.get(i).getPrecio() +"]";
		if(listaCompra.get(i).isDisponible()) {
			contenido = contenido + "disponibilidad: [Disponible]"+"\n"; ;
		}else {
			contenido = contenido + "disponibilidad: [No disponible]"+"\n"; ;
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
