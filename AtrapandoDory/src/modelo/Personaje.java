package modelo;

import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Personaje implements Serializable {

	public static int TAMANIOTABLERO = 650;
	
	private int x;
	private int y;
	private String icono;
	private int ancho;
	private int altura;
	private boolean visible;
	private boolean dory;
	
	public Personaje (int x, int y, String icono, boolean dory ) {
		this.x=x;
		this.y=y;
		this.icono=icono;
		this.dory=dory;
		
		ImageIcon icon = new ImageIcon(icono);
		
		ancho = icon.getIconWidth();
		altura= icon.getIconHeight();
		visible =true;
	}
	
	public int darx() {
		return x;
	}
	
	public int dary() {
		return y;
	}
	
	public String daricono() {
		return icono;
	}
	
	public boolean darvisible() {
		return visible;
	}
	
	public boolean dardory() {
		return dory;
	}
	
	public void setinvisible() {
		visible=false;
	}
	
	public void mover(int velocidad, ArrayList<Personaje> personaje) {
		x += velocidad;
		if (x>TAMANIOTABLERO) {
			visible =false;
		}
	}
	
	public Rectangle2D getforma() {
		return new Rectangle2D.Double (x, y, ancho, altura);
	}
	
	
}
