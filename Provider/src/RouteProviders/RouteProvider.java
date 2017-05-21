package RouteProviders;

import Helpers.Route;
import Helpers.RouteNotFoundException;
import Network.Network;

public interface RouteProvider {
    public Route getRoute(int firstID, int secondID, Network network) throws RouteNotFoundException;
}
