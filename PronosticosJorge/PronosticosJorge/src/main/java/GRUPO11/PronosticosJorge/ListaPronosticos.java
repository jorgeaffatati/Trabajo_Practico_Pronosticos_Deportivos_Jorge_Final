package GRUPO11.PronosticosJorge;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ListaPronosticos{

	
	private ArrayList<Pronostico> listaDePronosticos= new ArrayList<Pronostico>();
	
	private boolean fileOK;


	public ListaPronosticos() {
		
	}

	
	public boolean isFileOK(){
		return fileOK;
	}

	public ArrayList<Pronostico> getListaDePronosticos() {
		return listaDePronosticos;
	}

	public void setListaDePronosticos(ArrayList<Pronostico> listaDePronosticos) {
		this.listaDePronosticos = listaDePronosticos;
	}

}
