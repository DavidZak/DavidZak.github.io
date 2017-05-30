package UIFacade.CommandPattern;

import Helpers.Exceptions.RouteNotFoundException;

public interface Command {

    void execute() throws RouteNotFoundException;

}
