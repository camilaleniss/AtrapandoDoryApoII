package control;

import interfaz.Ventana;
import modelo.Juego;

public class HiloJuego extends Thread{

	private Ventana ventana;
	private Juego juego;
	
	public HiloJuego(Ventana ventana, Juego juego) {
		this.ventana=ventana;
		this.juego=juego;
	}
	
	public void run() {
		while(true) {
			juego.crearpez();
			ventana.repaint();
			try {
				Thread.sleep(200);
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		
	}
}

