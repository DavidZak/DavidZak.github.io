package UIFacade.CommandPattern;

import ApplicationFacade.ApplicationFacade;

public class RemoveRouteProviderCommand implements Command{

    ApplicationFacade applicationFacade;

    public RemoveRouteProviderCommand(ApplicationFacade applicationFacade) {
        this.applicationFacade = applicationFacade;
    }

    @Override
    public void execute() {
        applicationFacade.removeRouteProvider();
    }
}
