package robot;

import java.util.ArrayList;

import element.*;
import graphique.Graphique;

/**
 * Classe d'un robot mobile. C'est une classe abstraite car on ne sait pas quel robot elle représente.
 * @author Maeva Arlandis et Amelie Eugene
 */

public abstract class Robot extends Element{

	//attributs
	private ArrayList<Roue> roues;
	private ArrayList<Capteur> capteurs;
	private Posture prev_pos;
	private Comportement comp;
	
	//constructeurs
	/**
	 * Constructeur par defaut de Robot
	 */
	public Robot(){
		this.comp = new Comp_alea();
		this.capteurs = new ArrayList<Capteur>();
		this.roues = new ArrayList<Roue>();
		this.setPos(new Posture(0,0,0));
		this.prev_pos=new Posture(0,0,0);
	}
	
	/**
	 * Constructeur d'un robot avec un comportement donne
	 * @param comp Le comportement souhaite du robot
	 */
	public Robot(Comportement comp) {
		super();
		this.capteurs = new ArrayList<Capteur>();
		this.setPos(new Posture(0,0,0));
		this.prev_pos=new Posture(0,0,0);
		this.roues = new ArrayList<Roue>();
		this.comp=comp;
	}
	
	/**
	 * Constructeur permettant la creation d'un nouveau robot
	 * @param r1 Premiere roue
	 * @param r2 Deuxieme roue
	 * @param capt Liste des capteurs dont dispose le robot
	 * @param pos Position du robot
	 * @param comp Comportement du robot
	 */
	public Robot(Roue r1, Roue r2, ArrayList<Capteur> capt, Posture pos, Comportement comp){
		this.roues = new ArrayList<Roue>();
		this.roues.add(r1);
		this.roues.add(r2);
		this.capteurs = capt;
		this.pos=pos;
		this.prev_pos = pos;
		this.comp = comp;
	}
		
	//getters et setters
	public ArrayList<Roue> getRoues() {return roues;}
	public void setRoues(ArrayList<Roue> roues) {this.roues = roues;}
	public void addRoues(Roue roue) {this.roues.add(roue);}
	
	public ArrayList<Capteur> getCapteurs() {return this.capteurs;}
	public Capteur getCapteurs(int ind) {return this.capteurs.get(ind);}
	public int getCapteurs(Capteur capteur){//getter permettant d'obtenir le numero d'un certain capteur
		int size=this.capteurs.size();
		for(int i=0;i<size;i++){ //on parcourt toute la liste des capteurs
			if(this.capteurs.get(i).equals(capteur)){
				return i; //on renvoie l'indice du capteur demandé
			}
		}
		return -1;
	}
	public void setCapteurs(ArrayList<Capteur> capteurs) {this.capteurs = capteurs;}
	public void setPos(Posture pos) {
		this.prev_pos=new Posture(this.getPos().getX(),this.getPos().getY(),this.getPos().getTheta());
		this.pos=pos;
		for(int i=0;i<getCapteurs().size();i++) {
			getCapteurs(i).setPos(pos.getX(),pos.getY());
		}
	}
	public Posture getPrev_pos() {return prev_pos;}
	public void setPrev_pos(Posture prev_pos) {
		this.prev_pos.setX(prev_pos.getX());
		this.prev_pos.setY(prev_pos.getY());
		this.prev_pos.setTheta(prev_pos.getTheta());
	}

	public Comportement getComp() {return comp;}
	public void setComp(Comportement comp) {this.comp = comp;}
	
	
	//methodes
	
	/**
	 * Methode permettant de recuperer la reponse d'un capteur face a un element, c'est a dire si le capteur 
	 * se trouve face a un mur, une tache etc...
	 * @param elem Liste des elements de l'environnement
	 * @return int[] Tableau des reponses des capteurs
	 */
	public int[] getRepCapteur(ArrayList<Element> elem){
		int size=this.capteurs.size(); //on recupere la taille de la liste (le nombre de capteurs)
		int[] rep = new int[size]; //tableau pour stocker les reponses des capteurs
		for(int i=0;i<size;i++){ //on parcourt la liste des capteurs quand un elemet est détecté pour stocker chaque reponse		
			rep[i]=this.capteurs.get(i).detecter(elem); 
		}
		return rep;		
	}
	
	/**
	 * Methode permettant d'ajouter un capteur a la liste existante
	 * @param capteur Le capteur a ajoute au robot
	 */
	public void addCapteur(Capteur capteur) {this.capteurs.add(capteur);}	
	
	/**
	 * Methode permettant de supprimer un capteur de la liste de capteurs
	 * @param capteur Le capteur a supprime du robot
	 */
	public void removeCapteur(Capteur capteur) {this.capteurs.remove(capteur);}
	
	/**
	 * Permet d'afficher une description complete du robot et des ses capteurs
	 * @return La description du robot
	 */
	public String description(){
		String res = "Robot de " + this.getForme() + "et a la position " + this.getPos() + "\n";
		for (int i=0;i<getCapteurs().size();i++) {
			res+= getCapteurs(i).toString();
			}
		return res;
	}
	
	/**
	 * Methode permettant d'afficher la position et le comportement du robot
	 * @return String
	 */
	public String toString(){
		return "Robot a la position : "+this.getPos().toString()+" et au comportement "+this.comp.toString();
	}
	
	/**
	 * Methode abstraite pour definir le mouvement du robot
	 * @param pos Positon du robot
	 */
	public abstract void move(Posture pos); 
	
	/**
	 * Methode abstraite permettant de caculer la nouvelle position du robot
	 * @param elem Liste des elements 
	 * @return Posture La nouvelle position
	 */
	public abstract Posture calculerPosition(ArrayList<Element> elem); 
	
	
	/**
	 * Methode abstraite pour l'interface
	 * @param g L'interface graphique
	 */
	public abstract void paint(Graphique g); 
	
}
