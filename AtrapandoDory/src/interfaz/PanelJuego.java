package interfaz;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;

public class PanelJuego extends JPanel implements MouseListener{

	private Ventana ventana;
	private ImageIcon fondo;
	
	public PanelJuego(Ventana ventana) {
		fondo = new ImageIcon("./images/fondosi.jpg");
		setPreferredSize(new Dimension(800,550));
		setBackground(Color.WHITE);
		this.ventana = ventana;
		addMouseListener(this);
	}
	
	public void paint( Graphics g ){
		g.drawImage(fondo.getImage(),0,0,600,550,null);	
		int x, y;
		Image img;
		for (int i = 0; i< ventana.darjuego().darpersonaje().size(); i++) { 
			
			img= new ImageIcon(ventana.darjuego().darpersonaje().get(i).daricono()).getImage();
			x=ventana.darjuego().darpersonaje().get(i).darx();
			y=ventana.darjuego().darpersonaje().get(i).dary();
			g.drawImage(img, x, y,null); 
		}
		
		setOpaque(false);
		
		
	}

	@Override
	public void mouseClicked(MouseEvent m) {
		int x = m.getX();
		int y= m.getY();
		ventana.atraparpersonaje(x, y);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	

}
