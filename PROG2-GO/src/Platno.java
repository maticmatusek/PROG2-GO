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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.swing.JPanel;

@SuppressWarnings("serial")

public class Platno extends JPanel implements MouseListener, MouseMotionListener, KeyListener{
	
	protected Igra igra;
	protected int polmer;
	protected Color barva_odzadja, barva_crt, barva_pik, barva_beli, barva_crni, barva_crni_rob, barva_beli_rob;
	
	public Platno(int sirina, int visina) {
		super();
		polmer = 0;
		this.igra = null;
		setPreferredSize(new Dimension(sirina,visina));
		addMouseListener(this);
		addMouseMotionListener(this);
		addKeyListener(this);
		setFocusable(true);
		barva_odzadja = Color.WHITE;
		barva_crt = Color.BLACK;
		barva_pik = Color.BLACK;
		barva_beli = Color.white;
		barva_crni = Color.black;
		barva_crni_rob = Color.BLACK;
		barva_beli_rob = Color.BLACK;
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
		double sirina_kvadrata = (velikost_okna-2*odmik_od_strani)/(dimenzija_igre-1) ;
		polmer = (int)(sirina_kvadrata/1.1);
		int polmer_spodnji = (int)(sirina_kvadrata/2);
		for (int i=0;i<dimenzija_igre;i++) {
			g.setColor(barva_crt);
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
		if (dimenzija_igre%4!=0 && dimenzija_igre%2!=0) {
			g.setColor(barva_pik);
			
			g.fillOval(  (int)(odmik_od_strani + ((dimenzija_igre/2)+0.5)*(velikost_okna-2*odmik_od_strani)/(dimenzija_igre) -polmer_spodnji/2) , (int)(odmik_od_strani + ((dimenzija_igre/2)+0.5)*(velikost_okna-2*odmik_od_strani)/(dimenzija_igre) - polmer_spodnji/2), polmer_spodnji,polmer_spodnji);
		
			g.fillOval(  (int)(odmik_od_strani + (((dimenzija_igre/2))/2)*sirina_kvadrata -polmer_spodnji/2) , (int)(odmik_od_strani + ((dimenzija_igre/2)+0.5)*(velikost_okna-2*odmik_od_strani)/(dimenzija_igre) - polmer_spodnji/2), polmer_spodnji,polmer_spodnji);
			g.fillOval(  (int)(velikost_okna - odmik_od_strani - (((dimenzija_igre/2))/2)*sirina_kvadrata -polmer_spodnji/2) , (int)(odmik_od_strani + ((dimenzija_igre/2)+0.5)*(velikost_okna-2*odmik_od_strani)/(dimenzija_igre) - polmer_spodnji/2), polmer_spodnji,polmer_spodnji);
			
			g.fillOval(  (int)(odmik_od_strani + (((dimenzija_igre/2))/2)*sirina_kvadrata -polmer_spodnji/2) , (int)(odmik_od_strani + (((dimenzija_igre/2))/2)*sirina_kvadrata -polmer_spodnji/2), polmer_spodnji,polmer_spodnji);
			g.fillOval(  (int)(velikost_okna - odmik_od_strani - (((dimenzija_igre/2))/2)*sirina_kvadrata -polmer_spodnji/2) , (int)(velikost_okna - odmik_od_strani - (((dimenzija_igre/2))/2)*sirina_kvadrata -polmer_spodnji/2), polmer_spodnji,polmer_spodnji);
			
			g.fillOval(  (int)(odmik_od_strani + (((dimenzija_igre/2))/2)*sirina_kvadrata -polmer_spodnji/2) , (int)(velikost_okna - odmik_od_strani - (((dimenzija_igre/2))/2)*sirina_kvadrata -polmer_spodnji/2), polmer_spodnji,polmer_spodnji);
			g.fillOval(  (int)(velikost_okna - odmik_od_strani - (((dimenzija_igre/2))/2)*sirina_kvadrata -polmer_spodnji/2) , (int)(odmik_od_strani + (((dimenzija_igre/2))/2)*sirina_kvadrata -polmer_spodnji/2), polmer_spodnji,polmer_spodnji);
			
			g.fillOval(  (int)(odmik_od_strani + ((dimenzija_igre/2)+0.5)*(velikost_okna-2*odmik_od_strani)/(dimenzija_igre) -polmer_spodnji/2) , (int)(odmik_od_strani + (((dimenzija_igre/2))/2)*sirina_kvadrata -polmer_spodnji/2), polmer_spodnji,polmer_spodnji);
			g.fillOval(  (int)(odmik_od_strani + ((dimenzija_igre/2)+0.5)*(velikost_okna-2*odmik_od_strani)/(dimenzija_igre) -polmer_spodnji/2) , (int)(velikost_okna - odmik_od_strani - (((dimenzija_igre/2))/2)*sirina_kvadrata -polmer_spodnji/2), polmer_spodnji,polmer_spodnji);
		}
		Map<String, Tocka> mozna_polja = izracunaj_koordinate_tock(igra.mozna_polja);
		for (Tocka t : mozna_polja.values()) {
			
			if (t.zasedenost=="Beli") {
				g.setColor(barva_beli);
				g.fillOval( (int)(t.xx -polmer/2), (int)(t.yy -polmer/2) , polmer,polmer);
				g.setColor(barva_beli_rob);
				g.drawOval((int)(t.xx -polmer/2), (int)(t.yy -polmer/2), polmer, polmer);
			}
			else if (t.zasedenost=="Crni") {
				g.setColor(barva_crni);
				g.fillOval( (int)(t.xx -polmer/2), (int)(t.yy -polmer/2) , polmer,polmer);
				g.setColor(barva_crni_rob);
				g.drawOval((int)(t.xx -polmer/2), (int)(t.yy -polmer/2), polmer, polmer);
			}
			
		}
	}
	
	
	
	
	public Map<String, Tocka> izracunaj_koordinate_tock(Map<String, Tocka> mozna_polja){
		int dimenzija_igre = igra.dimenzija_igre;
		double velikost_okna = Math.min(getWidth(),getHeight());
		double odmik_od_strani = velikost_okna/15;
		double sirina_kvadrata = (velikost_okna-2*odmik_od_strani)/(dimenzija_igre-1) ;
		for (Tocka t : mozna_polja.values()) {
			t.xx = (int)(odmik_od_strani + sirina_kvadrata * (t.x-1));
			t.yy = (int)(odmik_od_strani + sirina_kvadrata * (t.y-1));
		}
		return mozna_polja;
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
