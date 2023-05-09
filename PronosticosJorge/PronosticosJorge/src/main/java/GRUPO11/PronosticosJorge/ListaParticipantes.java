package GRUPO11.PronosticosJorge;

import java.util.ArrayList;

public class ListaParticipantes{
	private ArrayList<Participante> listapart = new ArrayList<Participante>();  
	
	public ListaParticipantes(){
	
	}
	
//Agrega un Participante sólo si es alguien nuevo y no se encuentra en la lista.
	
	public void addParticipante(String nombre){ 
		boolean founded= false;
		int i=0;
		while (i<this. listapart.size() && !founded){
			founded = this. listapart.get(i).getNombreParticipante().equals(nombre);
			i++;
		}
		if (!founded){
			Participante parti = new Participante(nombre);
			this.listapart.add(parti);
			//System.out.println("Agregamos a "+parti.getNombreParticipante());
		}
	}

	public int getCantidadParticipantes() {
		return this.listapart.size();
	}

	public Participante getParticipante(int posicion) {
		if (posicion>=0 && posicion<this. listapart.size()) {
			return this.listapart.get(posicion);
		}
		return null;
	}
	
}
