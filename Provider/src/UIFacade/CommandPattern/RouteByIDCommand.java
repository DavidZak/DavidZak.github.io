package UIFacade.CommandPattern;

import ApplicationFacade.ApplicationFacade;

public class RouteByIDCommand implements Command {
    ApplicationFacade applicationFacade;

    public RouteByIDCommand(ApplicationFacade applicationFacade) {
        this.applicationFacade = applicationFacade;
    }

    @Override
    public void execute() {
        applicationFacade.getRouteByID();
    }
}
