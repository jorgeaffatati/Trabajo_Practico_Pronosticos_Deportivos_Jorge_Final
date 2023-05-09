package GRUPO11.PronosticosJorge;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Ronda{
	private boolean fileOK;    //Todo bien con el archivo
	private ArrayList<Partido> partidos= new ArrayList<Partido>();
	private String nro;
	private int  puntaje;
	
     public Ronda() {
    	   	 
     }
	public ArrayList<Partido> getPartidos(){
		return partidos;
	}

	public boolean allOK(){
		return fileOK;
	}
	public String getNro() {
		return nro;
	}
	public void setNro(String nro) {
		this.nro = nro;
	}
	public int getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

}
