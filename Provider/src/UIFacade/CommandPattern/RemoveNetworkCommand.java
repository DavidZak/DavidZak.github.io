package UIFacade.CommandPattern;

import ApplicationFacade.ApplicationFacade;

public class RemoveNetworkCommand implements Command {
    ApplicationFacade applicationFacade;

    public RemoveNetworkCommand(ApplicationFacade applicationFacade) {
        this.applicationFacade = applicationFacade;
    }

    @Override
    public void execute() {
        applicationFacade.removeNetwork();
    }
}
