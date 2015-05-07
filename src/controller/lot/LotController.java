package controller.lot;

import model.lot.LotsModel;
import view.lot.JFrameLot;

public class LotController {
	public LotView view = null;
	
	private LotsModel model = null;
	
	public LotController(LotsModel model){
		this.model = model;
		
		view = new JFrameLot(this, model);
		addListenerToModel();
	}
	
	private void addListenerToModel(){
		model.addLotListener(view);
	}
	
	public void displayViews(){
		view.display();
	}
	
	public void closeViews(){
		view.close();
	}
	
	public void notifyLotNameChanged(String name){
		model.setName(name);
	}
}