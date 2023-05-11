import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class Formes extends Tripartite{
	//Il y a 2 differents types, 
	//		type 0 -> carre
	//		type 1 -> cercle
	private int type;
	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	public Formes(int x, int y, Color clr, int ty) {
		this.x=x;
		this.y=y;
		this.clr=clr;
		this.type=ty;
	}
	
	public static void dessinFormes(Graphics g, ArrayList fli) {
		if (fli.size()>0) {
			for (int i = 0; i < fli.size(); i++) {
				if (((Formes) fli.get(i)).getType()==0) {
					g.setColor(((Formes) fli.get(i)).getClr());
					g.fillRect(((Formes) fli.get(i)).getX(), ((Formes) fli.get(i)).getY(), 100, 100);
				}
				else {
					g.setColor(((Formes) fli.get(i)).getClr());
					g.fillOval(((Formes) fli.get(i)).getX(), ((Formes) fli.get(i)).getY(), 100, 100);
				}
			}
		}
	}

	
	

}
