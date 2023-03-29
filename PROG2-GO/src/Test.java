
public class Test {
	
	public static void main(String[] args) {
		
		Igra igra = new Igra("go",9);
		
		Okno okno = new Okno();
		
		okno.pack();
		
		okno.setVisible(true);
		
		okno.platno.nastaviIgro(igra);

	}
}
