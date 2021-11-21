

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Service {
	private ArrayList<Atraccion> atracciones = new ArrayList<Atraccion>(0);
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>(0);
	private ArrayList<Promocion> promociones = new ArrayList<Promocion>(0);

	public ArrayList<Atraccion> getAtracciones() {
		return atracciones;
	}

	public void setAtracciones(ArrayList<Atraccion> atracciones) {
		this.atracciones = atracciones;
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public ArrayList<Promocion> getPromociones() {
		return promociones;
	}

	public void setPromociones(ArrayList<Promocion> promociones) {
		this.promociones = promociones;
	}

	public boolean contieneAtraccion(ArrayList<Atraccion> array1, ArrayList<Atraccion> array2) {
	      
	    // Loop for array1
	    for(int i = 0; i < array1.size(); i++) {
	          
	        // Loop for array2
	        for(int j = 0; j < array2.size(); j++) {
	              
	            // Compare the element of each and
	            // every element from both of the
	            // arrays
	            if(array1.get(i) == array2.get(j)) {
	              
	                // Return if common element found
	                return true;
	            }
	        }
	    }
	      
	    // Return if no common element exist
	    return false; 
	}

	
	public Atraccion buscarAtraccion(String atraccion ) {
	for(Atraccion atrac : atracciones) {
		if(atrac.getNombre().equals(atraccion)) {
			return atrac;
		}
	}
	return null;

}

	public ArrayList<Promocion> ordenarPromociones(double oro, double tiempo){
		
		ArrayList<Promocion> listaProm = this.promociones.stream().sorted((o1, o2)->o2.getTiempoTot().
                compareTo(o1.getTiempoTot())).
                collect(Collectors.toCollection(ArrayList::new));
		 listaProm = listaProm.stream().sorted((o1, o2)->o2.getTot().
                compareTo(o1.getTot())).
                collect(Collectors.toCollection(ArrayList::new));
		for(Promocion prom: listaProm) {
			if(prom.getTot()>oro || prom.getTiempoTot()>tiempo ) {
				listaProm.remove(prom);
			}
		}
		
		return listaProm;
	}

	public ArrayList<Atraccion> ordenarAtracciones(double oro, double tiempo){
		ArrayList<Atraccion> listaAtr = this.atracciones.stream().sorted((o1, o2)->o2.getTiempo().
                compareTo(o1.getTiempo())).
                collect(Collectors.toCollection(ArrayList::new));
		 listaAtr = listaAtr.stream().sorted((o1, o2)->o2.getCosto().
                compareTo(o1.getCosto())).
                collect(Collectors.toCollection(ArrayList::new));
		for(Atraccion atr: listaAtr) {
			if(atr.getCosto()>oro || atr.getTiempo()>tiempo ) {
				listaAtr.remove(atr);
			}
		}
		
		return listaAtr;
	}


	public ArrayList<Atraccion> quitarAtraccionesAdquiridas(ArrayList<Atraccion> atraccionesAOfrecer, ArrayList<Atraccion> atraccionesAdquiridas){
		atraccionesAOfrecer.removeAll(atraccionesAdquiridas);
		return atraccionesAOfrecer;
	}
	
	

	
	
}
