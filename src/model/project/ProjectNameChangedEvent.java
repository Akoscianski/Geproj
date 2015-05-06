package model.project;

import java.util.EventObject;

public class ProjectNameChangedEvent extends EventObject {
	private String newName;
	
	public ProjectNameChangedEvent(Object source, String newName){
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
