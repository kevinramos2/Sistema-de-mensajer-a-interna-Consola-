package Pack;

public class Fecha {
	//Atributos
	private short dd;
	private short mm;
	private short aa;

	
	//Constructor vacio
	public Fecha() {
		
	}
	
	//Constructor
	public Fecha(short dd, short mm, short aa) {
		this.dd = dd;
		this.mm = mm;
		this.aa = aa;
	}
	
	//Gets y Setts
	public short getDd() {
		return dd;
	}
	public void setDd(short dd) {
		this.dd = dd;
	}
	public short getMm() {
		return mm;
	}
	public void setMm(short mm) {
		this.mm = mm;
	}
	public short getAa() {
		return aa;
	}
	public void setAa(short aa) {
		this.aa = aa;
	}
	
	//toString 
	public String toString() {
		return 
				dd+" "+mm+" "+aa;
	}

	public static Fecha StringAFecha(String fechainp) {
		String[] fec = fechainp.split("-");
		Fecha fecha1 = new Fecha(StringAShort(fec[0]),StringAShort(fec[1]),StringAShort(fec[2]));
		return fecha1;
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
	





}
