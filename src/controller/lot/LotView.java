package controller.lot;

import model.lot.LotListener;


public abstract class LotView implements LotListener {
	private LotController controller = null;
	
	public LotView(LotController controller){
		super();
		
		this.controller = controller;
	}
	
	public final LotController getController(){
		return controller;
	}
	
	public abstract void display();
	public abstract void close();
}