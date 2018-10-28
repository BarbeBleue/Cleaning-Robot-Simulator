package robot;


/**
 * Classe definissant une roue d'un robot
 * @author Maeva ARLANDIS et Amelie EUGENE
 */

public class Roue {

	//attribut
	private double distance;

	//constructeur
	/**
	 * Constructeur par defaut
	 */
	public Roue(){
		this.distance=0;
	}
		
	//getter et setter
	public double getDistance() {return distance;}
	public void setDistance(double distance) {this.distance = distance;}

}
