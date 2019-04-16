package modelo;

public class Jugador {

	private String nickname;
	private int puntos;
	
	public Jugador () {
	}
	
	public Jugador (String nick, int puntos) {
		nickname = nick;
		this.puntos=puntos;
	}
	
	public String darnick() {
		return nickname;
	}
	public void setnick(String nickname) {
		this. nickname=nickname;
	}
	
	public int darpuntos() {
		return puntos;
	}
	
	public void setpuntos (int puntos) {
		this.puntos=puntos;
	}
}
