package co.edu.unbosque.test;

import java.io.File;

import co.edu.unbosque.model.Compra;
import co.edu.unbosque.model.persistance.CompraDAO;
import co.edu.unbosque.model.persistance.OperacionArchivo;
import junit.framework.TestCase;

public class CompraDAOTest  extends TestCase{

	CompraDAO compra;
	OperacionArchivo archivo;
	File file = new File("DataTest/CompraTest.dat");
	Compra carro1;
	Compra carro2;
	Compra carro3;
	Compra carro4;
	
	private void setEscenario(){
		file.delete();
		try {
			file.createNewFile();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		archivo = new OperacionArchivo();
		archivo.leerArchivoCompra(file);
		compra = new CompraDAO();
		
		carro1 = new Compra("1","2",2000,"123",2,2,"deportivo",400,true);
		carro2 = new Compra("2","2",2003,"321",3,3,"camper",300,true);
		carro3 = new Compra("3","1",2001,"333",4,1,"carreras",200,true);
		carro4 = new Compra("4","3",2015,"123",5,4,"buggati",500,true);
		
		compra.registrarCarro(carro1, file);
		compra.registrarCarro(carro2, file);
	}
	public void testAgregarCarro() {
		setEscenario();
		
		assertEquals("Debe agregar el carro", "Se registró un nuevo auto", compra.registrarCarro(carro3, file));
		assertEquals("No debe agregar el carro", "[ERROR] Ya hay un auto con esa placa registrada",compra.registrarCarro(carro4, file));
	}
	
	public void testBuscar() {
		setEscenario();
		
		assertEquals("Debe encontrar el carro","Datos del auto con la placa: 123 es: "+ 
			"\nMarca: 1"+
			"\nModelo: 2"+
			"\nPlaca: 123"+
			"\nAño: 2000"+
			"\nNúmero de puertas: 2"+
			"\nCapacidad: 2"+
			"\nTipo de Auto: deportivo"+
			"\nPrecio de compra: 400"+
			"\nDisponobilidad: Disponible"+"\n",compra.buscarCarro("123"));
		assertEquals("No debe encontrar un carro","No se encontro carro con la placa",compra.buscarCarro("9"));
	}
	
	public void testEliminar() {
		setEscenario();
		
		assertEquals("Se debio eliminar el carro","Se eliminó el carro de la lista de los carros comprados",compra.eliminarCompra("123", file));
		assertEquals("No debio encontrar un vehículo", "No se encontro un carro con la placa indicada",compra.eliminarCompra("999", file));
	}
	
	public void testInfoVehículos() {
		setEscenario();
		
		assertEquals("Debio mostrar todos los vehículos","La informacion de todos los vehiculos comprados: \n" + 
				"Marca: [1] Modelo: [2] Placa: [123] Año: [2000] Número de puertas: [2] Capacidad: [2] Tipo de Auto: [deportivo]Precio de compra: [400] disponibilidad: [Disponible]\n" + 
				"Marca: [2] Modelo: [2] Placa: [321] Año: [2003] Número de puertas: [3] Capacidad: [3] Tipo de Auto: [camper]Precio de compra: [300] disponibilidad: [Disponible]\n",compra.infoTodoslosVehiculos());
	}
	
	public void testComparar(){
		setEscenario();
		
		assertEquals("Debio comparar exitosamente","Se comparó exitosamente",compra.comparar("modelo", "2"));
		assertEquals("Debio comparar exitosamente","Se comparó exitosamente",compra.comparar("año", "2000"));
		assertEquals("Debio comparar exitosamente","Se comparó exitosamente",compra.comparar("placa", "123"));
		assertEquals("Debio comparar exitosamente","Se comparó exitosamente",compra.comparar("capacidad", "2"));
		assertEquals("Debio comparar exitosamente","Se comparó exitosamente",compra.comparar("puertas", "2"));
		assertEquals("Debio comparar exitosamente","Se comparó exitosamente",compra.comparar("tipo", "deportivo"));
		assertEquals("No debio comparar exitosamente","No se encontro el valor deseado en la lista",compra.comparar("modelo", "9"));
	}
	
	public void testMostrarDisponibilidad() {
		setEscenario();
		
		assertEquals("Debio mostrar que está disponible","\nPlacas de los autos y su estado \n"+ 
				"[123]  [Disponible]\n"+
				"[321]  [Disponible]\n",compra.mostrarDisponibilidad());
	}
}
