package model.employe;

import java.util.EventListener;

public interface EmployeListener extends EventListener {
	public void nameChanged(EmployeNameChangedEvent event);
}

