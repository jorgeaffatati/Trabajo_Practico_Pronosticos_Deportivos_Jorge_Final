package GRUPO11.PronosticosJorge;

public class Participante{
	private String nombreParticipante;

	private int puntosAcumulados;
	
	public Participante(String nombreParticipante){
		super();
		this.nombreParticipante = nombreParticipante;
		this.puntosAcumulados= 0;
	}
 
	public Participante() {
		// TODO Auto-generated constructor stub
	}

	public String getNombreParticipante() {
		return nombreParticipante;
	}

	public void setNombreParticipante(String nombreParticipante) {
		this.nombreParticipante = nombreParticipante;
	}

	public int getPuntosAcumulados() {
		return puntosAcumulados;
	}

	public void setPuntosAcumulados(int puntosAcumulados) {
		this.puntosAcumulados = puntosAcumulados;
	}
	
}
