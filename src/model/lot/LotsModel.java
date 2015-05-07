package model.lot;

import java.text.DecimalFormat;
import java.util.LinkedList;

import javax.swing.event.EventListenerList;
public class LotsModel {
	private int idlots;
	private int idprojets;
	private String name;
	private String responsable; //A changer en Employé
	private float budget;
	private LinkedList<Integer> ssprojets; //A changer en ssprojets
	
	private EventListenerList listeners;
	
	
	public LotsModel(){
		this(0,0, "","","",0);
	}
	
	public LotsModel(int id,int idproj, String nom, String objectif, String resultat, float budget){
		this.idlots = id;
		this.idprojets = idproj;
		this.name = nom;
		this.budget = budget;
		this.responsable = new String(""); //Changer en employé
		this.ssprojets = new LinkedList<Integer>(); //Changer en lots
		
		this.listeners = new EventListenerList();
	}
	
	/*
	 * ===================================================
	 *       ACCESSEURS
	 * ===================================================
	 */
	public String getDesc(){
		DecimalFormat decimal = new DecimalFormat("#.00");
		String retour = idlots+" : " + idprojets +name;
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
	
	/*
	 * ===================================================
	 *       MUTATEURS
	 * ===================================================
	 */
	
	public void setIdLots(int id){
		this.idlots = id;
	}
	public void setIdProj(int idprojet){
		this.idprojets = idprojet;
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
	public void addLot(int lot){ //A changer avec lot
		this.ssprojets.add(lot);
	}
	
	
	public void addLotListener(LotListener listener){
		listeners.add(LotListener.class, listener);
	}
	public void removeLotListener(LotListener l){
		 listeners.remove(LotListener.class, l);
	} 
	public void fireNameChanged(){
		LotListener[] listenerList = (LotListener[])listeners.getListeners(LotListener.class);
 
		for(LotListener listener : listenerList){
			listener.nameChanged(new LotNameChangedEvent(this, getName()));
		}
	}
}
