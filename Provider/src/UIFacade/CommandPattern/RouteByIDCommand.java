package UIFacade.CommandPattern;

import ApplicationFacade.ApplicationFacade;
import Helpers.Exceptions.RouteNotFoundException;

public class RouteByIDCommand implements Command {
    ApplicationFacade applicationFacade;

    public RouteByIDCommand(ApplicationFacade applicationFacade) {
        this.applicationFacade = applicationFacade;
    }

    @Override
    public void execute() throws RouteNotFoundException {
        applicationFacade.getRouteByID();
    }
}
