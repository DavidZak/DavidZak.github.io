package RouteProviders;

import Helpers.Route;
import Helpers.RouteNotFoundException;
import Network.Network;

public class IPProvider implements RouteProvider {
    @Override
    public Route getRoute(int firstID, int secondID, Network network) throws RouteNotFoundException {
        return null;
    }
}
