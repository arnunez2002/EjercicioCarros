package co.edu.unbosque.model.persistance;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import co.edu.unbosque.model.Compra;

public class CompraDAO {

	private OperacionArchivo opArchivo;
	private ArrayList<Compra> listaCompra;

	public CompraDAO() {
		listaCompra = new ArrayList<Compra>();
		opArchivo = new OperacionArchivo();
		verificarInvariante();
	}

	public String registrarCarro(Compra nuevaCompra, File archivo) {
		String mensaje = "";
		if (placaRepetida(nuevaCompra.getPlaca())) {
			mensaje = "[ERROR] Ya hay un auto con esa placa registrada";
		} else {
			listaCompra.add(nuevaCompra);
			opArchivo.escribirEnArchivoCompra(listaCompra, "Data/Compras.dat");
			mensaje = "Se registró un nuevo auto";
		}
		return mensaje;
	}

	public boolean placaRepetida(String placa) {
		boolean repetido = false;
		for (int i = 0; i < listaCompra.size(); i++) {
			if (listaCompra.get(i).getPlaca().equals(placa)) {
				repetido = true;
			}
		}
		return repetido;
	}

	public String buscarCarro(String placa) {
		String contenido = "No se encontro carro con la placa";
		for (int i = 0; i < listaCompra.size(); i++) {
			if (listaCompra.get(i).getPlaca().equals(placa)) {
				contenido = "Datos del auto con la placa: " + placa + " es: " + "\n";
				contenido = contenido + "Marca: " + listaCompra.get(i).getMarca() + "\n" + "Modelo: "
						+ listaCompra.get(i).getModelo() + "\n" + "Placa: " + listaCompra.get(i).getPlaca() + "\n"
						+ "Año: " + listaCompra.get(i).getAño() + "\n" + "Número de puertas: "
						+ listaCompra.get(i).getPuertas() + "\n" + "Capacidad: " + listaCompra.get(i).getCapacidad()
						+ "\n" + "Tipo de Auto: " + listaCompra.get(i).getTipo() + "\n" + "Precio de compra: "
						+ listaCompra.get(i).getPrecio() + "\n";
				if (listaCompra.get(i).isDisponible()) {
					contenido = contenido + "Disponobilidad: Disponible" + "\n";
				} else {
					contenido = contenido + "Disponobilidad: Vendido" + "\n";
				}
			}
		}
		return contenido;
	}

	public int atributoCompra(String placa) {
		int pos = -1;
		for (int i = 0; i < listaCompra.size(); i++) {
			if (listaCompra.get(i).getPlaca().equals(placa)) {
				pos = i;
			}
		}
		return pos;
	}

	public String mostrarDisponibilidad() {
		String mensaje = "" + "\n";
		if (listaCompra.size() == 0) {
			mensaje = "¡No hay ningun auto registrado!" + "\n" + "\n";
		} else {
			mensaje = mensaje + "Placas de los autos y su estado " + "\n";
			for (int i = 0; i < listaCompra.size(); i++) {
				if (listaCompra.get(i).isDisponible()) {
					mensaje = mensaje + "[" + listaCompra.get(i).getPlaca() + "]  [Disponible]" + "\n";
				} else {
					mensaje = mensaje + "[" + listaCompra.get(i).getPlaca() + "]  [Vendido]" + "\n";
				}
			}
		}
		return mensaje;
	}

	public void cambiarDisponibilidad(int i, boolean disponibilidad, File archivo) {
		listaCompra.get(i).setDisponible(disponibilidad);
		archivo.delete();
		try {
			archivo.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		opArchivo.escribirEnArchivoCompra(listaCompra, "Data/Compras.dat");
	}

	public String eliminarCompra(String placa, File archivo) {
		String mensaje = "No se encontro un carro con la placa indicada";
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
				opArchivo.escribirEnArchivoCompra(listaCompra, "Data/Compras.dat");
				mensaje = "Se eliminó el carro de la lista de los carros comprados";
			}
		}
		return mensaje;
	}

	public String infoTodoslosVehiculos() {
		String contenido = "La informacion de todos los vehiculos comprados: " + "\n";
		for (int i = 0; i < listaCompra.size(); i++) {

			contenido = contenido + "Marca: [" + listaCompra.get(i).getMarca() + "] " + "Modelo: ["
					+ listaCompra.get(i).getModelo() + "] " + "Placa: [" + listaCompra.get(i).getPlaca() + "] "
					+ "Año: [" + listaCompra.get(i).getAño() + "] " + "Número de puertas: ["
					+ listaCompra.get(i).getPuertas() + "] " + "Capacidad: [" + listaCompra.get(i).getCapacidad() + "] "
					+ "Tipo de Auto: [" + listaCompra.get(i).getTipo() + "]" + "Precio de compra: ["
					+ listaCompra.get(i).getPrecio() + "]";
			if (listaCompra.get(i).isDisponible()) {
				contenido = contenido + " disponibilidad: [Disponible]" + "\n";
				;
			} else {
				contenido = contenido + " disponibilidad: [Vendido]" + "\n";
				;
			}

		}
		return contenido;
	}

	public String vender(int pos, File archivo) {
		listaCompra.get(pos).setDisponible(false);
		archivo.delete();
		try {
			archivo.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		opArchivo.escribirEnArchivoCompra(listaCompra, "Data/Compras.dat");
		return "Se vendió el vehiculo";
	}

	public String comparar(String vehiculo1, String vehiculo2) {
		int pos1 = 0, pos2 = 0;
		String mensaje = "Atributos			vehiculo 1		Vehiculo 2			Comparaciones" + "\n" + "\n";
		for (int i = 0; i < listaCompra.size(); i++) {
			if (listaCompra.get(i).getPlaca().equals(vehiculo1)) {
				pos1 = i;
			}
			if (listaCompra.get(i).getPlaca().equals(vehiculo2)) {
				pos2 = i;
			}
		}
		String marcaC = "Son diferentes";
		String modeloC = "Son diferentes";
		String capacidadc = "Son diferentes";
		String puertasC = "Son diferentes";
		String tipoC = "Son diferentes";
		String disponibilidad = "Son diferentes";
		String disponibilidad1 = "Vendido";
		String disponibilidad2 = "Vendido";
		if (listaCompra.get(pos1).getMarca().equals(listaCompra.get(pos2).getMarca())) {
			marcaC = "Son iguales";
		} 
		if (listaCompra.get(pos1).getModelo().equals(listaCompra.get(pos2).getModelo())) {
			modeloC = "Son iguales";
		} 
		if (listaCompra.get(pos1).getCapacidad() == listaCompra.get(pos2).getCapacidad()) {
			capacidadc = "Son iguales";
		} 
		if (listaCompra.get(pos1).getPuertas() == listaCompra.get(pos2).getPuertas()) {
			puertasC = "Son iguales";
		} 
		if (listaCompra.get(pos1).getTipo().equals(listaCompra.get(pos2).getTipo())) {
			tipoC = "Son iguales";
		} 
		if (listaCompra.get(pos1).isDisponible() ==listaCompra.get(pos2).isDisponible() ) {
			disponibilidad = "Son iguales";
		} 
		if(listaCompra.get(pos1).isDisponible() == true) {
			disponibilidad1 = "Disponible";
		}if(listaCompra.get(pos2).isDisponible() == true) {
			disponibilidad2 = "Disponible";
		}

		mensaje = mensaje + "placa: 				[" + listaCompra.get(pos1).getPlaca() + "]		["
				+ listaCompra.get(pos2).getPlaca() + "]				[" + "Son diferentes"+ "]" + "\n" + "Marca: 				["
				+ listaCompra.get(pos1).getMarca() + "]		[" + listaCompra.get(pos2).getMarca() + "]			["
				+ marcaC + "]" + "\n" + "Modelo: 			[" + listaCompra.get(pos1).getModelo() + "]			["
				+ listaCompra.get(pos2).getModelo() + "]			[" + modeloC+ "]" + "\n" + "Capacidad:			["
				+ listaCompra.get(pos1).getCapacidad() + "]			[" + listaCompra.get(pos2).getCapacidad()
				+ "]				[" +capacidadc + "]" + "\n" + "Puertas Cantidad:		[" + listaCompra.get(pos1).getPuertas()
				+ "]			[" + listaCompra.get(pos2).getPuertas() + "]				[" + puertasC + "]"
				+ "\n" + "Tipo:				[" + listaCompra.get(pos1).getTipo() + "]		[" + listaCompra.get(pos2).getTipo()
				+ "]			[" + tipoC+ "]" + "\n"
				+ "Disponibilidad: 		["+disponibilidad1+ "]		["+ disponibilidad2+"]			[" + disponibilidad+ "]" + "\n";
		return mensaje;
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
