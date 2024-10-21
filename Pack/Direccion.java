package Pack;

public class Direccion {
	//atributos
	private String calle;
	private String nomenclatura;
	private String barrio;
	private String ciudad;
	public String edificio;
	public String apto;
	
	//constructor sin apto y edificio
	public Direccion(String calle, String nomenclatura, String barrio, String ciudad) {
		this.calle = calle;
		this.nomenclatura = nomenclatura;
		this.barrio = barrio;
		this.ciudad = ciudad;
	}
	
	//Constructor con todo
	public Direccion(String calle, String nomenclatura, String barrio, String ciudad, String edificio, String apto) {
		this.calle = calle;
		this.nomenclatura = nomenclatura;
		this.barrio = barrio;
		this.ciudad = ciudad;
		this.edificio = edificio;
		this.apto = apto;
	}
	
	//gets y setts
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getNomenclatura() {
		return nomenclatura;
	}
	public void setNomenclatura(String nomenclatura) {
		this.nomenclatura = nomenclatura;
	}
	public String getBarrio() {
		return barrio;
	}
	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getEdificio() {
		return edificio;
	}
	public void setEdificio(String edificio) {
		this.edificio = edificio;
	}
	public String getApto() {
		return apto;
	}
	public void setApto(String apto) {
		this.apto = apto;
	}
	
	//toString
	public String toString1() {
		return 
				ciudad+" "+calle+" "+nomenclatura+" "+barrio+" "+edificio+" "+apto;
				
	}
	public String toString2() {
		return 
				ciudad+" "+calle+" No."+nomenclatura+" "+barrio;
				
	}

	public static Direccion CambiarStringADir(String direc) {
		String[] direcc = direc.split(" ");
		Direccion dir = new Direccion(direcc[0],direcc[1],direcc[2],direcc[3],direcc[4],direcc[5]);
		return dir;
	}

}
