package UIFacade.CommandPattern;

import ApplicationFacade.ApplicationFacade;

public class RouteByIPCommand implements Command {
    ApplicationFacade applicationFacade;

    public RouteByIPCommand(ApplicationFacade applicationFacade) {
        this.applicationFacade = applicationFacade;
    }

    @Override
    public void execute() {
        applicationFacade.getRouteByIP();
    }
}
