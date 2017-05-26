package RouteProviders.Classes;

import Helpers.IPAdress;
import Helpers.ProjectsStringsContainer;
import Helpers.Route;
import Helpers.Exceptions.RouteNotFoundException;
import Network.Network;
import RouteProviders.Interfaces.RouteProvider;

public class MinimalElementsRouteProvider implements RouteProvider {

    String name;

    public String getName() {
        return ProjectsStringsContainer.MINIMAL_COUNT_ROUTE_PROVIDER_NAME;
    }

    public MinimalElementsRouteProvider(String name){
        this.name=name;
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
