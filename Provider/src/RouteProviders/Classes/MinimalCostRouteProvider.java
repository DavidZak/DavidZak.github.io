package RouteProviders.Classes;

import Helpers.Exceptions.RouteNotFoundException;
import Helpers.IPAddress;
import Helpers.Route;
import Network.Network;
import RouteProviders.AbstractClass.RouteProvider;

public class MinimalCostRouteProvider extends RouteProvider {

    public MinimalCostRouteProvider(){
        super();
    }

    public MinimalCostRouteProvider(String providerName){
        super(providerName);
    }

    public Route getRoute(int firstID, int secondID, Network network) throws RouteNotFoundException {
        throw new RouteNotFoundException();
    }

    public Route getRoute(IPAddress firstIP, IPAddress secondIP, Network network) throws RouteNotFoundException {
        return null;
    }
}
