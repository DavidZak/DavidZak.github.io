package UIFacade.CommandPattern;

import ApplicationFacade.ApplicationFacade;

public class AddPathFinderCommand implements Command {
    ApplicationFacade applicationFacade;

    public AddPathFinderCommand(ApplicationFacade applicationFacade) {
        this.applicationFacade = applicationFacade;
    }

    @Override
    public void execute() {
        applicationFacade.addPathFinder();
    }
}
