package RouteProviders.Classes;

import Helpers.Exceptions.RouteNotFoundException;
import Helpers.IPAdress;
import Helpers.Route;
import Network.Network;
import RouteProviders.AbstractClass.RouteProvider;

public class MinimalCostRouteProvider extends RouteProvider {

    public MinimalCostRouteProvider(String providerName){
        super(providerName);
    }

    @Override
    public Route getRouteByID(int firstID, int secondID, Network network) throws RouteNotFoundException {
        throw new RouteNotFoundException();
    }

    @Override
    public Route getRouteByIP(IPAdress firstIP, IPAdress secondIP, Network network) throws RouteNotFoundException {
        return null;
    }
}
