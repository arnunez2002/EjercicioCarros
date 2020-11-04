package co.edu.unbosque.model;

import java.io.Serializable;

public class Venta implements Serializable {

	private static final long serializable = 1l;

	private String nombreCliente;
	private String marca;
	private String modelo;
	private int año;
	private String placa;
	private int puertas;
	private int capacidad;
	private String tipo;
	private boolean disponible;
	private int valorVenta;

	public Venta() {
		verificarInvariante();
	}

	public Venta(String nombreCliente, String marca, String modelo, int año, String placa, int puertas, int capacidad,
			String tipo, boolean disponible, int valorVenta) {
		this.nombreCliente = nombreCliente;
		this.marca = marca;
		this.modelo = modelo;
		this.año = año;
		this.placa = placa;
		this.puertas = puertas;
		this.capacidad = capacidad;
		this.disponible = disponible;
		this.valorVenta = valorVenta;
	}

	private void verificarInvariante() {
		assert nombreCliente != null && nombreCliente != "": "El cliente no puede ser vacio";
		assert marca != null && marca != "": "La marca no puede ser vacío";
		assert modelo != null && modelo != "": "El modelo no puede ser null";
		assert año>0 : "El año no puede ser negativo o 0";
		assert placa != null && placa != "": "La placa no puede ser vacio";
		assert puertas>0 : "Las puertas no pueden ser menor o igual a 0";
		assert capacidad>0 : "La capacidad no puede ser menor o igual a 0";
		assert valorVenta>0 : "El valor no puede ser menor o igual a 0";
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

	public int getAño() {
		return año;
	}

	public void setAño(int año) {
		this.año = año;
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
