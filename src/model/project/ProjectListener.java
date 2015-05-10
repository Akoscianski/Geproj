package model.project;

import java.util.EventListener;

public interface ProjectListener extends EventListener {
	public void nameChanged(ProjectNameChangedEvent event);

	public void choiceDone(ProjectNewRespEvent projectNewRespEvent);

	public void respChanged(ProjectNameChangedEvent projectNameChangedEvent);
}



