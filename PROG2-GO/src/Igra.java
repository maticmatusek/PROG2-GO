import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;



public class Igra {

	
	public final String vrsta_igre;
	public final int dimenzija_igre;
	public final Map<String,Tocka> mozna_polja;
	
	public Igra(String vrsta_igre, int dimenzija_igre) {
		this.dimenzija_igre = dimenzija_igre;
		this.vrsta_igre = vrsta_igre;
		mozna_polja = new HashMap<String,Tocka>();
		for (int i = 1; i<=dimenzija_igre;i++) {
			for (int j = 1; j<=dimenzija_igre;j++) {
				mozna_polja.put("("+i+", "+j+")",new Tocka( "("+i+", "+j+")",i,j));
			}
		}
	}
	
}
