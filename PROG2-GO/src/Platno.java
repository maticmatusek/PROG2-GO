import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JPanel;

@SuppressWarnings("serial")

public class Platno extends JPanel implements MouseListener, MouseMotionListener, KeyListener{
	
	protected Igra igra;
	protected int polmer;
	
	public Platno(int sirina, int visina) {
		super();
		polmer = 0;
		this.igra = null;
		setPreferredSize(new Dimension(sirina,visina));
		addMouseListener(this);
		addMouseMotionListener(this);
		addKeyListener(this);
		setFocusable(true);
	}
		

	public void nastaviIgro(Igra igra) {
		this.igra = igra;
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		super.paintComponent(g);
		int dimenzija_igre = igra.dimenzija_igre;
		double velikost_okna = Math.min(getWidth(),getHeight());
		double odmik_od_strani = velikost_okna/15;
		polmer = (int)velikost_okna/80;
		for (int i=0;i<dimenzija_igre;i++) {
			g2.setStroke(new BasicStroke(3));
			g.drawLine( (int)(odmik_od_strani + i*(velikost_okna-2*odmik_od_strani)/(dimenzija_igre-1)) ,
					(int)(odmik_od_strani),
					(int) (odmik_od_strani + i*(velikost_okna-2*odmik_od_strani)/(dimenzija_igre-1)),
					(int)(velikost_okna-odmik_od_strani));
			
			g.drawLine((int)(odmik_od_strani),
					(int)(odmik_od_strani + i*(velikost_okna-2*odmik_od_strani)/(dimenzija_igre-1)),
					(int)(velikost_okna-odmik_od_strani),
					(int) (odmik_od_strani + i*(velikost_okna-2*odmik_od_strani)/(dimenzija_igre-1)));
		}
		if (dimenzija_igre%2!=0) {
			g.setColor(Color.BLACK);
			g.fillOval(  (int)(odmik_od_strani + ((dimenzija_igre/2)+0.5)*(velikost_okna-2*odmik_od_strani)/(dimenzija_igre) -polmer) , (int)(odmik_od_strani + ((dimenzija_igre/2)+0.5)*(velikost_okna-2*odmik_od_strani)/(dimenzija_igre) - polmer), 2*polmer,2*polmer);
		}
	}
	
	
	
	
	
	
	
	
	private int round(double x) {
		return (int)(x+0.5);
	}
	
		@Override
	public void keyTyped(KeyEvent e) {}

		

	@Override
	public void keyReleased(KeyEvent e) {}

	
	@Override
	public void mouseMoved(MouseEvent e) {}

	@Override
	public void mouseClicked(MouseEvent e) {}


	

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}



	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
