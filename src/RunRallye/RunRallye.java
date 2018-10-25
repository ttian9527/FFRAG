package RunRallye;
import java.util.*;
import FFRAG.Camion;
import FFRAG.Coureur;
import FFRAG.Courir;
import FFRAG.Edition;
import FFRAG.Etape;
import FFRAG.FFRAG;
import FFRAG.Participant;
import FFRAG.Rallye;
import FFRAG.Voiture;
import vue.Bienvenue;
import vue.CreationEdition;
import vue.CreationRallye;

import java.awt.EventQueue;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class RunRallye {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date today = dateformat.parse("2018-10-04");
		
		FFRAG ffrag = new FFRAG();
		
		/*EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					CreationRallye frame = new CreationRallye(ffrag);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});*/
		ffrag.creationRallye("r1","v1","p1");
		ffrag.creationRallye("r2","v2","p1");
		ffrag.insertCoureur("sf","sef",today);
		ffrag.insertCoureur("sef","sef",today);
		System.out.println(ffrag.getListRallye().get(0).getNomRallye());
		System.out.println(ffrag.getListRallye().get(1).getNomRallye());
		ffrag.creationRallye("Grand prix Canada", "Montr��al", "Canada");
		ffrag.creationRallye("Grand prix France", "Montr��al", "Canada");
		ffrag.creationRallye("Grand prix Suisse", "Montr��al", "Canada");
		ffrag.creationRallye("Grand prix Pyr��n��en", "Montr��al", "Canada");
		ffrag.creationRallye("Grand prix Aples", "Montr��al", "Canada");
		System.out.println(ffrag.getListRallye().size());
		
		Camion c1 = new Camion("cme", 2250);
		System.out.println(c1.getCoef());

		Voiture v1 = new Voiture("vme", 25);
		System.out.println(v1.getCoef());
		
		
		//test temps
		Courir cou1 = new Courir(1,3,28,6);
		Courir cou2 = new Courir(0,5,12,5);
		System.out.println(cou1.getMilleSeconde());
		System.out.println(cou1.getTemps());
		
		//test calculer
			
		Coureur co1 = new Coureur("sf","sef",today);
		Coureur co2 = new Coureur("sef","sef",today);
		Participant p1 = new Participant(1,today,co1,c1);
		Participant p2 = new Participant(2,today,co2,v1);
		Etape et1 = new Etape(1,(int) (235));
		
		et1.enregistreTemp(p2, 1,35,59,1);
		et1.enregistreTemp(p1, 0,20,35,220);
		et1.calculerClassement();
		
		Edition ed1 = new Edition(21,today,today);
		Edition ed2 = new Edition(22,today,today);
		Edition ed3 = new Edition(23,today,today);
		ffrag.getListRallye().get(0).organiser(21,today,today);
		ffrag.getListRallye().get(0).organiser(22,today,today);
		ffrag.getListRallye().get(1).organiser(22,today,today);
		ffrag.getListRallye().get(1).organiser(23,today,today);
		
		ed1.organiserEtape(1,(int) (235));
		ed1.organiserEtape(2,(int) (235));
		ed1.organiserPart(p2);ed1.organiserPart(p1);
		ed1.getListEtape().get(0).enregistreTemp(p2, 1,35,59,1);
		ed1.getListEtape().get(0).enregistreTemp(p1, 0,20,35,220);
		ed1.getListEtape().get(1).enregistreTemp(p2, 1,35,59,1);
		ed1.getListEtape().get(1).enregistreTemp(p1, 0,20,35,220);
		
		ed1.calculerClassement(1);
		ed1.calculerClassement(2);
		int nom = ed1.getChampion().getNoInscription();
		System.out.println("Le champion est le" + nom);
		
		ed1.setTempFinal();
		System.out.println("Le temps final du participant " + p1.getNoInscription() + " est de " + p1.getTempsFinal());
		System.out.println("La position finale du participant " + p1.getNoInscription() + " est de " + p1.getPosition());
		
		System.out.println("Le temps final du participant " + p2.getNoInscription() + " est de " + p2.getTempsFinal());
		System.out.println("La position finale du participant " + p2.getNoInscription() + " est de " + p2.getPosition());
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bienvenue frame = new Bienvenue(ffrag);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
