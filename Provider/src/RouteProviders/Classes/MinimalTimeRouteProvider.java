package RouteProviders.Classes;

import Helpers.Exceptions.RouteNotFoundException;
import Helpers.IPAddress;
import Helpers.Route;
import Network.Network;
import RouteProviders.AbstractClass.RouteProvider;

public class MinimalTimeRouteProvider extends RouteProvider {

    public MinimalTimeRouteProvider(){
        super();
    }

    public MinimalTimeRouteProvider(String providerName){
        super(providerName);
    }

    @Override
    public Route getRoute(int firstID, int secondID, Network network) throws RouteNotFoundException {
        return null;
    }

    @Override
    public Route getRoute(IPAddress firstIP, IPAddress secondIP, Network network) throws RouteNotFoundException {
        return null;
    }
}
