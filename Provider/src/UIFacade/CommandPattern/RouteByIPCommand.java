package UIFacade.CommandPattern;

import ApplicationFacade.ApplicationFacade;

public class RouteByIPCommand implements Command {      //конкретная команда для поиска маршрута по IP
    ApplicationFacade applicationFacade;

    public RouteByIPCommand(ApplicationFacade applicationFacade) {
        this.applicationFacade = applicationFacade;
    }

    @Override
    public void execute() {
        applicationFacade.getRouteByIP();
    }
}
