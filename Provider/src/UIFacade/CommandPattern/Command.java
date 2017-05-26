package UIFacade.CommandPattern;

import Helpers.Exceptions.RouteNotFoundException;
import UIFacade.UIFacade;

public interface Command {

    void getRouteByID(String[] commandParts) throws RouteNotFoundException;
    void getRouteByIP(String[] commandParts) throws RouteNotFoundException;

}
