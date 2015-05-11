package model.ssprojet;

import java.util.EventListener;

public interface SSProjetListener extends EventListener {
	public void nameChanged(SSProjetNameChangedEvent event);
}


