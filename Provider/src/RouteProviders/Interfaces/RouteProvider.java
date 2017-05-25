package RouteProviders.Interfaces;

import Helpers.IPAdress;
import Helpers.Route;
import Helpers.RouteNotFoundException;
import Network.Network;

public interface RouteProvider {
    public Route getRouteByID(int firstID, int secondID, Network network) throws RouteNotFoundException;

    public Route getRouteByIP(IPAdress firstIP, IPAdress secondIP, Network network) throws RouteNotFoundException;
}
