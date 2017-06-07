package UIFacade.CommandPattern;

import ApplicationFacade.ApplicationFacade;

public class AddRouteProviderCommand implements Command {
    ApplicationFacade applicationFacade;

    public AddRouteProviderCommand(ApplicationFacade applicationFacade) {
        this.applicationFacade = applicationFacade;
    }

    @Override
    public void execute() {
        applicationFacade.addRouteProvider();
    }
}
