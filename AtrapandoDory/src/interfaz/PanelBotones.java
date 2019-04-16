package interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanelBotones extends JPanel implements ActionListener{

	public static String GUARDAR = "guardar";
	public static String INICIAR = "iniciar";
	public static String BUSCAR = "buscar";
	public static String ORDENAR = "ordenar";
	
	private Ventana ventana;
	
	private JButton butiniciar;
	private JButton butguardar;
	private JButton butbuscar;
	private JButton butordenar;
	
	public PanelBotones(Ventana ventana) {
		this.ventana=ventana;
		
		setLayout(new GridLayout (1,3));
		setPreferredSize(new Dimension(600,50));
		setBackground(Color.WHITE);
		
		butiniciar = new JButton ("Iniciar");
		butiniciar.setActionCommand(INICIAR);
		butiniciar.addActionListener(this);
		butiniciar.setBackground(Color.lightGray);
		
		butguardar = new JButton ("Guardar");
		butguardar.setActionCommand(GUARDAR);
		butguardar.addActionListener(this);
		butguardar.setBackground(Color.lightGray);
		
		butordenar = new JButton ("Puntajes");
		butordenar.setActionCommand(ORDENAR);
		butordenar.addActionListener(this);
		butordenar.setBackground(Color.lightGray);
		
		butbuscar = new JButton ("Buscar");
		butbuscar.setActionCommand(BUSCAR);
		butbuscar.addActionListener(this);
		butbuscar.setBackground(Color.lightGray);
		
		Font negrita;
		negrita = new Font("Bookman Old Style", Font.BOLD, 16);
		
		butiniciar.setFont(negrita);
		butguardar.setFont(negrita);
		butordenar.setFont(negrita);
		butbuscar.setFont(negrita);
		
		add(butiniciar);
		add(butguardar);
		add(butordenar);
		add(butbuscar);
	}

	@Override
	public void actionPerformed(ActionEvent evento)  {
		String	comando	= evento.getActionCommand();
		
		if(	comando.equals(INICIAR)){
			iniciarjuego();	
		}
		
		if(	comando.equals(GUARDAR)){
			guardarjuego();
		}
		
		if (comando.equals(ORDENAR)) {
			ordenar();
		}
		
		if (comando.equals(BUSCAR)) {
			buscar();
		}
	}
	
	public void iniciarjuego() {
		
		try {
			int opcion = JOptionPane.showOptionDialog(null, "BIENVENIDO A BUSCANDO A DORY", "Inicio",
					JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null, new String [] {"Nueva Partida", "Cargar partida"}, null);
			
			if (opcion==0) {
				//nueva partida
				String i = JOptionPane.showInputDialog("Ingrese un nickname");
				ventana.setnickname(i);
				
				if (i!=null) {
					ventana.iniciarjuego();
				}else {
					JOptionPane.showMessageDialog(this, "Debe ingresar un nickname", "Warning", JOptionPane.WARNING_MESSAGE);
				}
				
			}else if (opcion==1) {
				//cargar partida
				ventana.recuperarjuego();
				ventana.iniciarjuego();
				
			}
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(this, "No existe una partida ", "Warning", JOptionPane.WARNING_MESSAGE);
		}
			
	}
	
	public void guardarjuego() {
		try {
			ventana.guardarpartida();
			}catch (Exception e) {
				e.printStackTrace();
			}
	}

	public void ordenar() {
		int opcion = JOptionPane.showOptionDialog(null, "Ver Jugadores", "Tabla de puntuación",JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, new String [] {"Nombre", "Puntaje"}, null);
		
		if (opcion==0) {
			//ordenar por nombre
			ventana.darjuego().ordenarnombre();
			
		}else if (opcion==1) {
			//ordenar por puntaje
			ventana.darjuego().ordenarpuntaje();
		}
		imprimirjugadores();
	}
	
	public void imprimirjugadores() {
		String lista="";
		for (int i=0; i<ventana.darjuego().darlistajugadores().size(); i++) {
			lista+=((i+1)+". "+ventana.darjuego().darlistajugadores().get(i).darnick()+"    "+
			ventana.darjuego().darlistajugadores().get(i).darpuntos()+"\n");
		}
		
		JOptionPane.showMessageDialog(null, "Tabla de puntajes\n"+lista);
	}
	
	public void buscar() {
		int i = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el puntaje que desea buscar"));
		ventana.buscar(i);
	}
}
