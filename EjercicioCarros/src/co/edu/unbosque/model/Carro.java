package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.Date;

public class Carro  implements Serializable{
	private static final long serializable = 1l;
	
	private String marca;
	private String modelo;
	private int a�o;
	private String placa;
	private int puertas;
	private int capacidad;
	private String tipo;
	private boolean disponible;
	
public Carro () {
		
	}

public Carro(String marca, String modelo, int a�o, String placa, int puertas,   int capacidad,  String tipo, boolean disponible) {
	this.marca = marca;
	this.modelo = modelo;
	this.a�o = a�o;
	this.placa = placa;
	this.puertas = puertas;
	this.capacidad = capacidad;
	this.disponible = disponible;
}

public String getMarca() {
	return marca;
}

public void setMarca(String marca) {
	this.marca = marca;
}

public String getModelo() {
	return modelo;
}

public void setModelo(String modelo) {
	this.modelo = modelo;
}

public int getA�o() {
	return a�o;
}

public void setA�o(int a�o) {
	this.a�o = a�o;
}

public String getPlaca() {
	return placa;
}

public void setPlaca(String placa) {
	this.placa = placa;
}

public int getPuertas() {
	return puertas;
}

public void setPuertas(int puertas) {
	this.puertas = puertas;
}

public int getCapacidad() {
	return capacidad;
}

public void setCapacidad(int capacidad) {
	this.capacidad = capacidad;
}

public String getTipo() {
	return tipo;
}

public void setTipo(String tipo) {
	this.tipo = tipo;
}

public boolean isDisponible() {
	return disponible;
}

public void setDisponible(boolean disponible) {
	this.disponible = disponible;
}




	
}
