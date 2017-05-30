package ApplicationFacade;

import Helpers.Exceptions.RouteNotFoundException;
import Helpers.IPAdress;
import Helpers.Route;
import Network.Network;
import RouteProviders.AbstractClass.RouteProvider;

import java.util.Set;

public class ApplicationFacade {

    private Set<Network> networks;

    public Set<Network> getNetworks() {
        return networks;
    }

    private static ApplicationFacade instance;

    private ApplicationFacade() {

    }

    public static ApplicationFacade getInstance() {
        if (instance == null)
            instance = new ApplicationFacade();
        return instance;
    }

    public Route getRouteByID(Network network, RouteProvider provider, int firstID, int secondID) throws RouteNotFoundException {
        return provider.getRouteByID(firstID, secondID, network);
    }

    public Route getRouteByIP(Network network, RouteProvider provider, IPAdress firstIP, IPAdress secondIP) throws RouteNotFoundException {
        return provider.getRouteByIP(firstIP, secondIP, network);
    }
}
