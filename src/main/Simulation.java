package main;

import javax.swing.*;
import java.awt.*;
import java.util.*;

import robot.*;
import robot.Robot;
import element.*;
import graphique.*;

/**
 * Classe qui gere toute la simulation d'un robot dans un environnement
 * @author Maeva ARLANDIS et Amelie EUGENE
 */


@SuppressWarnings("serial")
public class Simulation extends JFrame {

	
	//attributs
	private int mode; 
	private Robot robot;
	private Environnement env;
	
	//constructeur
	/**
	 * Constructeur par defaut d'une Simulation
	 */
	public Simulation() {
		this.mode=1; //mode texte par defaut
		this.robot=null;
		this.env=null;
	}
	/**
	 * Constructeur parametre d'une simulation
	 * @param mode Le mode de la simulation
	 * @param robot Le robot qui se déplace dans l'environnement
	 * @param env L'environnement dans lequel se déroule la simulation
	 */
	public Simulation(int mode, Robot robot, Environnement env) {
		if (mode==1 || mode==2)
			this.mode=mode;
		else
			mode=1; //mode texte par defaut
		this.robot=robot;
		this.env=env;
	}
	
	//getters
	public int getMode() {return this.mode;	}
	public Robot getRobot() {return this.robot;	}
	public Environnement getEnv() {return this.env;}
	//setters
	public void setMode(int mode) {this.mode = mode;}	
	public void setRobot(Robot robot) {this.robot=robot;}
	public void setEnv(Environnement env) {this.env=env;}
	
	
	
	/**
	 * Permet a l'utilisateur de choisir le mode avec la console
	 * @return boolean True si mode graphique et False sinon
	 */
	public boolean modeSelection() {
		Scanner saisieUtilisateur = new Scanner(System.in);
		System.out.println("Choix du mode d'affichage:");
		System.out.println("1. Texte");
		System.out.println("2. Graphique.");
		int ent = saisieUtilisateur.nextInt();
		saisieUtilisateur.close();
		switch (ent) {
			case 2: //si on met 2 -> mode graphique
				this.mode=2;
				return true; 
			default: //si on met autre chose que 2 -> mode texte
				this.mode=1;
				return false; 
		}
	}
	
	/**
	 * Permet d'animer la simulation en deplacant le robot
	 * @param g Le graphique sur lequel on dessine dans le cas du mode graphique
	 */
	public void animate(Graphique g) {
		Posture newpos = this.robot.calculerPosition(env.getElement()); //on calcule la nouvelle position souhaitee du robot
		if (this.env.isReachable(this.robot,newpos)) { //on verifie qu'elle est dans l'environnement
			this.robot.move(newpos); //si oui on deplace le robot a cette position
			if (this.mode==2)
				g.repaint(); // redessine les elements modifies dans la simulation (appelle entre autres paint())
			else
				System.out.println(this.robot); // affiche les informations liees au robot
		}
		else {
			this.robot.setPrev_pos(this.robot.getPos()); //si le robot n'a pas bougee on met tout de meme a jour sa position precedente
		}
	}
	
	/**
	 * Permet de dessiner la simulation sur un graphique
	 * @param g le graphique sur lequel on dessine
	 */
	
	public void paint(Graphique g) {
		this.env.paint(g);
		this.robot.paint(g);
	}
	
	public static void main(String[] args) {
		Roomba robot = new Roomba(); 
		Environnement env= new Environnement();		
		env.init(); //on ajoute les elements de l'environnement
		Posture p= new Posture(env.getLargeur()/2,env.getLongueur()/2);
		robot.setPos(p); //on pace le robot au centre de l'environnement creer
		Simulation sim = new Simulation(1, robot, env); 
		
		Graph2D g = null;
		
		if(sim.modeSelection()) {
			g = new Graph2D(sim);
			JFrame ma_fenetre = new JFrame("Simulateur");
		    g.setPreferredSize(new Dimension(400, 400));
		    ma_fenetre.setContentPane(g);
		    ma_fenetre.pack();
		    ma_fenetre.setVisible(true);
		}
		else {
			System.out.println(sim.robot.description());
			System.out.println(sim.env);
			System.out.println("Début Simulation dans 3 secondes !\n");
			try  { Thread.sleep(1000); } // attend 3 sec
			catch (Exception e) {}
		}
		while (true)
	    {
	    	sim.animate(g); //met a jour la simulation
			try  { Thread.sleep(10); } // attend 0.01 sec
			catch (Exception e) {}		
	    }
	}

}
