

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Turismo {

	public static void main(String[] args) throws SQLException {
		
		UserDAO daoU = new UserDAO(); 
		atraccionDAO daoA = new atraccionDAO();
		ArrayList<Usuario> usuarios = daoU.findAll();
		ArrayList<Atraccion>atracciones =daoA.findAll();
		
		PromocionDAO daoP = new PromocionDAO();
		ArrayList<Promocion> promociones = daoP.findAll();
		System.out.println(usuarios);
		System.out.println(atracciones);	
		System.out.println(promociones);
		//connection.close();
		
		Service datos = new Service();
		datos.cargar();
		ConnectionProvider.close(); //va al final del main
		
		System.out.println();
		System.out.println("			Bienvenido a Turismo en la Tierra Media");
		System.out.println();
		System.out.println("-----------------------------------------------------------------");
		System.out.println();
	
		for(Usuario usr: usuarios) {
		//	ArrayList<Promocion> promociones= datos.getPromociones();
			//listado de las promociones
			//ArrayList<Atraccion> atracciones= datos.getAtracciones(); NO VA MAS ESTO
			
			ArrayList<Atraccion> atraccionesAdquiridas= new ArrayList<Atraccion>(0); 
			//seria las atracciones del itinerario
			Double totalAPagar= 0.0;
			Double duracionTotal=0.0;
			
			
			System.out.println();
			System.out.println("Nombre de visitante: "+usr.getNombre());
			System.out.println();
			
			
				for(Promocion prom: promociones) {
					if(datos.contieneAtraccion(prom.getAtracciones(), atraccionesAdquiridas)
							||
							prom.getTot()>        (usr.getPresupuesto()- totalAPagar) 
							||
							(prom.getTiempoTot() > usr.getTiempoDisponible()-duracionTotal) ){
				
				}
					else {
						System.out.println("Promocion");
						System.out.print("-Atracciones incluidas:  [ ");
						Integer index= prom.getAtracciones().size();
						//cantidad de atracciones de esta promo
						Double precioOriginal= 0.0;
						
						for(Atraccion atr:prom.getAtracciones()) {
							/*iterador que va imprimiendo  cada atraccion de la promo
							 * y va calculando los costos y mostrando los nombres de las atracciones
							 * */
							precioOriginal+=atr.getCosto();
							if(index==1) {
								System.out.println(atr.getNombre()+"]");
							}
							else {	
							System.out.print(atr.getNombre()+", ");
							index--;
							}
							}
						//sale del for e imprime losvalores de la promocion
						System.out.println("-Duraci�n: "+ prom.getTiempoTot());
						System.out.println("-Precio original: "+ precioOriginal);
						System.out.printf("-Precio con descuento:  %.2f", prom.getTot());
						System.out.println();
						int control=0;
						
						while (control==0) {
						System.out.println("Acepta esta promoci�n? ingrese S o N");
						Scanner s = new Scanner(System.in);
						String str = s.nextLine();
						switch(str) {
						case "S":{
							atraccionesAdquiridas.addAll(prom.getAtracciones());
							totalAPagar+= prom.getTot();
							duracionTotal+= prom.getTiempoTot();
							control++;
							System.out.println("�Aceptada!");
							break;
						}
						case "N":{
							
							control++;
							break;
						}
						default: {
							break;
						}
						}
					}	
					}
					
					
					
				}
			
			for (Atraccion atr: datos.quitarAtraccionesAdquiridas(atracciones, atraccionesAdquiridas)) {
				// recorre lista de atracciones a ofrecer, sacando ya las atracciones adquiridas
					if(atr.getTiempo()> 
					(usr.getTiempoDisponible()-duracionTotal)||
					atr.getCosto()>(usr.getPresupuesto()- totalAPagar)) {
						// si no tiene tiempo disponible el usuario 
						// o si no tiene plata el usuario....
						
					}
					else {
						System.out.println("Atracci�n");
						System.out.println("[Nombre: "+atr.getNombre()+"]");
						System.out.println("-Precio: "+atr.getCosto());
						System.out.println("-Duracion: "+atr.getTiempo()+"horas");
						int control=0;
						while (control==0) {
						System.out.println("Acepta esta promoci�n? ingrese S o N");
						Scanner s = new Scanner(System.in);
						String str = s.nextLine();
						switch(str) {
						case "S":{
							atraccionesAdquiridas.add(atr);
							totalAPagar+= atr.getCosto();
							duracionTotal+= atr.getTiempo();
							control++;
							System.out.println("�Aceptada!");
							break;
						}
						case "N":{
							
							control++;
							break;
						}
						default: {
							break;
						}
						}
					}
					}
			}
			
		
		    try {
		        File myObj = new File("src/"+usr.getNombre()+".txt");
		        if (myObj.createNewFile()) {
//		          System.out.println("File created: " + myObj.getName());
		        } else {
//		          System.out.println("File already exists.");
		        }
		      } catch (IOException e) {
		        System.out.println("An error occurred.");
		        e.printStackTrace();
		      }
		    
		    
		    	  try {
		    		  FileWriter fw = new FileWriter("src/"+usr.getNombre()+".txt");
					  
		    			fw.write("Nombre: "+usr.getNombre()+"\n");
		    			fw.write("PresupuestoInicial: "+usr.getPresupuesto()+"\n");
		    			fw.write("TiempoDisponible: "+usr.getTiempoDisponible()+"\n");
		    			fw.write("Atracciones adquiridas: "+"\n");
		    		  for (Atraccion atr: atraccionesAdquiridas) {
							fw.write(atr.getNombre()+"\n");
							
		    		  }
		    		  fw.write("Precio total a pagar: "+totalAPagar+" monedas de oro"+"\n");
		    		  fw.write("Duraci�n total de las atracciones: "+duracionTotal+" Horas"+"\n");
		    			fw.close();
		    	    } catch (IOException e) {
		    	      System.out.println("An error occurred.");
		    	      e.printStackTrace();
		    	    }
		    
		}
		
	}
}
