package model.lot;

import java.util.EventListener;

public interface LotListener extends EventListener {
	public void nameChanged(LotNameChangedEvent event);
}


