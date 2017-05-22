package RouteProviders;

import Helpers.IPAdress;
import Helpers.Route;
import Helpers.RouteNotFoundException;
import Network.Network;
import PathElements.Interfaces.PathElement;

import java.util.List;

public class IPRouteProvider extends IDRouteProvider {
    @Override
    public List<Route> getRoutes(int firstID, int secondID, Network network) throws RouteNotFoundException {
        return null;
    }

    public List<Route> getRoutes(IPAdress firstIP, IPAdress secondIP, Network network) throws RouteNotFoundException {
        return null;
    }
}
