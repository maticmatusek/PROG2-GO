import java.util.HashSet;
import java.util.Set;

public class Tocka {
	
	protected int x;
	
	protected int y;
	
	protected int xx;
	
	protected int yy;
	

	protected String ime;
	
	protected String zasedenost;

	
	public Tocka (String ime , int x, int y) {
		this.ime = ime;
		this.x = x;
		this.y = y;
		this.zasedenost = null;
		this.xx =0;
		this.yy=0;
	}

	@Override
	public String toString() {
		return ime;
	}
}
