

public class Atraccion {
	private int id;
	private String nombre;
	private Double costo;
	private Double tiempo;
	private int cupo;
	
	

	public Atraccion(int id, String nombre, double costo, double duracion, int cupo) {
		
		this.id=id;
		this.nombre=nombre;
		this.costo=costo;
		this.tiempo=tiempo;
		this.cupo=cupo;
		
	
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Atraccion [id=" + id + ", nombre=" + nombre + ", costo=" + costo + ", tiempo=" + tiempo + ", cupo="
				+ cupo + "]";
	}
	public Double getCosto() {
		return costo;
	}
	public void setCosto(Double costo) {
		this.costo = costo;
	}
	public Double getTiempo() {
		return tiempo;
	}
	public void setTiempo(Double tiempo) {
		this.tiempo = tiempo;
	}
	public int getCupo() {
		return cupo;
	}
	public void setCupo(int cupo) {
		this.cupo = cupo;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
