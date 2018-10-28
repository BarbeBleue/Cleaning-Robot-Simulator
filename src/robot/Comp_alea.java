package robot;

import java.util.ArrayList;

/**
 * Classe decrivant un comportement aleatoire heritant de la classe Comportement
 * @author Maeva ARLANDIS et Amelie EUGENE
 * 
 */

public class Comp_alea extends Comportement {
	
	//constructeur
	public Comp_alea(){
		this.flag = 0;
		this.sens = 1;
	}

	//Methodes
	/**
	 * Methode appelee par le robot et permettant un mouvement aleatoire dans l'environnement
	 * @param capteurs Liste des capteurs dont dispose le robot
	 * @param repCapteurs Tableau des reponses des capteurs de la liste qu'a le robot
	 * @return La consigne a appliquer aux roues
	 */
	
	public Consigne chemin(ArrayList<Capteur> capteurs, int[] repCapteurs){
		double vitesse=100; //vitesse max du robot =100
		double tps=0.01; //pas de 10ms
		int collision=-1;
		int tache=-1;
		Consigne cons = new Consigne();
		//on regarde tous les capteurs et on determine lequel est implique (collision ou tache)
		for (int i=0;i<capteurs.size();i++) {
			//si c'est un capteur de proximite collision devient different de -1
			if (capteurs.get(i).type().equals("Proximite") && repCapteurs[i] != -1)
				collision = i; //=l'indice du capteur qui a detecte la collision
			//si c'est un capteur de salete tache devient different de -1
			if (capteurs.get(i).type().equals("Salete") && repCapteurs[i] != -1)
				tache = repCapteurs[i]; //=l'indice de l'element a nettoye
		}
		//si tache est different de -1 on a un capteur de salete actif et on envoie donc la consigne de nettoyer
		if (tache!=-1) { 
			cons.addConsigne(tache);
			System.out.println("Capteur de salete --> Tache detectee");
			return cons;
		}
		//si collision est different de -1 on a un capteur de proximite qui a reagit et on veut changer de chemin
		if (collision!=-1){			
			System.out.println("Colision detectee avec le capteur numero " + collision+ " !");
			System.out.print(capteurs.get(collision));
			if(flag==0) {
				flag=20;
			}			
			if (collision == 2){ //capteur de droite
				this.sens=1;
				flag-=1;
			}
			else if(collision==0) { //capteur de gauche
				this.sens=-1;
				flag-=1;
			}
			else {				
				if(flag==20) { //capteur de face 
					this.sens=(int)(Math.random()*10%2);
					if (this.sens==0)	this.sens=-1;
					flag-=1;
				}
				
			}
			cons.addConsigne(sens*vitesse*tps); 
			cons.addConsigne(sens*-1*vitesse*tps);
		}
		//si aucun capteur n'a reagi
		else {
			if (flag == 0) { 
				cons.addConsigne(vitesse*tps); 
				cons.addConsigne(vitesse*tps); 
				}
			else { //on termine de tourner
				cons.addConsigne(sens*vitesse*tps); 
				cons.addConsigne(sens*(-1)*vitesse*tps);
				flag-=1;
				}
		}
		return cons;
	}
	
	public String toString() {
		return "Comportement aleatoire";
	}

}
