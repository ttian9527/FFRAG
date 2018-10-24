package FFRAG;
import java.util.*;

public class Participant {

    private int noInscription;
	private Date dateInscription;
    private int tempsFinal;
    private Coureur coureur;
    

	private Vehicule vehicule;
   
	public Participant(int numInscr, Date dateEnreg, Coureur c, Vehicule v) {
        this.noInscription = numInscr;
        this.dateInscription = dateEnreg;
        this.coureur = c;
        this.vehicule = v;
    }
    
	public int getTempsFinal() {
		return this.tempsFinal;
	}
	
    public void setTempsFinal(int temps) {
    	this.tempsFinal = temps;
    }
    
    public boolean prendreDepart(Etape e) {
    	boolean prendreDepart = true;
   		if(e.getTabParticipants().get(this)==null) {
    			prendreDepart=false;
    		};
    	return prendreDepart;
    } 
    
    public Vehicule getVehicule() {
		return vehicule;
	}
    
    public int getNoInscription() {
		return noInscription;
	}
    
    public Coureur getCoureur() {
		return coureur;
	}
}