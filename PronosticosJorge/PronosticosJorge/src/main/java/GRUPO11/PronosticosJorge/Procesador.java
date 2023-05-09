package GRUPO11.PronosticosJorge;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Procesador{

	private int cantidadDeParticipantes;
	private int cantidadDePartidos;

	public static ArrayList<Partido> todosLosPartidos = new ArrayList<Partido>();
	public static ArrayList<Pronostico> pronosticos = new ArrayList<Pronostico>();
	public static ListaParticipantes listaparticipantes = new ListaParticipantes();

	public static ListaRondas listarondas = new ListaRondas();

	public Procesador(){
	
	}

	public void leerArchivoPronosticos(String archivoDePronosticos)
	{
		
			Path path = Paths.get(archivoDePronosticos);
			boolean exists = Files.exists(path);
			List<String> pronosticos = null; 
			
			if (exists) {
			try {
				pronosticos = Files.readAllLines(path);
				for (int i=0; i<pronosticos.size(); i++){ 
			       	
			        String[] datos = pronosticos.get(i).split(";");

			        String nombreParticipante = datos[0]; 		
			        int idPartido = Integer.parseInt(datos[1]); 
			        int apuesta = Integer.parseInt(datos[2]); 	
			        Pronostico pronostico= new Pronostico(nombreParticipante, idPartido, intToEnum(apuesta));
			        this.listaparticipantes.addParticipante(nombreParticipante); 
			        if (pronostico!=null) {

			        	this.pronosticos.add(pronostico);
			        }
				}
			} catch(IOException e){
				exists= false;
				System.out.println("El archivo de datos ["+archivoDePronosticos+"] ES INVALIDO.");
			}
		}
			else System.out.println("El archivo de datos ["+archivoDePronosticos+"] NO EXIXTE.");
			
			System.out.println( "El total de participantes: " +this.listaparticipantes.getCantidadParticipantes());
					
	}   

	public int getCantidadDePartidos(){
		int cantidadDePartidos = this.todosLosPartidos.size();
		return cantidadDePartidos;
	}

	public int getCantidadDeParticipantes() {
		int  cantidadDeParticipantes =  this.listaparticipantes.getCantidadParticipantes();
		return cantidadDeParticipantes;
	}
	
	public int getCantidadDeRondas() {
		int cantidadDeRondas = this.listarondas.getListarondas().size();
		
		return cantidadDeRondas;
	}
	public ArrayList<Partido> getTodosLosPartidos(){
		return this.todosLosPartidos;
	}
	
	public void setPronosticos(ArrayList<Pronostico> pronosticos){
		this.pronosticos = pronosticos;
	}

//Este método recorre los pronósticos y busca la apuesta por Partido para darle puntaje a los Participantes.
	
	public void Correlation(){
		
// Se recorre la lista de pronósticos mirando partidos y participantes,
// si el resultado del partido coincide con la apuesta del participante se le suma 1 al puntaje de este último.
		
		for (int i=0; i<pronosticos.size(); i++) {
			Pronostico prono = pronosticos.get(i);
	        String nombrePartic = prono.getParticipante();
	    	int idPartido= prono.getIdDelPartido();
		
	        	boolean encontrado = false;
	        	int j=0; //ahora buscamos en el listado de partidos el que corresponde a este pronóstico
	        	while (j<todosLosPartidos.size() && !encontrado){
	        		encontrado = (todosLosPartidos.get(j).getId()==idPartido);
	        		if (!encontrado) j++;
	        	} 
//Habiendo encontrado el partido vemos si la apuesta del participante es igual al resultado del partido.
	        	
	     if (encontrado) {
	     if (todosLosPartidos.get(j).getResultado().equals(prono.getApuesta())){
	              for (int r = 0;r< this.listaparticipantes.getCantidadParticipantes(); r++)
	              {
	            	  if (nombrePartic.equals(this.listaparticipantes.getParticipante(r).getNombreParticipante()))
	            	  {
	            		   int puntos = this.listaparticipantes.getParticipante(r).getPuntosAcumulados();
	            		  this.listaparticipantes.getParticipante(r).setPuntosAcumulados(1+ puntos );
	            	  }
	              }
	    	 
	        		}
	        	}
	        }
		}
	
// Se construye una lista con todos los partidos de todas las rondas que se pasa como un ArrayList de Strings
	
	public void LeerarchivoResultados(String archivoResultados){
		String [] totalrondas = {"1","2"};
		 String[] datos = null; 
		String [] datosant = null;
		Ronda rondaant = null;
		 String nroronda =null;
		 Ronda  ronda = null;
		int i = 0;
		int aux = 0;
		 int j =0;
		int idpartido = 0;
		boolean control = false;
		Path path = Paths.get(archivoResultados);
		boolean exists = Files.exists(path);
		List<String> partidosDeLaRonda = null; 
		 String nroronant;
		if (exists){
		try{
			partidosDeLaRonda = Files.readAllLines(path);
				
			while( i< partidosDeLaRonda.size()){ 
					
		      if (control == false) {
		    	  
		    	  if (datosant != null ) {
		    		  ronda = new Ronda();
		    			idpartido = 0;	
		    		  
					    nroronant = datosant[0];
					    ronda.setNro( nroronant);       
					    idpartido = Integer.parseInt(datos[1]);
				        Equipo equipo1 = new Equipo(datosant[2], 0);        
				        Equipo equipo2 = new Equipo(datosant[5], 0);         
				        Partido partido= new Partido( idpartido,equipo1, equipo2, Integer.parseInt(datosant[3]), Integer.parseInt(datosant[4]));
				        control = true;
				        if (partido!=null) {
				        ronda.getPartidos().add(partido);
								        
				        }
					
				   	datosant = null;
				
				}
		    	  
		    	  else {  
		    	  
		    		  datos = partidosDeLaRonda.get(i).split(",");
					  nroronda = datos[0]; 	    	  
					  ronda = new Ronda();
					  ronda.setNro(nroronda);
				  					
		    	  }
		      }
		      			      
				if (i == partidosDeLaRonda.size()-1) {
					 datos = partidosDeLaRonda.get(i).split(",");
					 nroronda = datos[0];
					
					  ronda.setNro(nroronda);		       
				        idpartido = Integer.parseInt(datos[1]);
				        Equipo equipo1 = new Equipo(datos[2], 0);          
				        Equipo equipo2 = new Equipo(datos[5], 0);         
				        Partido partido= new Partido( idpartido,  equipo1, equipo2, Integer.parseInt(datos[3]), Integer.parseInt(datos[4]));
				        
				        if (partido!=null) {
				        ronda.getPartidos().add(partido);
										        
				        }
				        this.listarondas.getListarondas().add(ronda);
				        i=partidosDeLaRonda.size(); 
				        control = false;
				    
				}
				else {
				if (control) {
				datos = partidosDeLaRonda.get(i).split(",");
				nroronda = datos[0]; 
				 }
			   if (nroronda.equals(totalrondas[j]))
			     {
		        control = true;		     	       
		        idpartido = Integer.parseInt(datos[1]);
		        Equipo equipo1 = new Equipo(datos[2], 0); //El ID es cero porque no viene en el archivo.
		        Equipo equipo2 = new Equipo(datos[5], 0); //El ID es cero porque no viene en el archivo.
		        Partido partido= new Partido( idpartido,  equipo1, equipo2, Integer.parseInt(datos[3]), Integer.parseInt(datos[4]));
		        
		        if (partido!=null) {
		        ronda.getPartidos().add(partido);						        
		        }
			   }
			   else {
				this.listarondas.getListarondas().add(ronda);   
			 
			   datosant = datos;
		       control = false;
		    
		       if ( j< totalrondas.length) {
		    	   j = j +1;  
			}
			   }
				 }
				
			   i = i + 1;
		} System.out.println("Total de rondas: "+listarondas.getListarondas().size());
		 int totalpartidos = 0;
		   for ( j = 0; j < listarondas.getListarondas().size(); j++)
			     
		   {     for (i =0; i < listarondas.getListarondas().get(j).getPartidos().size(); i++  ) 
		        {
			     Partido partido = listarondas.getListarondas().get(j).getPartidos().get(i);
			     this.todosLosPartidos.add(partido);		 
			    		 
		        }
		          totalpartidos = totalpartidos +  listarondas.getListarondas().get(j).getPartidos().size();
			   
		   }
		   System.out.println("Total de partidos: "+ totalpartidos);
			}
	
		catch(IOException e) {
			exists = false;
			System.out.println("EL ARCHIVO ES INVALIDO");
		}
	} 
		else System.out.println("EL ARCHIVOS DE DATOS ES INEXISTENTE");
	}           //FIN DE loadRonda

	public void setPartidos(ArrayList<Partido> partidos) {
		this.todosLosPartidos = partidos;
	}
			
// Este método muestra los datos relevantes de los participantes a partir de la lista generada por ListaParticipantes.
	
	public void ShowResultadosDeParticipantes() {
		System.out.println(this.listaparticipantes.getCantidadParticipantes()+" participantes");

//Se recorren toda la lista de participantes para mostrar sus puntos acumulados.
		
		for (int i=0; i<this.listaparticipantes.getCantidadParticipantes(); i++){
			Participante partic = this.listaparticipantes.getParticipante(i);
			if (partic!=null)
		    System.out.println(i+1+") "+partic.getNombreParticipante()+" tiene "+partic.getPuntosAcumulados()+" puntos acumulados");
		}		
	}
	
	public static ResultEnum intToEnum(int valor){
		if (valor==0){
			return ResultEnum.EMPATE;
		}
		else if (valor==1){
			return ResultEnum.GANA_EQUIPO1;
		}
		else if (valor==2){
			return ResultEnum.GANA_EQUIPO2;
		}
		return null;

	}
	
}
