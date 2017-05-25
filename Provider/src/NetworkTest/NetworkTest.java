package NetworkTest;

import Helpers.IPAdress;
import Helpers.Route;
import Helpers.RouteMode;
import Helpers.RouteNotFoundException;
import Network.Network;
import RouteProviders.IDRouteProvider;
import RouteProviders.IPRouteProvider;

import java.util.List;

public class NetworkTest {

    private static NetworkTest instance;

    private NetworkTest() {

    }

    public NetworkTest getInstance() {
        if (instance == null)
            instance = new NetworkTest();
        return instance;
    }

    private List<Network> networks;

    public List<Network> getNetworks() {
        return networks;
    }

    public List<Route> getRoutesByID(IDRouteProvider provider, int firstID, int secondID, Network network) throws RouteNotFoundException {
        if (getNetworks().contains(network)) {
            //return provider.getRoute(firstID, secondID, network);
        }
        return null;
    }

    public List<Route> getRoutesByIP(IPRouteProvider provider, IPAdress firstIP, IPAdress secondIP, Network network) throws RouteNotFoundException {
        if (getNetworks().contains(network)) {
            //return provider.getRoute(firstIP, secondIP, network);
        }
        return null;
    }

    public Route getRouteByIDWithMode(IDRouteProvider provider, int firstID, int secondID, Network network, RouteMode mode) throws RouteNotFoundException {
        List<Route> routes = getRoutesByID(provider, firstID, secondID, network);
        if (mode == RouteMode.ROUTE_WITH_MINIMAL_COST) {
            return null;
        }
        if (mode == RouteMode.ROUTE_WITH_MINIMAL_TIME_DELAY) {
            return null;
        }
        if (mode == RouteMode.ROUTE_WITH_MINIMAL_ELEMENTS_COUNT) {
            return null;
        }
        return null;
    }

    public Route getRouteByIPWithMode(IPRouteProvider provider, IPAdress firstIP, IPAdress secondIP, Network network, RouteMode mode) throws RouteNotFoundException {
        List<Route> routes = getRoutesByIP(provider, firstIP, secondIP, network);
        if (mode == RouteMode.ROUTE_WITH_MINIMAL_COST) {
            return null;
        }
        if (mode == RouteMode.ROUTE_WITH_MINIMAL_TIME_DELAY) {
            return null;
        }
        if (mode == RouteMode.ROUTE_WITH_MINIMAL_ELEMENTS_COUNT) {
            return null;
        }
        return null;
    }
}
