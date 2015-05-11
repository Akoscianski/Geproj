package model.ssprojet;

import java.text.DecimalFormat;
import java.util.LinkedList;

import javax.swing.event.EventListenerList;
public class SSProjetModel {
	private int idlots;
	private int idssprojets;
	private String name;
	private String objectif;   //A changer en CLOB
	private String resultat;   //A changer en CLOB
	private String responsable; //A changer en Employé
	private float budget;
	private LinkedList<Integer> taches; //A changer en taches
	
	private EventListenerList listeners;
	
	
	public SSProjetModel(){
		this(0,0, "","","",0);
	}
	
	public SSProjetModel(int idssproj,int id, String nom, String objectif, String resultat, float budget){
		this.idlots = id;
		this.idssprojets = idssproj;
		this.name = nom;
		this.budget = budget;
		this.objectif = objectif;
		this.resultat = resultat;
		this.responsable = new String(""); //Changer en employé
		this.taches = new LinkedList<Integer>(); //Changer en taches
		
		this.listeners = new EventListenerList();
	}
	
	/*
	 * ===================================================
	 *       ACCESSEURS
	 * ===================================================
	 */
	public String getDesc(){
		DecimalFormat decimal = new DecimalFormat("#.00");
		String retour = idlots+" : " + idssprojets +name;
		retour += "; "+decimal.format(budget);
		return retour;
	}
	public String getName(){
		return this.name;
	}
	
	public float getBudget(){
		return this.budget;
	}
	
	public String getRespnsable(){
		return this.responsable;
	}
	public String getObjectif(){
		return this.objectif;
	}
	public String getResultat(){
		return this.resultat;
	}
	
	/*
	 * ===================================================
	 *       MUTATEURS
	 * ===================================================
	 */
	
	public void setIdLots(int id){
		this.idlots = id;
	}
	public void setIdSSProj(int idssprojet){
		this.idssprojets = idssprojet;
	}
	public void setName(String name){
		this.name = name;
		fireNameChanged();
	}
	public void setBudget(float budget){
		this.budget = budget;
	}
	public void setResponsable(String resp){ //A changer avec employé
		this.responsable = resp;
	}
	public void addTache(int tache){ //A changer avec lot
		this.taches.add(tache);
	}
	public void setObjectif(String obj){ //A changer avec employé
		this.objectif = obj;
	}
	public void setResultat(String res){ //A changer avec employé
		this.resultat = res;
	}
	
	
	public void addLotListener(SSProjetListener listener){
		listeners.add(SSProjetListener.class, listener);
	}
	public void removeLotListener(SSProjetListener l){
		 listeners.remove(SSProjetListener.class, l);
	} 
	public void fireNameChanged(){
		SSProjetListener[] listenerList = (SSProjetListener[])listeners.getListeners(SSProjetListener.class);
 
		for(SSProjetListener listener : listenerList){
			listener.nameChanged(new SSProjetNameChangedEvent(this, getName()));
		}
	}
}
