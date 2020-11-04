package co.edu.unbosque.model.persistance;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import co.edu.unbosque.model.Compra;

public class OperacionArchivo {
	
	private ObjectInputStream entrada;
	private ObjectOutputStream salida;
	
	public OperacionArchivo () {
	}
	
	/**
	 * Este método lee un archivo.dat y lo almacena en un arrayList
	 * <b>pre</b>Debe existir un archivo archivo.dat != null.<br>
	 * <b>post</b>Agrega la informacion en el arrayList.<br>
	 * @param listaCarrosComprados Es la lista done se almacenan. listaCarrosComprados != null.
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<Compra> leerArchivoCompra (File archivo)  {
		System.out.println("Entro");
		ArrayList <Compra> pokemons = new ArrayList <Compra>();
		if(archivo.length() != 0	) {
			try {
				entrada = new ObjectInputStream(new FileInputStream(archivo));
				pokemons = (ArrayList <Compra>) entrada.readObject();
			}catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return pokemons;
	}

	/**
	 * Este método escribe en un archivo.dat.
	 * <b>pre</b>Debe existir un archivo archivo.dat y un arrayList que leer != null.<br>
	 * <b>post</b>Agrega la informacion del arrayList al archivo.dat .<br>
	 * @param salida Es un objeto ObjectOutputStream. salida != null.
	 */
	public void escribirEnArchivoCompra (ArrayList<Compra> pokemons, File archivo) {
		try {
			salida= new ObjectOutputStream(new FileOutputStream(archivo));
			salida.writeObject(pokemons);
			salida.close();		
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
