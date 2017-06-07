package UIFacade.CommandPattern;

import ApplicationFacade.ApplicationFacade;

public class AddPathElementCommand implements Command{
    ApplicationFacade applicationFacade;

    public AddPathElementCommand(ApplicationFacade applicationFacade) {
        this.applicationFacade = applicationFacade;
    }

    @Override
    public void execute() {
        applicationFacade.addPathElement();
    }
}
