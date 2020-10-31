package co.edu.unbosque.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

import co.edu.unbosque.model.Compra;
import co.edu.unbosque.model.persistance.CompraDAO;
import co.edu.unbosque.model.persistance.OperacionArchivo;
import co.edu.unbosque.model.persistance.VentaDAO;
import co.edu.unbosque.view.VistaPrinicipal;

public class Controller {
	private VistaPrinicipal vista;
	private CompraDAO comprarDAO;
	private VentaDAO ventaDAO;
	private File archivo = new File("Data/Compras.dat");
	private File archivoVenta = new File("Data/Venta.dat");
	private OperacionArchivo opArchivo;

	public Controller() {
		opArchivo = new OperacionArchivo();
		vista = new VistaPrinicipal();
		comprarDAO = new CompraDAO();
		ventaDAO = new VentaDAO();
		comprarDAO.setListaCompra(opArchivo.leerArchivoCompra(archivo));
		ventaDAO.setListaVenta(opArchivo.leerArchivoVenta(archivoVenta));
		
	}

	public void operiaciones() {
		
		boolean cont = true;
		while(cont) {
			vista.imprimir("Bienvenido al programa");
			vista.imprimir("Opciones a realizar:");
			vista.imprimir("Marque:");
			vista.imprimir("1: para registrar una compra");
			vista.imprimir("2: para registrar una venta");
			vista.imprimir("3: para buscar un vehiculo");
			vista.imprimir("4: para eliminar u vehiculo");
			vista.imprimir("5: informacion de todos los vehiculos");
			vista.imprimir("6: realizar comparaciones");

			Scanner seleccionPrincipal = new Scanner(System.in);
			String seleccion = seleccionPrincipal.nextLine();
			switch (seleccion) {

			case "1":
				vista.imprimir("bienvenido al sistema de registro.");
				vista.imprimir("Para registrar un vehiculo tienes que colocar sus datos de la siguiente manera:");
				vista.imprimir("marca,modelo,año,placa,numero de puertas,capacidad,tipo,precio");
				
				Scanner datosCompra = new Scanner(System.in);
				Scanner  scanner = new Scanner(datosCompra.nextLine());
		          while (scanner.hasNextLine()) {
		                // el objeto scanner lee linea a linea desde el archivo
		                String linea = scanner.nextLine();
		                Scanner delimitar = new Scanner(linea);
		                // se usa una expresi�n regular
		                // que valida que antes o despues de una coma (,) exista cualquier cosa
		                // parte la cadena recibida cada vez que encuentre una coma
		                delimitar.useDelimiter("\\s*,\\s*");
		                Compra e = new Compra();
		                e.setMarca(delimitar.next());
		                e.setModelo(delimitar.next());
		                e.setAño(Integer.parseInt(delimitar.next()));
		                e.setPlaca(delimitar.next());
		                e.setPuertas(Integer.parseInt(delimitar.next()));
		                e.setCapacidad(Integer.parseInt(delimitar.next()));
		                e.setTipo(delimitar.next());
		                e.setPrecio(Integer.parseInt(delimitar.next()));
		                String mensaje = comprarDAO.registrarCarro(e);
		                vista.imprimir(mensaje +"" + "\n");
		            }
				break;
			case "2":
				 System.exit(0);
				break;
			case "3":
				System.out.println("opcion 3");
				break;

			case "4":
				System.out.println("Opcion 4");
				break;
			case "5":
				System.out.println(comprarDAO.infoTodoslosVehiculos());
				break;
			case "6":
				System.out.println("opcion 6");
				break;
			default: System.out.println("[ERROR]  Marcaste una opcion no valida");
	        break;

			}

		}
		
	}

}
