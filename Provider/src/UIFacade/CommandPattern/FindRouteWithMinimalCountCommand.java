package UIFacade.CommandPattern;

import ApplicationFacade.ApplicationFacade;
import Helpers.Exceptions.RouteNotFoundException;
import Helpers.IPAdress;
import Network.Network;
import RouteProviders.Classes.MinimalCostRouteProvider;
import RouteProviders.Classes.MinimalElementsRouteProvider;

public class FindRouteWithMinimalCountCommand implements Command {

    @Override
    public void getRouteByID(String[] commandParts) throws RouteNotFoundException {
        ApplicationFacade.getInstance().
                getRouteByID(new Network(commandParts[1]), new MinimalElementsRouteProvider(commandParts[2]), Integer.parseInt(commandParts[3]), Integer.parseInt(commandParts[4]));
    }

    @Override
    public void getRouteByIP(String[] commandParts) throws RouteNotFoundException {
        ApplicationFacade.getInstance().
                getRouteByIP(new Network(commandParts[1]), new MinimalElementsRouteProvider(commandParts[2]), new IPAdress(commandParts[3]), new IPAdress(commandParts[4]));
    }
}
