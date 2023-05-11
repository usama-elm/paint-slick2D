import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class FormeSegment{
	private int x0;
	private int y0;
	private int x1;
	private int y1;
	private Color clr;
	public int getX0() {
		return x0;
	}
	public void setX0(int x0) {
		this.x0 = x0;
	}
	public int getY0() {
		return y0;
	}
	public void setY0(int y0) {
		this.y0 = y0;
	}
	public int getX1() {
		return x1;
	}
	public void setX1(int x1) {
		this.x1 = x1;
	}
	public int getY1() {
		return y1;
	}
	public void setY1(int y1) {
		this.y1 = y1;
	}
	public Color getClr() {
		return clr;
	}
	public void setClr(Color clr) {
		this.clr = clr;
	}
	public FormeSegment(int x0, int y0, int x1, int y1, Color clr) {
		super();
		this.x0 = x0;
		this.y0 = y0;
		this.x1 = x1;
		this.y1 = y1;
		this.clr = clr;
	}
	
	public static void dessineSegment(Graphics g, ArrayList fsli) {
		if (fsli.size()>0) {
			for (int i = 0; i < fsli.size(); i++) {
				g.setColor(((FormeSegment) fsli.get(i)).getClr());
				g.drawLine(((FormeSegment) fsli.get(i)).getX0(), ((FormeSegment) fsli.get(i)).getY0(), ((FormeSegment) fsli.get(i)).getX1(), ((FormeSegment) fsli.get(i)).getY1());
			}
		}
	}
	
	
	

}
