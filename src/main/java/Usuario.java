

public class Usuario {
	private int id;
	private String nombre;
	private double presupuesto;
	private double tiempoDisponible;
	
	
	
	public Usuario(int id, String nombre, double presupuesto, double tiempoDisponible) {
		this.id = id;
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
	}
	public int getId() {
		return id;
	}
	public void setId(int i) {
		this.id = i;
	}
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", presupuesto=" + presupuesto + ", tiempoDisponible="
				+ tiempoDisponible + "]";
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPresupuesto() {
		return presupuesto;
	}
	public void setPresupuesto(double presupuesto) {
		this.presupuesto = presupuesto;
	}
	public double getTiempoDisponible() {
		return tiempoDisponible;
	}
	public void setTiempoDisponible(double tiempoDisponible) {
		this.tiempoDisponible = tiempoDisponible;
	}
	
	
}
