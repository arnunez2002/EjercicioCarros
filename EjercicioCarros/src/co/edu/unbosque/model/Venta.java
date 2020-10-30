package co.edu.unbosque.model;

public class Venta {
	
	private String nombreCliente;
	private String marca;
	private String modelo;
	private int a�o;
	private String placa;
	private int puertas;
	private int capacidad;
	private String tipo;
	private boolean disponible;
	private int valorVenta;
	
public Venta () {
		
	}

public Venta(String nombreCliente,String marca, String modelo, int a�o, String placa, int puertas,   int capacidad,  String tipo, boolean disponible, int valorVenta) {
	this.nombreCliente= nombreCliente;
	this.marca = marca;
	this.modelo = modelo;
	this.a�o = a�o;
	this.placa = placa;
	this.puertas = puertas;
	this.capacidad = capacidad;
	this.disponible = disponible;
	this.valorVenta = valorVenta;
}

public String getNombreCliente() {
	return nombreCliente;
}

public void setNombreCliente(String nombreCliente) {
	this.nombreCliente = nombreCliente;
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

public int getValorVenta() {
	return valorVenta;
}

public void setValorVenta(int valorVenta) {
	this.valorVenta = valorVenta;
}



}
