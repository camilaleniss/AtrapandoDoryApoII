package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.*;
import control.HiloJuego;
import control.HiloMover;
import modelo.Juego;
import modelo.NotFoundException;

public class Ventana extends JFrame{

	private Juego juego;
	
	private PanelBotones panelbotones;
	private PanelInfo panelinfo;
	private PanelJuego paneljuego;
	
	private HiloMover hilomover;
	private HiloJuego hilojuego;
	
	public Ventana() {
		setTitle("Atrapando a Dory");
		setSize(600, 670);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(	new	BorderLayout());
		this.getContentPane().setBackground(Color.WHITE);

		
		juego = new Juego ();
		
		panelbotones = new PanelBotones (this);
		panelinfo = new PanelInfo (juego.darpuntos(), juego.darlevel());
		paneljuego = new PanelJuego (this);
		
		add(panelinfo, BorderLayout.CENTER);
		add(paneljuego, BorderLayout.NORTH);
		add(panelbotones, BorderLayout.SOUTH);
		
		hilomover = new HiloMover(this, juego);
		hilojuego = new HiloJuego(this, juego);
		
	}
	
	public Juego darjuego() {
		return juego;
	}
	
	public static void main (String [] args) {
		Ventana ven = new Ventana();
		ven.setVisible(true);
	}
	
	public void setnickname(String nick) {
		panelinfo.setNick(nick);
		juego.darjugador().setnick(nick);
	}
	
	public void iniciarjuego() {
		panelinfo.setNivel(juego.darlevel());
		panelinfo.setPuntos(juego.darpuntos());
		panelinfo.setNick(juego.darjugador().darnick());
		
		hilojuego.start();
		hilomover.start();
	}
	
	public void atraparpersonaje (int x, int y) {
		juego.atraparpez(x, y);
		panelinfo.refresh(juego.darpuntos(), juego.darlevel());
	}
	
	public void guardarpartida() throws Exception{
		juego.añadirjugador();
		juego.guardarpartida();
		juego.guardardatos();
	}
	
	public void recuperarjuego() throws Exception{
		juego.recuperardatos();
		juego.recuperarpartida();
	}
	
	public void buscar (int i) {
		juego.ordenarpuntaje();
		try {
			String jugador =juego.buscarjugador(i);
			JOptionPane.showMessageDialog(null, "El jugador "+jugador+" tiene ese puntaje");
		}catch (NotFoundException e) {
			JOptionPane.showMessageDialog(this, "No un jugador con ese puntaje ", "Warning", JOptionPane.WARNING_MESSAGE);
		}
	}
	
}
