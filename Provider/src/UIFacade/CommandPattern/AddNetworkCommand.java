package UIFacade.CommandPattern;

import ApplicationFacade.ApplicationFacade;

public class AddNetworkCommand implements Command{
    ApplicationFacade applicationFacade;

    public AddNetworkCommand(ApplicationFacade applicationFacade) {
        this.applicationFacade = applicationFacade;
    }

    @Override
    public void execute() {
        applicationFacade.addNetwork();
    }
}
