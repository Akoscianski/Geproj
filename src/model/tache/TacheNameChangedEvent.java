package model.tache;

import java.util.EventObject;

public class TacheNameChangedEvent extends EventObject {
	
	private static final long serialVersionUID = 1L;
	private String newName;
	
	public TacheNameChangedEvent(Object source, String newName){
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
