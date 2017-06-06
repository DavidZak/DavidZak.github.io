package UIFacade.CommandPattern;

import ApplicationFacade.ApplicationFacade;

public class RouteByIDCommand implements Command {      //конкретная команда для поиска маршрута по ID
    ApplicationFacade applicationFacade;

    public RouteByIDCommand(ApplicationFacade applicationFacade) {
        this.applicationFacade = applicationFacade;
    }

    @Override
    public void execute() {
        applicationFacade.getRouteByID();
    }
}
