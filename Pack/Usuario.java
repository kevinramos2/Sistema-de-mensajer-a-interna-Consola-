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
	private int num;
	private String password;
	private String cargo;


	
	//Constructor vacio
	public Usuario() {
		
	}

	//Constructor para el cargo
	public Usuario(int id, String password, String cargo){
		this.id = id;
		this.password = password;
		this.cargo = cargo;
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
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	//toString
	 @Override
	    public String toString() {
	        // Verifica si el objeto Usuario solo tiene el número
	        if (nombre == null && id == 0 && fecha_nacimiento == null && ciudad_nacimiento == null && tel == 0 && email == null && dir == null) {
	            return 
	            		String.valueOf(num);
	        } else {
	            String direccionStr = (dir != null) ? dir.toString1() : "No Dirección";
	            return 
	            		nombre + "," + id + "," + getFecha_nacimiento() + "," + ciudad_nacimiento + "," + tel + "," + email + "," + direccionStr;
	        }
	    }
	

	public String toString3(){
		return 
		id + "," + password +"," + cargo; 
	}
}
