package Mensajeria;

public class Mensaje {
   //atributos
   private int idDestinatario;
   private String titulo;
   private String cuerpoMensaje;
   private String fechaHora;
   private String remitente;
 
   //constructor
   public Mensaje(){
 
   }
 
   public Mensaje(String remitente,int idDestinatario, String titulo, String cuerpoMensaje, String fechaHora){
     this.idDestinatario = idDestinatario;
     this.titulo = titulo;
     this.cuerpoMensaje = cuerpoMensaje;
     this.fechaHora = fechaHora;
     this.remitente = remitente;
   }
 
   //gets y setts
   public int getIdDestinatario(){
     return idDestinatario;
   }
   public void setIdDestinatario(int idDestinatario){
     this.idDestinatario = idDestinatario;
   }
   public String getTitulo(){
     return titulo;
   }
   public void setTitulo(String titulo){
     this.titulo = titulo;
   }
   public String getCuerpoMensaje(){
     return cuerpoMensaje;
   }
 public void setCuerpoMensaje(String cuerpoMensaje){
   this.cuerpoMensaje = cuerpoMensaje;
 }
 public String getFechaHora(){
   return fechaHora;
 }
 public void setLocalDateTime(String fechaHora){
   this.fechaHora = fechaHora;
 }
 
 public String getRemitente(){
   return remitente;
 }
 public void setRemitente(String remitente){
   this.remitente = remitente;
 }
 
 public String toString(){
   return
     "======================================================"+ "\n" +
     "De: "+ getRemitente() + "\n"+
     "Para: " + getIdDestinatario() + "\n"+
     "Enviado " + getFechaHora() + "\n"+
     "Título: " + getTitulo() + "\n" +
     getCuerpoMensaje() + "\n" +
     "======================================================";
     
 }
}
