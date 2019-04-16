package control;

import interfaz.Ventana;
import modelo.Juego;

public class HiloMover extends Thread{

	private Ventana ventana;
	private Juego juego;
	
	public HiloMover(Ventana ventana, Juego juego) {
		this.ventana=ventana;
		this.juego=juego;
	}
	
	public void run() {
		while(true) {
			juego.moverpersonajes();
			ventana.repaint();	
			try {
				Thread.sleep(50);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
}
