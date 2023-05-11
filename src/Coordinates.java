import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class Coordinates extends Tripartite{
	
	public Coordinates(int x, int y, Color clr) {
		this.x=x;
		this.y=y;
		this.clr=clr;
	}
	
	public Coordinates() {
	}
	
	public static float calc(int x0, int y0, int x1, int y1) {
		float a = (float) Math.sqrt((x1-x0)*(x1-x0) + (y1-y0)*(y1-y0));
		return a;
	}
	
}
