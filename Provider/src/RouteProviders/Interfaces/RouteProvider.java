package RouteProviders.Interfaces;

import Helpers.IPAdress;
import Helpers.Route;
import Helpers.Exceptions.RouteNotFoundException;
import Network.Network;

public interface RouteProvider {

    String getName();

    public Route getRouteByID(int firstID, int secondID, Network network) throws RouteNotFoundException;

    public Route getRouteByIP(IPAdress firstIP, IPAdress secondIP, Network network) throws RouteNotFoundException;
}
