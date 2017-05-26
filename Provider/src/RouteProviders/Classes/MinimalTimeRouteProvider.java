package RouteProviders.Classes;

import Helpers.IPAdress;
import Helpers.ProjectsStringsContainer;
import Helpers.Route;
import Helpers.Exceptions.RouteNotFoundException;
import Network.Network;
import RouteProviders.Interfaces.RouteProvider;

public class MinimalTimeRouteProvider implements RouteProvider {
    @Override
    public String getName() {
        return ProjectsStringsContainer.MINIMAL_TIME_ROUTE_PROVIDER_NAME;
    }

    @Override
    public Route getRouteByID(int firstID, int secondID, Network network) throws RouteNotFoundException {
        return null;
    }

    @Override
    public Route getRouteByIP(IPAdress firstIP, IPAdress secondIP, Network network) throws RouteNotFoundException {
        return null;
    }
}
