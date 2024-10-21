package Agenda;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import Pack.*;
public class Agenda {
	//atributos
	private Usuario[] registro;
	public int no_reg;
	
	//constructor vacio
	public Agenda() {
		
	}
	
	//constructor 
	public Agenda(int capacity) {
		registro = new Usuario[capacity];
		no_reg = 0;
	}
	
	//gregar normal (antes de listas enlazadas)
	public boolean agregar(Usuario u) {

		if ((buscar(u.getId())== -1)){
			//se verifica que el registro no sea mayor a la longitud de la lista
			if (no_reg < registro.length){
				//se agrega el usuario a la lista con el numero de registro
				registro[no_reg] = u;
				no_reg ++;
				//indica que el usuario ha sido agregado a la agenda
				return true;
			}
		}else {
			//indica que el usuario ya está en la agenda
			return false;
		}
		return false;
	}
	
	//Buscar
	public int buscar(int id) {
		//verifica si el usuario está en la lista y retorna el índice
		for (int j = 0; j<no_reg-1; j++) {
			if (registro[j].getId() == id) {
				return j;
			}
		}
		//si no está retorna -1
		return -1;	
	}
		
	
	//Eliminar
	public boolean eliminar(int id) {
	
		//Si el usuario está en el registro
		if (buscar(id) != -1) {
			//verifica que el indice sea correcto
			if (buscar(id)  < no_reg){

				//se mueven las posiciones de los usuarios en la agenda
				for (int i=buscar(id); i<no_reg-1;i++) {
					registro[i] = registro[i+1];
				}
				//la última posición es el objeto a eliminar
				registro[no_reg-1] = null;
				//se libera el espacio del usuario eliminado
				no_reg--;
				return true;
			}
		}else {
			//En caso de que el usuario no esté en el registro
			return false;
		}
		return false;
	}
	
	//toFile
	
	public void toFIle() {
		try (BufferedWriter texto = new BufferedWriter(new FileWriter("Empleados.txt"))) {
            for (int k = 0; k < no_reg; k++) {
                texto.write(registro[k].toString() + "\n");
            }
            System.out.println("Los datos han sido escritos correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	
	
	//import

    public void importar() {
        try (FileReader lector = new FileReader("Empleados.txt")) {
        	BufferedReader leer = new BufferedReader(lector);
            String linea;
            while ((linea = leer.readLine()) != null) {
            	String[] informacion = linea.split(",");
                
                //settear los datos al objeto de tipo usuario
            	Usuario nuevoUsuario = new Usuario();
            	
                nuevoUsuario.setNombre(informacion[0]);
                nuevoUsuario.setId(cambiarStringInt(informacion[1]));
                nuevoUsuario.setFecha_nacimiento(Fecha.StringAFecha(informacion[2]));
                nuevoUsuario.setCiudad_nacimiento(informacion[3]);
                nuevoUsuario.setTel(CambiarStringaLong(informacion[4]));
                nuevoUsuario.setEmail(informacion[5]);
                nuevoUsuario.setDir(Direccion.CambiarStringADir(informacion[6]));
                
                agregar(nuevoUsuario);
                
            }
            System.out.println("Datos importados exitosamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    public Usuario[] obtenerRegistro() {
    	return registro;
    }

	public long CambiarStringaLong(String h) {
		try {
			Long num = Long.parseLong(h); 
			return num;
		}catch(Exception e) {
			System.err.println("Error");
			return 0;
		}
	}
	

	public int cambiarStringInt(String h) {
		try {
			int num = Integer.parseInt(h); 
			return num;
		}catch(Exception e) {
			System.err.println("Error");
			return 0;
		}
	}

}

