package Pack;

public class Usuario {
	//Atributos
	private String nombre;
	private int id;
	private Fecha fecha_nacimiento;
	private String ciudad_nacimiento;
	private long tel;
	private String email;
	private Direccion dir;

	
	//Constructor vacio
	public Usuario() {
		
	}
	//Constructor con parámetros
	public Usuario(String nombre, int id, Fecha fecha_nacimiento,String ciudad_nacimiento,long tel, String email, Direccion dir) {
		this.nombre = nombre;
		this.id = id;
		this.fecha_nacimiento = fecha_nacimiento;
		this.ciudad_nacimiento = ciudad_nacimiento;
		this.tel = tel;
		this.email = email;
		this.dir = dir;
	}
	

	//Gets y Setts
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Fecha getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(Fecha fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	public String getCiudad_nacimiento() {
		return ciudad_nacimiento;
	}
	public void setCiudad_nacimiento(String ciudad_nacimiento) {
		this.ciudad_nacimiento = ciudad_nacimiento;
	}
	public long getTel() {
		return tel;
	}
	public void setTel(long tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Direccion getDir() {
		return dir;
	}
	public void setDir(Direccion dir) {
		this.dir = dir;
	} 
	
	//toString
	 @Override
	    public String toString() {
	            String direccionStr = (dir != null) ? dir.toString1() : "No Dirección";
	            return 
	            		nombre + "," + id + "," + getFecha_nacimiento() + "," + ciudad_nacimiento + "," + tel + "," + email + "," + direccionStr;
	        }
}
	
