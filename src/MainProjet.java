import java.awt.TextField;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.*;
import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;


public class MainProjet extends BasicGame {
	//Elements globales utiles pour l'execution du programme
	Image menuBar;
	String texte;
	String mouse;
	Color clr = Color.black;
	Color backl = Color.white;
	Boolean ff=false;
	Boolean eff=false;
	int xo;
	int yo;
	int ep = 10;
	//Listes diverses ainsi que mouse qui etaye a chaque moment la ou le curseur se trouve
	public ArrayList<Coordinates> li = new ArrayList<Coordinates>();
	public ArrayList<Textes> sli = new ArrayList<Textes>();
	public ArrayList<Formes> fli = new ArrayList<Formes>();
	public ArrayList<FormeSegment> fsli = new ArrayList<FormeSegment>();
	
	public MainProjet(String title) {
		super(title);
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		//On dessine la barre d'outils
		menuBar.draw(365,0);
		//On effectue ici differentes operations comme la couleur du background, la couleur par defaut, la position au petit coin ainsi que l'epaisseur de la ligne entre 1 et 10.
		g.setColor(Color.black);
		g.setBackground(backl);
		mouse = "(" + xo + "," + yo + ")";
		g.drawString(mouse, 0, 705);
		g.setLineWidth(ep);
		//Ces 4 fonctions appartiennent aux differentes classes et sont utilisées pour dessine respectivement, les segments, formes le dessin libre et le texte.
		FormeSegment.dessineSegment(g, fsli);
		Formes.dessinFormes(g, fli);
		Dessin.dessinLibre(g, li);
		Textes.rendreTexte(g, sli);
		//Ici c'est la fonction flush (effacer tout du canvas) utiisée a l'aide d'un flag.
		if (ff) {
			li = new ArrayList<Coordinates>();
			sli = new ArrayList<Textes>();
			fli = new ArrayList<Formes>();
			fsli = new ArrayList<FormeSegment>();
			ff=false;
		}

	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		//Ajoute la barre de menus
		menuBar = new Image("res/menuBarSmall.png");
	}

	@Override
	public void update(GameContainer gc, int i) throws SlickException {
		//Ici on a les coordoonées a l'aide de input
		Input input = gc.getInput();
		xo = input.getMouseX();
		yo = input.getMouseY();
		//Partie chargée d'ajouter les coordonées a la liste li
		if((input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON) || input.isMouseButtonDown(Input.MOUSE_RIGHT_BUTTON))&& yo>50) {
			li.add(new Coordinates(xo,yo,clr));
		}

		if ((input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON) || input.isMouseButtonDown(Input.MOUSE_RIGHT_BUTTON)) && yo>=0 && yo<=50) {
			//Input de texte
			if (xo>=360 && xo<=420) {
				texte = javax.swing.JOptionPane.showInputDialog("Entrez le texte a afficher: ");
				String xof =  javax.swing.JOptionPane.showInputDialog("Entrez la coordoonée x : ");
				String yof = javax.swing.JOptionPane.showInputDialog("Entrez la coordoonée y : ");
				if ((xof != null || yof != null || texte!=null) && Integer.parseInt(yof)>50) {
					sli.add(new Textes(Integer.parseInt(xof), Integer.parseInt(yof), texte, clr));
				}
			}
			//Categorie couleurs
			if (xo>=755 && xo <=805) {
				clr = Color.white;
			}
			if (xo >=620 && xo <=645 && yo>=10 && yo<=20) {
				clr = Color.red;
			}
			if (xo >=620 && xo <=645 && yo>=30 && yo<=47) {
				clr = Color.magenta;
			}
			if (xo >=650 && xo <=675 && yo>=10 && yo<=20) {
				clr = Color.blue;
			}
			if (xo >=650 && xo <=675 && yo>=30 && yo<=47) {
				clr = Color.orange;
			}
			if (xo >=685 && xo <=715 && yo>=10 && yo<=20) {
				clr = Color.green;
			}
			if (xo >=685 && xo <=715 && yo>=30 && yo<=47) {
				clr = Color.yellow;
			}
			if (xo >=720 && xo <=745 && yo>=10 && yo<=20) {
				clr = Color.black;
			}
			if (xo >=720 && xo <=745 && yo>=30 && yo<=47) {
				clr = Color.white;
			}
			//If it ever happens, here I may lay a true "gomme" to super-erase everything
			if (xo >=755 && xo <=805) {
				eff=true;
			}
			//Epaisseur
			if (xo >=420 && xo <=465 && yo>=0 && yo<=25 && ep<=10) {
				ep++;
			}
			if (xo >=420 && xo <=465 && yo>=25 && yo<=50 && ep>0) {
				ep--;
			}
			//Efface tous les dessins
			if (xo>=580 && xo<=612) {
				ff = true;
			}
			//Formes = carre, cercle ou segment
			if (xo>=465 && xo <=505) {
				fli.add(new Formes(li.get(li.size()-1).getX(),li.get(li.size()-1).getY(),clr,0));
			}
			if (xo>505 && xo <= 540) {
				fli.add(new Formes(li.get(li.size()-1).getX(),li.get(li.size()-1).getY(),clr,1));
			}
			if (xo>540 && xo <= 580) {
				fsli.add(new FormeSegment(li.get(li.size()-10).getX(),li.get(li.size()-10).getY(),li.get(li.size()-1).getX(),li.get(li.size()-1).getY(), clr));
			}
		}

	}
	
	public static void main(String[] args) {
		try {
			AppGameContainer appgc;
			appgc = new AppGameContainer(new MainProjet("Paint Fait Maison"));
			//On utilise une interface 1280x720 sans FPS visibles, avec un minUodate de 1 et avec AlwaysRender
			appgc.setDisplayMode(1280,720, false);
			appgc.setShowFPS(false);
            appgc.setMinimumLogicUpdateInterval(1);
			appgc.setAlwaysRender(true);
			appgc.start();
		} catch (SlickException ex) {
			Logger.getLogger(MainProjet.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
