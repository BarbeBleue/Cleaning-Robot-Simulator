package robot;

import element.*;
import forme.*;
import graphique.Graphique;

import java.util.ArrayList;

/**
 * Classe d'un robot Roomba
 * @author Maeva ARLANDIS et Amelie EUGENE
 */ 

public class Roomba extends Robot{
	
	//constructeurs
	/**
	 * Constructeur par defaut d'un robot Roomba
	 */
	public Roomba(){
		super();
		//ajout des 4 capteurs
		this.init();
	}
	/**
	 * Constructeur d'un robot Roomba avec un comportement donné
	 * @param comp Le comportement voulu du robot
	 */
	public Roomba(Comportement comp){
		super(comp);
	    this.init();
		}	
	
	//methodes
	
	/**
	 * Methode appellee par les constructeurs pour initialiser les attributs du Roomba
	 */
	private void init() {
		this.setForme(new Cercle(34));
		this.setPos(new Posture(17,17,0));
		//ajout des 3 capteurs de proximite
		this.addCapteur(new Capteur_prox(new Posture(17,17,-1*Math.PI/3))); //capteur gauche
	    this.addCapteur(new Capteur_prox(new Posture(17,17,0))); //capteur face
	    this.addCapteur(new Capteur_prox(new Posture(17,17,Math.PI/3))); //capteur droit
	    //ajout du capteur de salete
		this.addCapteur(new Capteur_salete(new Posture(17,17,0),5)); 
		//ajout des 2 roues
		this.addRoues(new Roue());
		this.addRoues(new Roue());
	}
	
	/**
	 * Permet d'obtenir le diametre du robot Roomba
	 * @return Le diametre du Roomba
	 */
	public int getDiametre() { return this.getForme().getHomogeneousSize();}
	
	/**
	 * Methode permettant de faire bouger le roomba dans l'environnement.
	 * Deplace le robot en fonction de la distance parcourue par chaque roue
	 * @param p La posture qu'on va atteindre
	 */
	public void move(Posture p){
		Posture prev_pos = new Posture(this.getPos().getX(),this.getPos().getY(),this.getPos().getTheta()); //on met a jour la position precedente
		this.setPos(p);
		double angle = p.getTheta()-prev_pos.getTheta();
		if(angle>=2*Math.PI)
			angle=angle-2*Math.PI;
		if(angle<0)
			angle=angle+2*Math.PI;
			
		for(int i=0;i<getCapteurs().size();i++) { 
			getCapteurs().get(i).getPos().setX(p.getX());
			getCapteurs().get(i).getPos().setY(p.getY());
			getCapteurs().get(i).getPos().setTheta(getCapteurs().get(i).getPos().getTheta()+angle);
		}
		this.getRoues().get(0).setDistance(0);
		this.getRoues().get(1).setDistance(0);
	}
	
	/**
	 * Methode permettant de savoir si le robot est face a un element et ne bouge plus 
	 * Par exemple, si le robot est face a un mur ou un obstacle mais que ceux ci ne sont pas detectes
	 * @return boolean True si il est bloqué, false sinon
	 */
	public boolean blocage() {
		//on regarde la position en x et en y et theta pour la poition actuelle et la precedente
		if (this.getPos().getX()==this.getPrev_pos().getX() 
				&& this.getPos().getY()==this.getPrev_pos().getY()
				&& this.getPos().getTheta()==this.getPrev_pos().getTheta()) {			
			//System.out.println("Blocage");
			return true; //si c'est les memes parametres le robot est bloque, on retourne true
		}
		return false;
	}
	
	/**
	 * Methode permettant de calculer la nouvelle position a l'aide du comportement du robot
	 * @param elem Liste des elements de l'environnement
	 * @return Posture La position a atteindre
	 */
	public Posture calculerPosition(ArrayList<Element> elem){
		Posture decision = new Posture(0,0);
		decision.setX(this.getPos().getX());
		decision.setY(this.getPos().getY());
		decision.setTheta(this.getPos().getTheta());
		int[] repc = new int[this.getCapteurs().size()];
		repc=this.getRepCapteur(elem);
		
		if(!this.blocage()) { //si le robot n'est pas bloqué
			Consigne cons = this.getComp().chemin(this.getCapteurs(), repc);
			if (cons.size() == 1) { //si la consigne ne comporte qu'un element, c'est qu'il faut nettoyer une tache et dans ce cas on ne bouge pas le robot
				nettoyerTache(elem, (int)cons.getConsigne(0)); //on nettoie
			}
			else { //si la consigne contient plus d'un element il s'agit des consignes a appliquer a chaque roue
				getRoues().get(0).setDistance(cons.getConsigne(0));
				getRoues().get(1).setDistance(cons.getConsigne(1));
				//retourne la nouvelle position que doit atteindre le robot d'apres ses capteurs
				decision.move(getRoues().get(0).getDistance(), getRoues().get(1).getDistance(),getForme().getHomogeneousSize());
			}
		}
		else { // si le robot est bloqué, il est face a un mur ou obstacle, on le fait tourner pour qu'il puisse se degager
			Consigne cons= new Consigne((double) this.getComp().getSens(),(double)this.getComp().getSens()*-1);
			getRoues().get(0).setDistance(cons.getConsigne(0));
			getRoues().get(1).setDistance(cons.getConsigne(1));
			decision.move(getRoues().get(0).getDistance(), getRoues().get(1).getDistance(),getForme().getHomogeneousSize());
		}
		return decision; //on retourne la position a atteindre
	}
	
	/**
	 * Methode permettant de nettoyer une tache grace a l'indice de l'element a nettoyer
	 * @param elem Liste des elements de l'environnement
	 * @param ind Indice de l'element a nettoyer
	 */
	public void nettoyerTache(ArrayList<Element> elem, int ind){
		if (elem.get(ind).isCleanable()) { //on regarde si l'element est bien nettoyable
			System.out.println("Nettoyage en cours ...");	
			try { Thread.sleep(1000); } //on attend 1 sec
			catch (Exception e) {}
			System.out.println("Tache nettoyee :");
			System.out.println(elem.get(ind));
			elem.remove(ind); //on enleve la tache nettoyée de la liste des elements de l'environnement
		}
	}
	
	/**
	 * Methode d'affichage des caracteristiques du roomba 
	 * @return String Les differentes informations
	 */
	public String description(){
		String res = "Robot Roomba de " + this.getForme() + "cm a la position " + this.getPos() + "\n";
		for (int i=0;i<getCapteurs().size();i++) {
			res+= getCapteurs(i).toString();
			}
		return res;
	}
	
	/**
	 * Methode d'affichage des caracteristiques du roomba 
	 * @return String Les differentes informations
	 */
	public String toString(){
		String res = "Robot Roomba a la position " + this.getPos();
		return res;
	}
	
	/**
	 * Methode permettant de gerer l'interface graphique
	 * @param g L'interface graphique
	 */
	public void paint(Graphique g){
		g.draw(this);
		for (int i=0;i<getCapteurs().size();i++) { //on parcourt toute la liste des capteurs a representer
			getCapteurs().get(i).paint(g);
		}
	}


}
