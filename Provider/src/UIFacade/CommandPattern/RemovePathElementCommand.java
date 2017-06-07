package UIFacade.CommandPattern;

import ApplicationFacade.ApplicationFacade;

public class RemovePathElementCommand implements Command {
    ApplicationFacade applicationFacade;

    public RemovePathElementCommand(ApplicationFacade applicationFacade) {
        this.applicationFacade = applicationFacade;
    }

    @Override
    public void execute() {
        applicationFacade.removePathElement();
    }
}
