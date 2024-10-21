package Mensajeria;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import Agenda.AgendaDoubleList;
import Pack.Usuario;

public class UserPass {

  //atributos
  public AgendaDoubleList usuariosContraseñas;
  private int id;
  private String password;
  private String cargo;



//constructor
  public UserPass(){
      this.usuariosContraseñas = new AgendaDoubleList();
  }

  public UserPass(int id, String password, String cargo){
    this.usuariosContraseñas = new AgendaDoubleList();
    this.id = id;
    this.password = password;
    this.cargo = cargo;
  }


  //gets y setts

  public int getId(){
    return id;
  }
  public void setId(int id){
    this.id = id;
  }

  public String getPassword(){
    return password;
  }
  public void setPassword(String password){
    this.password = password;
  }

  public String getCargo(){
    return cargo;
  }
  public void setCargo(String cargo){
    this.cargo = cargo;
  }

  	//import

    public void importar() {
        try (FileReader lector = new FileReader("/DOCS/Password.txt")) {
        	BufferedReader leer = new BufferedReader(lector);
            String linea;
            while ((linea = leer.readLine()) != null) {
            	String[] informacion = linea.split(" ");
                
              if (informacion.length == 3) {
                
            
                //settear los datos al objeto de tipo usuario
            	  Usuario nuevoUsuario = new Usuario(cambiarStringInt(informacion[0]),informacion[1],informacion[2]);
    
                usuariosContraseñas.agregar(nuevoUsuario);

              }
                
            }             
            
           
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    public void agregar(Usuario u){
      usuariosContraseñas.agregar(u);
      //Actualizar el archivo txt
      usuariosContraseñas.actualizarArchivo();

    }
    public boolean esUser(int ID){
      return usuariosContraseñas.buscarUser(ID) == 1;
    }

  public boolean esAdmin(int ID){
    return usuariosContraseñas.buscarAdmin(ID) == 1;
  }

  public boolean claveCorrecta(String passWord) {
    return usuariosContraseñas.PassCorrect(passWord) == 1;
  }


    private int cambiarStringInt(String h) {
      try {
        int num = Integer.parseInt(h); 
        return num;
      }catch(Exception e) {
        System.err.println("Error");
        return 0;
      }
    }

    public void cambiarClave(int idCambio, String nuevaPass) {
      usuariosContraseñas.CambiarContraseña(idCambio,nuevaPass);

      //Actualizar el archivo txt
      usuariosContraseñas.actualizarArchivo();
    }

    public void eliminar(int idEliminar) {
      usuariosContraseñas.eliminar(idEliminar);
      usuariosContraseñas.actualizarArchivo();
    }
}
