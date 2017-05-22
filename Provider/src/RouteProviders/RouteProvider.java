package RouteProviders;

import Helpers.IPAdress;
import Helpers.Route;
import Helpers.RouteNotFoundException;
import Network.Network;

import java.util.List;

public interface RouteProvider {
    public List<Route> getRoutes(int firstID, int secondID, Network network) throws RouteNotFoundException;
}
