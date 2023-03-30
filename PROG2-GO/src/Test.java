
public class Test {
	
	public static void main(String[] args) {
		
		Igra igra = new Igra("go",19);
		
		Tocka tocka = igra.mozna_polja.get("(5, 5)");
		
		tocka.zasedenost = "Beli";
		
		Tocka tocka1 = igra.mozna_polja.get("(5, 6)");
		
		tocka1.zasedenost = "Crni";
		
		System.out.println(tocka);
		
		Okno okno = new Okno();
		
		okno.pack();
		
		okno.setVisible(true);
		
		okno.platno.nastaviIgro(igra);
		
		for (Tocka i : igra.mozna_polja.values()) {
		      System.out.println("key: " + i + " value: " + igra.mozna_polja.get(i));
		    }
	}
}
