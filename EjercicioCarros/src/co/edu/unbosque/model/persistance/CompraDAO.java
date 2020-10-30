package co.edu.unbosque.model.persistance;

import java.util.ArrayList;

import co.edu.unbosque.model.Compra;

public class CompraDAO {
	
	private ArrayList<Compra> listaCompra;
	
	public CompraDAO() {
		listaCompra = new  ArrayList<Compra> ();
	}
	
	public String comprarCarro (String marca, String modelo, int a�o, String placa, int puertas,  int capacidad, String tipo, int precio, boolean disponible) {
		Compra nuevaCompra = new Compra (marca, modelo, a�o,placa,  puertas, capacidad,tipo,  precio,disponible );
		listaCompra.add(nuevaCompra);
		return "Se registr� nueva compra";
	}

}
