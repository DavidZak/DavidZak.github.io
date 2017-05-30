package RouteProviders.Classes;

import Helpers.Exceptions.RouteNotFoundException;
import Helpers.IPAdress;
import Helpers.Route;
import Network.Network;
import RouteProviders.AbstractClass.RouteProvider;

public class MinimalTimeRouteProvider extends RouteProvider {

    public MinimalTimeRouteProvider(String providerName){
        super(providerName);
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
