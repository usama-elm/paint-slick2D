import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class Dessin {

	public Dessin() {
		
	}
	
	public static void dessinLibre(Graphics g,ArrayList li) {
		g.setAntiAlias(true);
		for (int i = 0; i < li.size(); i++) {
//			System.out.println(((Coordinates) li.get(i)).getX() + " et " + ((Coordinates) li.get(i)).getY() +" "+ ((Coordinates) li.get(i)).getClr());
			if (i>3 && Coordinates.calc(((Coordinates) li.get(i-1)).getX(), ((Coordinates) li.get(i-1)).getY(), ((Coordinates) li.get(i)).getX(), ((Coordinates) li.get(i)).getY())<50 && Coordinates.calc(((Coordinates) li.get(i-1)).getX(), ((Coordinates) li.get(i-1)).getY(), ((Coordinates) li.get(i)).getX(), ((Coordinates) li.get(i)).getY()) > 0.1) {
				g.setColor(((Coordinates) li.get(i-1)).getClr());
				g.drawLine(((Coordinates) li.get(i-1)).getX(), ((Coordinates) li.get(i-1)).getY(), ((Coordinates) li.get(i)).getX(), ((Coordinates) li.get(i)).getY());
			}
//			System.out.println("Dessiné et " + (li.size()));
		}
	}
	
	public static void effaceur(Graphics g, ArrayList li) {
		g.setColor(Color.white);
		Dessin.dessinLibre(g, li);
	}

}
