package UIFacade.CommandPattern;

import ApplicationFacade.ApplicationFacade;
import Helpers.Exceptions.RouteNotFoundException;

public class RouteByIPCommand implements Command {
    ApplicationFacade applicationFacade;

    public RouteByIPCommand(ApplicationFacade applicationFacade) {
        this.applicationFacade = applicationFacade;
    }

    @Override
    public void execute() throws RouteNotFoundException {
        applicationFacade.getRouteByIP();
    }
}
