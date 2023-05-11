import org.newdawn.slick.Color;

abstract class Tripartite {
	protected int x;
	protected int y;
	protected Color clr;
	
	public Color getClr() {
		return clr;
	}

	public void setClr(Color clr) {
		this.clr = clr;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public Tripartite() {
		// TODO Auto-generated constructor stub
	}

}
