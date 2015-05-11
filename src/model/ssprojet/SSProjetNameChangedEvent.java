package model.ssprojet;

import java.util.EventObject;

public class SSProjetNameChangedEvent extends EventObject {

	private static final long serialVersionUID = 1L;
	private String newName;
	
	public SSProjetNameChangedEvent(Object source, String newName){
		super(source);
		
		this.newName = newName;
	}
	
	public String getNewName(){
		return newName;
	}
	
	/*
	public VolumeChangedEvent(Object source, int newVolume){
		super(source);
		
		this.newVolume = newVolume;
	}
	
	public int getNewVolume(){
		return newVolume;
	}*/
}
