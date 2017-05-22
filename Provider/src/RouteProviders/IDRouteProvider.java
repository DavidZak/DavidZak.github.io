package RouteProviders;

import Helpers.IPAdress;
import Helpers.Route;
import Helpers.RouteNotFoundException;
import Network.Network;
import PathElements.Interfaces.PathElement;

import java.util.List;

public class IDRouteProvider implements RouteProvider {
    @Override
    public List<Route> getRoutes(int firstID, int secondID, Network network) throws RouteNotFoundException {
        return null;
    }
}
