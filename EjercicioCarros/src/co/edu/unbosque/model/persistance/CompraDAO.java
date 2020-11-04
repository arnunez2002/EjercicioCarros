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
		verificarInvariante();
	}
	public String registrarCarro (Compra nuevaCompra, File archivo) {
		String mensaje = "";
		if(placaRepetida(nuevaCompra.getPlaca())) {
			mensaje = "[ERROR] Ya hay un auto con esa placa registrada";
		}else {
			listaCompra.add(nuevaCompra);
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
		String contenido = "";
		for (int i = 0; i < listaCompra.size(); i++) {
			if(listaCompra.get(i).getPlaca().contentEquals(placa)) {
				contenido = "Datos del auto con la placa: " + placa +" es: "+ "\n";
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
			else {
				contenido = "No se encontro carro con la placa";
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
		+"Placa: ["+listaCompra.get(i).getPlaca()+"] "
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
	
	public String comparar(String b,String a) {
		boolean comp = false;
		switch (b.toLowerCase()) {
		case "modelo":
			for (int i = 0; i < listaCompra.size(); i++) {
				if(a.contentEquals(listaCompra.get(i).getModelo())) {
					String contenido = 
								"Marca: ["+listaCompra.get(i).getMarca() + "] "
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
					System.out.println(contenido);
				comp = true;
				}
			}
			break;
		case "año":
			int as=Integer.parseInt(a);
			for (int i = 0; i < listaCompra.size(); i++) {
				if(as==listaCompra.get(i).getAño()) {
					String contenido = 
							"Marca: ["+listaCompra.get(i).getMarca() + "] "
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
				System.out.println(contenido);
				comp = true;
				}
			}
			break;
		case "placa":
			for (int i = 0; i < listaCompra.size(); i++) {
				if(a.contentEquals(listaCompra.get(i).getPlaca())) {
					String contenido = 
							"Marca: ["+listaCompra.get(i).getMarca() + "] "
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
				System.out.println(contenido);
				comp = true;
				}
			}
			break;
		case "capacidad":
			as = Integer.parseInt(a);
			for (int i = 0; i < listaCompra.size(); i++) {
				if(as==listaCompra.get(i).getCapacidad()) {
					String contenido = 
							"Marca: ["+listaCompra.get(i).getMarca() + "] "
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
				System.out.println(contenido);
				comp = true;
				}
			}
			break;
		case "puertas":
			as = Integer.parseInt(a);
			for (int i = 0; i < listaCompra.size(); i++) {
				if(as==listaCompra.get(i).getPuertas()) {
					String contenido = 
							"Marca: ["+listaCompra.get(i).getMarca() + "] "
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
				System.out.println(contenido);
				comp = true;
				}
			}
			break;
		case "tipo":
			for (int i = 0; i < listaCompra.size(); i++) {
				if(a.contentEquals(listaCompra.get(i).getTipo())) {
					String contenido = 
							"Marca: ["+listaCompra.get(i).getMarca() + "] "
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
				System.out.println(contenido);
				comp = true;
				}
			}
			break;
		}
		if(comp==true) {
			return "Se comparó exitosamente";
		}
		else {
			return "No se encontro el valor deseado en la lista";
		}
	}
	
	private void verificarInvariante() {
		assert opArchivo != null : "El archivo no puede ser vacio";
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
