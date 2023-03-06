
public class Coche {


	String marca;
	String modelo;
	String color;
	int velocidad;    // En km/hora
	
	
	public Coche(String marca, String modelo, String color) {
		
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.velocidad = 0;  //Inicialmente esta parado
	}	
	
	
	
	/**
	 * @return the marca
	 */
	public String getMarca() {
		return marca;
	}
	/**
	 * @param marca the marca to set
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}
	/**
	 * @return the modelo
	 */
	public String getModelo() {
		return modelo;
	}
	/**
	 * @param modelo the modelo to set
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}
	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}
	/**
	 * @return the velocidad
	 */
	public int getVelocidad() {
		return velocidad;
	}
	/**
	 * @param velocidad the velocidad to set
	 */
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	
	
	
	public void imprime() {
		System.out.println("[ "+ this.marca + "-" + this.modelo + " (" + this.color +") ---> "+ this.velocidad +" Km/h ]");
		
	}
	
	public void acelera(int vel) {
			this.velocidad += vel;
		
	}
	public void frena(int vel) {
			this.velocidad -= vel;
			if(this.velocidad<0) this.velocidad = 0;
		
	}
	public void para(){
		
		this.velocidad = 0;
		
	}
	
	public void pinta() {
		int i=0;
		for(i=0; i<this.velocidad/10; i++) 
			System.out.print(" ");
		System.out.println(" _/ "+ this.marca+"  \\_");

		for(i=0; i<this.velocidad/10; i++) 
			System.out.print(" ");
		System.out.println(" o    o ");
		
		System.out.println();
		
	}
	
	
	
	
	
	
}
