package co.edu.unbosque.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import co.edu.unbosque.model.Compra;
import co.edu.unbosque.model.persistance.CompraDAO;
import co.edu.unbosque.model.persistance.OperacionArchivo;
import co.edu.unbosque.view.VistaPrinicipal;

public class Controller {
	private VistaPrinicipal vista;
	private CompraDAO comprarDAO;
	private File archivo = new File("Data/Compras.dat");
	private File archivoVenta = new File("Data/Venta.dat");
	private OperacionArchivo opArchivo;

	public Controller() {
		opArchivo = new OperacionArchivo();
		vista = new VistaPrinicipal();
		comprarDAO = new CompraDAO();
		comprarDAO.setListaCompra(opArchivo.leerArchivoCompra(archivo));
//		ventaDAO.setListaVenta(opArchivo.leerArchivoVenta(archivoVenta));

	}

	public void operiaciones() {

		boolean cont = true;
		while (cont) {
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
				Scanner scanner = new Scanner(datosCompra.nextLine());
				ArrayList<String> atributos = new ArrayList<String>();
				
				while (scanner.hasNextLine()) {
					
					try {
						// el objeto scanner lee linea a linea desde el archivo
						String linea = scanner.nextLine();
						Scanner delimitar = new Scanner(linea);
					
						// se usa una expresi�n regular
						// que valida que antes o despues de una coma (,) exista cualquier cosa
						// parte la cadena recibida cada vez que encuentre una coma
						delimitar.useDelimiter("\\s*,\\s*");

						while (delimitar.hasNext()) {
							atributos.add(delimitar.next());
							
						}
					
						if (atributos.size() == 8) {
							
							if (atributos.get(2).matches("[0-9]*") || atributos.get(4).matches("[0-9]*")
									|| atributos.get(5).matches("[0-9]*") || atributos.get(7).matches("[0-9]*")) {
								if (Integer.parseInt(atributos.get(2)) > 1070) {
									String subPlaca = "ABC123".substring(0, 3);
									vista.imprimir("La plca de su nuevo ehiculo es: "+subPlaca);
									String subFinalPlaca = atributos.get(3).substring(3, atributos.get(3).length());
									if (subPlaca.matches("[0-9]*") == false && subFinalPlaca.matches("[0-9]*")) {
										Compra e = new Compra();
										e.setMarca(atributos.get(0));
										e.setModelo(atributos.get(1));
										e.setAño(Integer.parseInt(atributos.get(2)));
										e.setPlaca(atributos.get(3));
										e.setPuertas(Integer.parseInt(atributos.get(4)));
										e.setCapacidad(Integer.parseInt(atributos.get(5)));
										e.setTipo(atributos.get(6));
										e.setPrecio(Integer.parseInt(atributos.get(7)));
										e.setDisponible(true);

										String mensaje = comprarDAO.registrarCarro(e, archivo);
										vista.imprimir(mensaje + "" + "\n");
									} else {
										vista.imprimir("¡ERROR! Ingresaste una placa no valida");
									}
								} else {
									vista.imprimir("¡ERROR! Ingresaste un año menor a 1070 (eso no se permite)");
								}
							} else {
								vista.imprimir(
										"¡ERROR! Ingresaste un año, numero e puertas, capacidad o precio NO válido");
							}
						} else if (atributos.size() < 8) {
							vista.imprimir("¡ERROR! Se ingresaron Datos incompletos (Deben ser 8)");
						} else if (atributos.size() > 8) {
							vista.imprimir("¡ERROR!  Se ingresaron Datos de más (Deben ser 8)");
						}

					} catch (NoSuchElementException e) {
						// TODO: handle exception
						vista.imprimir("¡Lo sentimos! Algun dato fue mal registrado");
					}

				}
				break;
			case "2":
				vista.imprimir("Bienvenido al sistema de venta");
				vista.imprimir("Introduce la placa del auto a vender");
				Scanner placa = new Scanner(System.in);
				int pos = comprarDAO.atributoCompra(placa.nextLine());
				if (pos == -1) {
					vista.imprimir(
							"[Error] Estimado usuario. La placa que introduciste no coincide con ninguna placa registrada en los auto disponibles");
				} else {
					if (comprarDAO.getListaCompra().get(pos).isDisponible()) {
						vista.imprimir("¡Perfecto! El auto está¡ disponible");
						comprarDAO.getListaCompra().get(pos).setDisponible(false);
						comprarDAO.vender(pos, archivo);
						vista.imprimir("El vehículo fue vendido");
					} else {
						vista.imprimir("¡Lo sentimos!. Ese carro ya fue vendido");
					}

				}

				break;
			case "3":
				vista.imprimir("Ingresa la placa.");
				Scanner buscar = new Scanner(System.in);
				String placaBuscar = buscar.next();
				String aux = comprarDAO.buscarCarro(placaBuscar);
				vista.imprimir(aux);
				break;

			case "4":
				vista.imprimir("Ingrese la placa para eliminar.");
				Scanner elim = new Scanner(System.in);
				String placaElimimnar = elim.next();
				if (comprarDAO.placaRepetida(placaElimimnar)) {
					comprarDAO.eliminarCompra(placaElimimnar, archivo);
					vista.imprimir("" + "\n");
				} else {
					vista.imprimir(
							"[Error] Estimado usuario. La placa que introduciste no coincide con ninguna placa registrada en los auto disponibles");
				}
				break;
			case "5":
				vista.imprimir(comprarDAO.infoTodoslosVehiculos());
				break;
			case "6":
				vista.imprimir(comprarDAO.mostrarDisponibilidad());
				break;
			case "7":
				vista.imprimir("Coloca la placa del primer vehiculo");
				Scanner comp = new Scanner(System.in);
				String vehiculo1 = comp.next();
				if(comprarDAO.placaRepetida(vehiculo1)==false) {
					vista.imprimir("[ERROR] No se encuentra la placa ingresada" +"\n" +"\n");
					break;
				}
				vista.imprimir("Coloca la placa del segundo vehiculo" );
				Scanner valorP = new Scanner(System.in);
				String vehiculo2 = valorP.next();
				if(comprarDAO.placaRepetida(vehiculo2)==false) {
					vista.imprimir("[ERROR] No se encuentra la placa ingresada"+"\n" +"\n");
					break;
				}
				vista.imprimir(comprarDAO.comparar(vehiculo1, vehiculo2));
				break;
			default:
				vista.imprimir("[ERROR]  Marcaste una opcion no valida");
				break;

			}

		}

	}

}
