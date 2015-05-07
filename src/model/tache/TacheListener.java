package model.tache;

import java.util.EventListener;

public interface TacheListener extends EventListener {
	public void nameChanged(TacheNameChangedEvent event);
}



