package model.project;

import java.util.EventListener;

public interface ProjectListener extends EventListener {
	public void nameChanged(ProjectNameChangedEvent event);
}
