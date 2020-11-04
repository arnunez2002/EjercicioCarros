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
}
