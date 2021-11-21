

import java.util.ArrayList;

	public class Promocion {
	private int id;
	private String nombre;
	private String tipo;
	private Double descuento;
	private Double tot; //el precio de la promocion
	private ArrayList<Atraccion> atracciones= new ArrayList<Atraccion>(0);
	private Double tiempoTot;
	
	public Promocion(int id, String nombre, String tipo, double descuento, double precio) {
		this.id=id;
		this.nombre=nombre;
		this.tipo=tipo;
		this.descuento=descuento;
		this.tot=precio;
		
		
	}
	@Override
	public String toString() {
		return "Promocion [id=" + id + ", nombre=" + nombre + ", tipo=" + tipo + ", descuento=" + descuento + ", tot="
				+ tot + ", atracciones=" + atracciones + ", tiempoTot=" + tiempoTot + "]";
	}
	public Double getDescuento() {
		return descuento;
	}
	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}

	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Double getTiempoTot() {
		return tiempoTot;
	}
	public void setTiempoTot(Double tiempoTot) {
		this.tiempoTot = tiempoTot;
	}
	public Double getTot() {
		return tot;
	}
	public void setTot(Double tot) {
		this.tot = tot;
	}
	public ArrayList<Atraccion> getAtracciones() {
		return atracciones;
	}
	public void setAtracciones(ArrayList<Atraccion> atracciones) {
		this.atracciones = atracciones;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public void agregarAtraccion(Atraccion atr) {
		this.atracciones.add(atr);
	}
}
