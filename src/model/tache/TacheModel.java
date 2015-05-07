package model.tache;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.event.EventListenerList;

public class TacheModel {
	private int id;
	private int idssprojet;
	private String name;
	private String objectif;
	private String resultats;
	private String responsable; //A changer en Employé
	private float budget;
	private int charge; //en heurehommes
	private Date dteDebSooner;
	private Date dteDebLater;
	private Date dteFinSooner;
	private Date dteFinLater;
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
	private EventListenerList listeners;
	
	public TacheModel() throws ParseException{
		this(0, 0, "","az","",0,0,"01/25/15","01/12/15","01/12/15","01/12/15");
	}
	
	public TacheModel(int id, int idsousprojet, String nom, String objectif, String resultat, float budget, int charge, String dteDebSooner, String dteDebLater, String dteFinSooner, String dteFinLater) throws ParseException{
		this.id = id;
		this.idssprojet = idsousprojet;
		this.name = nom;
		this.objectif = objectif;
		this.resultats = resultat;
		this.budget = budget;
		this.responsable = new String(""); //Changer en employé
		this.charge = charge;
		this.dteDebSooner = formatter.parse(dteDebSooner);
		this.dteDebLater = formatter.parse(dteDebLater);
		this.dteFinSooner = formatter.parse(dteFinSooner);
		this.dteFinLater = formatter.parse(dteFinLater);

		this.listeners = new EventListenerList();
	}
	
	/*
	 * ===================================================
	 *       ACCESSEURS
	 * ===================================================
	 */
	public String getDesc(){
		DecimalFormat decimal = new DecimalFormat("#.00");
		String retour = id+" : " + idssprojet +name;
		retour += "; "+objectif+"; "+resultats;
		retour += "; "+decimal.format(budget);
		return retour;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getObjectif(){
		return this.objectif;
	}
	
	public String getResultat(){
		return this.resultats;
	}
	
	public float getBudget(){
		return this.budget;
	}
	
	public String getRespnsable(){
		return this.responsable;
	}
	
	public String getCharge(){
		return String.valueOf(this.charge);
	}
	
	public String getDateDebSooner(){
		return String.valueOf(this.dteDebSooner);
	}
	
	public String getDateDebLater(){
		return String.valueOf(this.dteDebLater);
	}
	
	public String getDateFinSooner(){
		return String.valueOf(this.dteFinSooner);
	}
	
	public String getDateFinLater(){
		return String.valueOf(this.dteFinLater);
	}
	
	/*
	 * ===================================================
	 *       MUTATEURS
	 * ===================================================
	 */
	
	public void setId(int id){
		this.id = id;
	}
	public void setIdSSProjet(int id){
		this.idssprojet = id;
	}
	public void setName(String name){
		this.name = name;
		fireNameChanged();
	}
	public void setObjectif(String objectif){
		this.objectif = objectif;
	}
	public void setResultats(String res){
		this.resultats = res;
	}
	public void setBudget(float budget){
		this.budget = budget;
	}
	public void setResponsable(String resp){ //A changer avec employé
		this.responsable = resp;
	}
	public void setDateDebSooner(String date) throws ParseException{
		this.dteDebSooner = formatter.parse(date);
	}
	public void setDateDebLater(String date) throws ParseException{
		this.dteDebLater = formatter.parse(date);
	}
	public void setDateFinSooner(String date) throws ParseException{
		this.dteFinSooner = formatter.parse(date);
	}
	public void setDateFinLater(String date) throws ParseException{
		this.dteFinLater = formatter.parse(date);
	}
	
	public void addTacheListener(TacheListener listener){
		listeners.add(TacheListener.class, listener);
	}
	public void removeProjectListener(TacheListener l){
		 listeners.remove(TacheListener.class, l);
	} 
	public void fireNameChanged(){
		TacheListener[] listenerList = (TacheListener[])listeners.getListeners(TacheListener.class);
 
		for(TacheListener listener : listenerList){
			listener.nameChanged(new TacheNameChangedEvent(this, getName()));
		}
	}
}
