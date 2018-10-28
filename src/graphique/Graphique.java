package graphique;

import javax.swing.JPanel;

import element.*;
import robot.*;
import forme.*;

/**
 * Classe abstraite d'une interface graphique
 * @author Maeva ARLANDIS et Amelie EUGENE
 *
 */

@SuppressWarnings("serial")
public abstract class Graphique extends JPanel {
	/**
	 * Methode abstraite qui dessine un Element
	 * @param elem L'element a dessiner
	 */
	public abstract void draw(Element elem);
	/**
	 * Methode abstraite qui dessine un robot Roomba
	 * @param robot Le Roomba a dessiner
	 */
	public abstract void draw(Roomba robot);
	/**
	 * Methode abstraite qui dessine un Capteur de salete
	 * @param cap Le capteur a dessiner
	 */
	public abstract void draw(Capteur_salete cap);
	/**
	 * Methode abstraite qui dessine un capteur de type bumper
	 * @param cap Le capteur a dessiner
	 */
	public abstract void draw(Capteur_prox cap);
	/**
	 * Methode abstraite qui dessine une tache
	 * @param tache La tache a dessiner
	 */
	public abstract void draw(Tache tache);
	/**
	 * Methode abstraite qui dessine un cercle
	 * @param c La forme a dessine
	 * @param pos La posture ou dessine le cercle
	 */
	public abstract void draw(Cercle c, Posture pos);
	/**
	 * Methode abstraite qui dessine un rectangle
	 * @param r La forme a dessine
	 * @param pos La posture ou dessine le rectangle
	 */
	public abstract void draw(Rectangle r, Posture pos);
}
