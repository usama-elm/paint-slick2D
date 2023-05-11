import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class Textes extends Tripartite{
	private String txt;
	
	public String getTxt() {
		return txt;
	}

	public void setTxt(String txt) {
		this.txt = txt;
	}

	public Textes(){
	}
	
	public Textes(int x, int y, String txt, Color clr){
		this.x=x;
		this.y=y;
		this.txt=txt;
		this.clr = clr;
	}
	
	public static void rendreTexte(Graphics g, ArrayList sli) {
		if (sli.size()>0) {
			for (int i = 0; i < sli.size(); i++) {
				g.setColor(((Textes) sli.get(i)).getClr());
				g.drawString(((Textes) sli.get(i)).getTxt(), ((Textes) sli.get(i)).getX(), ((Textes) sli.get(i)).getY());
			}
		}
	}

}
