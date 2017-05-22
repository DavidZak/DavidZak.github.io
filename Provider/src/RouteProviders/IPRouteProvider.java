package RouteProviders;

import Helpers.IPAdress;
import Helpers.Route;
import Helpers.RouteNotFoundException;
import Network.Network;
import PathElements.Interfaces.PathElement;

import java.util.List;

public class IPRouteProvider extends IDRouteProvider {

    public List<Route> getRoutes(IPAdress firstIP, IPAdress secondIP, Network network) throws RouteNotFoundException {
        return null;
    }
}
