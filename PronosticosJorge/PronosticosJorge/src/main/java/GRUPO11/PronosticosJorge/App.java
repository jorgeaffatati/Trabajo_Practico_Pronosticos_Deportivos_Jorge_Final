package GRUPO11.PronosticosJorge;
import java.util.ArrayList;

public class App{


		public static Procesador procesador = new Procesador();
		public static boolean hayArgs= true;
		public  ListaRondas listarondas;
		public static void main(String[] args){
			String arg1;
			String arg2;
			 try{
				 arg1= args[0]; // "Pronosticos.csv"
				 arg2= args[1]; // "Resultados.csv"
			      }
			    catch(Exception e){
			  	hayArgs= false;
			  	arg1= "";
			  	arg2= "";
			 };

			System.out.println("Pronósticos Mundial Qatar");
			if (hayArgs) {
				procesador.leerArchivoPronosticos(arg1);
			 	procesador.LeerarchivoResultados(arg2);			
			} else
				
		       procesador.leerArchivoPronosticos("Pronosticos.csv"); 
		       procesador.LeerarchivoResultados("Resultados.csv");
			procesador.Correlation();	
		
			procesador.ShowResultadosDeParticipantes(); 
		}		
}
