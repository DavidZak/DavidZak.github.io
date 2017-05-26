package RouteProviders.Classes;

import Helpers.IPAdress;
import Helpers.ProjectsStringsContainer;
import Helpers.Route;
import Helpers.Exceptions.RouteNotFoundException;
import Network.Network;
import RouteProviders.Interfaces.RouteProvider;

public class MinimalCostRouteProvider implements RouteProvider {

    String name;

    public MinimalCostRouteProvider(String name){
        this.name=name;
    }

    public String getName() {
        return name;
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
