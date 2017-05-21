package RouteProviders;

import Helpers.Route;
import Helpers.RouteNotFoundException;
import Network.Network;

/**
 * Created by mrAdmin on 21.05.2017.
 */
public class IDProvider implements RouteProvider {
    @Override
    public Route getRoute(int firstID, int secondID, Network network) throws RouteNotFoundException {
        return null;
    }
}
