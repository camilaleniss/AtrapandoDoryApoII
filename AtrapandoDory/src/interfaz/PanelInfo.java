package interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelInfo extends JPanel {
	
	private JLabel labnickname;
	private JLabel labpuntos;
	private JLabel labnivel;

	PanelInfo(int puntos, int nivel){
		setLayout(new GridLayout (1,6));
		setPreferredSize(new Dimension(600,50));
		setBackground(Color.WHITE);
		
		labnickname = new JLabel();
		labpuntos = new JLabel(""+puntos);
		labnivel = new JLabel(""+nivel);
		
		add(new JLabel ("Nickname: "));
		add(labnickname);
		add(new JLabel ("Puntaje: "));
		add(labpuntos);
		add(new JLabel ("Nivel: "));
		add(labnivel);
	}
	
	public void setNick(String nickname){
		labnickname.setText(nickname);
	}
	
	
	public void setPuntos(int puntos){
		labpuntos.setText(""+puntos);
	}
	
	
	public void setNivel(int nivel){
		labnivel.setText(""+nivel);
	}
	
	
	public void refresh(int puntos, int level) {
		setPuntos(puntos);
		setNivel(level);
	}

	
}
