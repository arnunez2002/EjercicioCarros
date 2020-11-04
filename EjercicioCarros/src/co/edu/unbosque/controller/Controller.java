package co.edu.unbosque.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

import co.edu.unbosque.model.Compra;
import co.edu.unbosque.model.Venta;
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
			vista.imprimir("6: Ver Estado [Disponible/Vendido]");
			vista.imprimir("7: realizar comparaciones");

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
		                e.setDisponible(true);
		                String mensaje = comprarDAO.registrarCarro(e, archivo);
		                vista.imprimir(mensaje +"" + "\n");
		            }
				break;
			case "2":
				vista.imprimir("Bienvenido al sistema de venta");
				vista.imprimir("Introduce la placa del auto a vender");
				 Scanner placa = new Scanner(System.in);
				 int  pos = comprarDAO.atributoCompra(placa.nextLine());
				 if(pos==-1) {
					 vista.imprimir("[Error] Estimado usuario. La placa que introduciste no coincide con ninguna placa registrada en los auto disponibles");
				 }else {
					 if(comprarDAO.getListaCompra().get(pos).isDisponible()) {
						 vista.imprimir("¡Perfecto! El auto está disponible");
						 vista.imprimir("Porfavor, coloque el nombre del cliente y el valor de la venta de la siguiente manera:");
						 vista.imprimir("nombreCliente, valor de la venta");
					
						 Scanner datos = new Scanner(System.in);
						 Scanner  scannerVenta = new Scanner(datos.nextLine());
				          while (scannerVenta.hasNextLine()) {
				        	 
				                // el objeto scanner lee linea a linea desde el archivo
				                String linea = scannerVenta.nextLine();
				                Scanner delimitar = new Scanner(linea);
				                // se usa una expresi�n regular
				                // que valida que antes o despues de una coma (,) exista cualquier cosa
				                // parte la cadena recibida cada vez que encuentre una coma
				                delimitar.useDelimiter("\\s*,\\s*");
				                Venta e = new Venta();
				               
				                e.setNombreCliente(delimitar.next());
				                e.setValorVenta(Integer.parseInt(delimitar.next()));
				                e.setPlaca(comprarDAO.getListaCompra().get(pos).getPlaca());
				                e.setMarca(comprarDAO.getListaCompra().get(pos).getMarca());
				                e.setModelo(comprarDAO.getListaCompra().get(pos).getModelo());
				                e.setAño(comprarDAO.getListaCompra().get(pos).getAño());
				                e.setPuertas(comprarDAO.getListaCompra().get(pos).getPuertas());
				                e.setCapacidad(comprarDAO.getListaCompra().get(pos).getPuertas());
				                e.setTipo(comprarDAO.getListaCompra().get(pos).getTipo());
				                e.setDisponible(false);
				                comprarDAO.getListaCompra().get(pos).setDisponible(false);
				                comprarDAO.cambiarDisponibilidad(pos,false,archivo);
				                String mensaje = ventaDAO.agregarVentas(e);
				                vista.imprimir(mensaje +"" + "\n");
				            }
					 }else {
						 vista.imprimir("¡Lo sentimos!. Ese carro ya fue vendido");
					 }
				
				 }
				
				break;
			case "3":
				System.out.println("Ingresa la placa.");
				Scanner buscar = new Scanner(System.in);
				String placaBuscar = buscar.next();
				String aux = comprarDAO.buscarCarro(placaBuscar);
				System.out.println(aux);
				break;

			case "4":
				vista.imprimir("Ingrese la placa para eliminar.");
				Scanner elim = new Scanner(System.in);
				String placaElimimnar = elim.next();
				if(comprarDAO.placaRepetida(placaElimimnar)) {
				 comprarDAO.eliminarCompra(placaElimimnar, archivo);
				 vista.imprimir(ventaDAO.eliminarVenta(placaElimimnar, archivoVenta));
					vista.imprimir(""+"\n");
				}else {
					vista.imprimir("[Error] Estimado usuario. La placa que introduciste no coincide con ninguna placa registrada en los auto disponibles");
				}
				break;
			case "5":
				vista.imprimir(comprarDAO.infoTodoslosVehiculos());
				vista.imprimir(ventaDAO.infoTodoslosVehiculos());
				break;
			case "6":
				vista.imprimir(comprarDAO.mostrarDisponibilidad());
				break;
			case "7":
				System.out.println("¿Que propiedad del veículo quieres comparar?");
				Scanner comp = new Scanner(System.in);
				String comparar = comp.next();
				System.out.println("Ingrese el valor que desea comparar.");
				Scanner valorP = new Scanner(System.in);
				String valor = valorP.next();
				System.out.println(comprarDAO.comparar(comparar,valor));
				break;
			default: vista.imprimir("[ERROR]  Marcaste una opcion no valida");
	        break;

			}

		}
		
	}

}
