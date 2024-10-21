package Agenda;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import Mensajeria.Mensaje;
import ListaDoble.DoubleList;
import ListaDoble.DoubleNode;
import Pack.Usuario;

public class AgendaDoubleList {
	//Atributos
	private DoubleList coleccion;

	//constructor vacío
	public AgendaDoubleList() {
		this.coleccion = new DoubleList(); // Inicializamos la lista
	}
	
	//agregar
	public void agregar(Usuario u) {
		if (coleccion.isEmpty()) {
			coleccion.addFirst(u);
		}
		else {
			coleccion.addLast(u);
		}
	}
	
	//Buscar usuario
	public int buscarUser(int id){
		DoubleNode temp = coleccion.first();
		while(temp != null) {
			if (((Usuario) temp.getData()).getId() == id) {
				return 1;//retornará 1 si el user está
			}
			temp = temp.getNext();
		}
		return -1; //retornará -1 si el user no está
	}
	//Buscar admin
	public  int buscarAdmin(int id){
		DoubleNode temp = coleccion.first();
		while(temp != null) {
			if (((Usuario) temp.getData()).getId() == id && "administrador".equals(((Usuario) temp.getData()).getCargo())) {
				return 1; //retorna 1 si el user es administrador
			}
			temp = temp.getNext();
		}
			return -1; //retornará -1 si el user no está
	}

	//Verificar contraseñas
	public int PassCorrect(String passWord) {
		DoubleNode temp = coleccion.first();
		while(temp != null){
			if(passWord.equals(((Usuario) temp.getData()).getPassword())) {
				return 1; //retorna 1 si el user es administrador
			}
			temp = temp.getNext();
		}
		return -1; //retornará -1 si el user no está
	}
	

	public void CambiarContraseña(int id, String nuevaPassword){
		DoubleNode temp = coleccion.first();
		System.out.println(((Usuario) temp.getData()).getCargo());
		while(temp != null && ((Usuario) temp.getData()).getId() != id){
			temp = temp.getNext();
		}
		if(temp != null) {
			((Usuario) temp.getData()).setPassword(nuevaPassword);
			actualizarArchivo();
		}
	}
	
	
	//Eliminar
	public void eliminar(int id) {
		DoubleNode temp = coleccion.first();
	
		while(temp != null && ((Usuario) temp.getData()).getId() != id) {
			temp = temp.getNext();
		}
		if (temp != null) {
			coleccion.remove(temp);
		}
	}
	
	//método para hacer más fácil los prints
	public void imprimirDatos2() {
		DoubleNode temp = coleccion.first();
		while (temp != null) {
			if(((Usuario) temp.getData()).getCargo() != null || ((Usuario) temp.getData()).getId() != 0|| ((Usuario) temp.getData()).getPassword() != null){
				System.out.println(((Usuario) temp.getData()).toString3());
			}
			else{
				System.out.println(temp.getData().toString());
			}
			
			temp = temp.getNext();
		}
	}

	public void imprimirDatos() {
		DoubleNode temp = coleccion.first();
		while (temp != null) {
				System.out.println(temp.getData().toString());
			temp = temp.getNext();
		}
	}

	public void imprimirDatos3() {
		DoubleNode temp = coleccion.first();
		while (temp != null) {
				System.out.println(((Usuario) temp.getData()).toString3());
				temp = temp.getNext();
		}
	}
	
	public int tam() {
		int num = coleccion.size();
		return  num;
	}
	
	public void añaDesp(Usuario u) {
		DoubleNode temp = coleccion.first();
		for (int i = 0; i<2; i++) {
			temp = temp.getNext();
		}
		coleccion.addAfter(temp, u);
	}



	//ordenamiento por burbuja
  public void ordenarMenorAMayor() {
		if (coleccion.isEmpty() || coleccion.size() == 1) {
			// No es necesario ordenar si la lista está vacía o tiene un solo elemento
			return;
	}

	boolean intercambio;
	do {
		intercambio = false;
			DoubleNode temp = coleccion.first();

			while (temp.getNext() != null) {
					Usuario usuarioActual = (Usuario) temp.getData();
					Usuario usuarioSiguiente = (Usuario) temp.getNext().getData();

					if (usuarioActual.getId() > usuarioSiguiente.getId()) {
							// Intercambiar los datos si están en el orden incorrecto
							temp.setData(usuarioSiguiente);
							temp.getNext().setData(usuarioActual);
							intercambio = true;
					}

					temp = temp.getNext();
					actualizarArchivoEmpleados();
			}
		} while (intercambio); // Repetir el proceso hasta que no haya intercambios
	}

	    public void actualizarArchivo() {
      try (BufferedWriter escritor = new BufferedWriter(new FileWriter("Password.txt"))) {
            DoubleNode temp = coleccion.first();
            while (temp != null) {
                Usuario usuario = (Usuario) temp.getData();
                String linea = usuario.getId() + " " + usuario.getPassword() + " " + usuario.getCargo();
                escritor.write(linea);
                escritor.newLine();
                temp = temp.getNext();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // Método para actualizar el archivo Empleados.txt
    public void actualizarArchivoEmpleados() {
			try (BufferedWriter escritor = new BufferedWriter(new FileWriter("Empleados.txt"))) {
					DoubleNode temp = coleccion.first();
					while (temp != null) {
							Usuario usuario = (Usuario) temp.getData();
							String linea = usuario.getNombre() + " " +
														 usuario.getId() + " " +
														 usuario.getFecha_nacimiento().toString() + " " +
														 usuario.getCiudad_nacimiento() + " " +
														 usuario.getTel() + " " +
														 usuario.getEmail() + " " +
														 usuario.getDir().toString1();
							escritor.write(linea);
							escritor.newLine();
							temp = temp.getNext();
					}
			} catch (IOException e) {
					e.printStackTrace();
			}
	}


    public String nombre(int ID) {
			DoubleNode temp = coleccion.first();
	
			while(temp != null && ((Usuario) temp.getData()).getId() != ID) {
				temp = temp.getNext();
			}
			if (temp != null) {
				return ((Usuario) temp.getData()).getNombre();
			}
			return null;
    }

    public void agregar(Mensaje mensaje) {
			if (coleccion.isEmpty()) {
				coleccion.addFirst(mensaje);
			}
			else {
				coleccion.addLast(mensaje);
			}
    }

		public boolean estaVacia() {
			return coleccion.isEmpty();
		}

}

