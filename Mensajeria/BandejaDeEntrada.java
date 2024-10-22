package Mensajeria;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import ListaDoble.DoubleList;
import ListaDoble.DoubleNode;

public class BandejaDeEntrada {
      private DoubleList mensajesXUsuario;
    private int ID;

    public BandejaDeEntrada(int ID) {
        this.mensajesXUsuario = new DoubleList();
        this.ID = ID;
        cargarMensajesDesdeArchivo(); // Cargar los mensajes desde el archivo al crear la bandeja
    }

    // Agrega un mensaje a la bandeja y al archivo de texto correspondiente
    public void agregar(Mensaje mensaje) {
        mensajesXUsuario.addLast(mensaje);
        guardarMensajeEnArchivo(mensaje);
    }

    // Guarda el mensaje en el archivo de texto correspondiente a la bandeja de entrada
    private void guardarMensajeEnArchivo(Mensaje mensaje) {
      try (FileWriter fw = new FileWriter(ID + "BA.txt", true)) {
          fw.write(mensaje.getRemitente() + "\n");
          fw.write(mensaje.getFechaHora() + "\n");
          fw.write(mensaje.getTitulo() + "\n");
          fw.write(mensaje.getCuerpoMensaje() + "\n");
          fw.write("===\n"); // Separador entre mensajes
      } catch (IOException e) {
          System.out.println("Error al guardar el mensaje: " + e.getMessage());
      }
  }

    // Carga los mensajes desde el archivo de texto a la lista de la bandeja
    private void cargarMensajesDesdeArchivo() {
      File archivo = new File(ID + "BA.txt");
      if (!archivo.exists()) {
          System.out.println("No hay mensajes en la bandeja de entrada.");
          return;
      }
  
      try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
          String remitente;
          while ((remitente = lector.readLine()) != null) {
              String fechaHora = lector.readLine();
              String titulo = lector.readLine();
              String cuerpoMensaje = lector.readLine();
              lector.readLine(); // Leer y descartar la línea de separación "==="
  
              Mensaje mensaje = new Mensaje(remitente, ID, titulo, cuerpoMensaje, fechaHora);
              mensajesXUsuario.addLast(mensaje);
          }
      } catch (IOException e) {
          e.printStackTrace();
      }
  }

    // Muestra los mensajes de la bandeja de entrada
    public void mostrarBandejaDeEntrada() {
        DoubleNode temp = mensajesXUsuario.first();
        int index = 1;
        while (temp != null) {
            Mensaje mensaje = (Mensaje) temp.getData();
            System.out.println("[" + index + "] " + mensaje.getFechaHora() + " - " + mensaje.getTitulo() + " - " + mensaje.getRemitente());
            temp = temp.getNext();
            index++;
        }
    }

    // Muestra el contenido completo de un mensaje seleccionado por su índice
    public void leerMensaje(int index) {
        DoubleNode temp = mensajesXUsuario.first();
        int currentIndex = 1;
        while (temp != null) {
            if (currentIndex == index) {
                Mensaje mensaje = (Mensaje) temp.getData();
                System.out.println(mensaje.toString());
                return;
            }
            temp = temp.getNext();
            currentIndex++;
        }
        System.out.println("Mensaje no encontrado.");
    }
}
