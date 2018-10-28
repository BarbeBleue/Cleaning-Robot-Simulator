package graphique;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import forme.*;
import element.*;
import main.*;
import robot.*;

/**
 * Classe qui gere l'interface graphique d'une simulation
 * Le robot s'affiche en bleu
 * Les elements de l'environnement s'affiche en vert sauf les taches qui sont grises
 * @author Maeva ARLANDIS et Amelie EUGENE
 *
 */

@SuppressWarnings("serial")
public class Graph2D extends Graphique{
	
	//attributs
	private Graphics2D g2;
	private Simulation sim;
	
	//constructeur
	/**
	 * Constructeur parametre d'un graphique 2Dqui prend la simulation a dessiner
	 * @param sim La simulation a dessiner
	 */
	public Graph2D(Simulation sim) {
		setBackground(Color.white);
	    setOpaque(true);
	    this.sim=sim;
	}
	
	//getters
	public Graphics2D getG2() {return this.g2;}
	public Simulation getSim() {return this.sim;}
	//setters
	public void setSim(Simulation sim) {this.sim = sim;}
	public void setG2(Graphics2D g2) {this.g2 = g2;}
	
	//methodes
	/**
	 * Methode qui permet de dessiner les differents elements sur le graphique 
	 */
	public void paint(Graphics g){
		super.paint(g);
		this.g2= (Graphics2D) g;
		this.sim.paint(this);
		g2.dispose();
	}

	/**
	 * Dessine un element en vert
	 */
	public void draw(Element elem) {
		//System.out.println("dessine " + elem);
		this.g2.setColor(Color.green);
		elem.getForme().paint(this,elem.getPos());
	}
	/**
	 * Dessine une tache en gris
	 */
	public void draw(Tache tache){
		this.g2.setColor(Color.gray);
		tache.getForme().paint(this,tache.getPos());
	}
	/**
	 * Dessine un robot Roomba en bleu
	 */
	public void draw(Roomba ro){
		int ro_diam=ro.getForme().getHomogeneousSize();
		this.g2.setColor(Color.black);
		g2.fillOval((int)ro.getPos().getX()-ro_diam/2, (int)ro.getPos().getY()-ro_diam/2, ro_diam, ro_diam);
		g2.setColor(Color.blue);
		g2.fillOval((int)ro.getPos().getX()-ro_diam/2+1, (int)ro.getPos().getY()-ro_diam/2+1, ro_diam-2, ro_diam-2);
		this.g2.setColor(Color.black);
		g2.drawLine((int)ro.getPos().getX(),
				(int)ro.getPos().getY(),
				(int)(ro.getPos().getX()+ro_diam/2*Math.cos(ro.getPos().getTheta())),
				(int)(ro.getPos().getY()+ro_diam/2*Math.sin(ro.getPos().getTheta())));
	}
	
	/**
	 * Dessine le capteur de salete comme un cercle rouge au centre du robot.
	 */
	public void draw(Capteur_salete cap) {
		this.g2.setColor(Color.black);
		g2.fillOval((int)(cap.getPos().getX()-2.5), (int)(cap.getPos().getY()-2.5), 5, 5);
	}
	/**
	 * Dessine les capteurs de proximite comme des lignes rouges representant l'angle median de leur zone de detection
	 * 
	 */
	public void draw(Capteur_prox cap) {
		this.g2.setColor(Color.cyan);
		int diam=18;
		double x=cap.getPos().getX()+(diam*Math.cos(cap.getPos().getTheta()));
		double y=cap.getPos().getY()+(diam*Math.sin(cap.getPos().getTheta()));
		g2.drawLine((int)cap.getPos().getX(),
				(int)cap.getPos().getY(),
				(int)(x),
				(int)(y));
		this.g2.setColor(Color.black);
		g2.fillOval((int)(x-2), (int)(y-2), 4, 4);
	}

	public void draw(Cercle c, Posture pos) {
		int x=(int)pos.getX();
		int y=(int)pos.getY();
		g2.fillOval(x-c.getDiametre()/2, y-c.getDiametre()/2, c.getDiametre(), c.getDiametre());
	}

	public void draw(Rectangle r, Posture pos){
		int x=(int)pos.getX();
		int y=(int)pos.getY();
		g2.fillRect(x-r.getLargeur()/2, y-r.getLongueur()/2, r.getLargeur(), r.getLongueur());
	}
}
