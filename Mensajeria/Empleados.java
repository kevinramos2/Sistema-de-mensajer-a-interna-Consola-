package Mensajeria;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import Agenda.AgendaDoubleList;
import Pack.Direccion;
import Pack.Fecha;
import Pack.Usuario;

public class Empleados  {

  public AgendaDoubleList empleados;

    public Empleados(){
      this.empleados = new AgendaDoubleList();
    }

   

  	//import

    public void importar() {
        try (FileReader lector = new FileReader("Empleados.txt")) {
        	BufferedReader leer = new BufferedReader(lector);
            String linea;
            while ((linea = leer.readLine()) != null) {
            	String[] informacion = linea.split(" ");
                
                //settear los datos al objeto de tipo usuario
            	Usuario nuevoUsuario = new Usuario();
            	
                nuevoUsuario.setNombre(informacion[0]);
                nuevoUsuario.setId(cambiarStringInt(informacion[1]));


                Fecha fecha1 = new Fecha(StringAShort(informacion[2]),StringAShort(informacion[3]),StringAShort(informacion[4]));
                nuevoUsuario.setFecha_nacimiento(fecha1);
                nuevoUsuario.setCiudad_nacimiento(informacion[5]);
                nuevoUsuario.setTel(CambiarStringaLong(informacion[6]));
                nuevoUsuario.setEmail(informacion[7]);


                if (informacion[12] == null && informacion[13] == null){
                  nuevoUsuario.setDir(Direccion.CambiarStringADir(direccionSinEdificio(informacion[8], informacion[9], informacion[10], informacion[11])));
                }
                else{
                  nuevoUsuario.setDir(Direccion.CambiarStringADir(direccionConEdificio(informacion[8], informacion[9], informacion[10], informacion[11], informacion[12], informacion[13])));
                }
                
                empleados.agregar(nuevoUsuario);
                empleados.ordenarMenorAMayor();
                
            }
           
           
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static short StringAShort(String shortinp) {
      try {
        short num = Short.parseShort(shortinp); 
        return num;
      }catch(Exception e) {
        System.err.println("Error");
        return 0;
    }
  }

    public String direccionSinEdificio(String calle, String nomenclatura, String barrio, String ciudad){
      Direccion dir = new Direccion(calle, nomenclatura, barrio, ciudad);
      return dir.toString2();
    }

    public String direccionConEdificio(String calle, String nomenclatura, String barrio, String ciudad, String edificio, String apto){
      Direccion dir = new Direccion(calle, nomenclatura, barrio, ciudad,edificio,apto);
      return dir.toString1();
    }

    private long CambiarStringaLong(String h) {
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
    



    public void agregar(Usuario nuevoUsuario) {
      empleados.agregar(nuevoUsuario);
      empleados.ordenarMenorAMayor();
      empleados.actualizarArchivoEmpleados();
    }
    
    public void eliminar(int idEliminar) {
        empleados.eliminar(idEliminar);
        empleados.actualizarArchivoEmpleados();
    }

    public String nombre(int ID) {
      return empleados.nombre(ID);
    } 
}
