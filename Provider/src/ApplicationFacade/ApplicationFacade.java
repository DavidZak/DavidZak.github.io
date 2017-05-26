package ApplicationFacade;

import Helpers.IPAdress;
import Helpers.Route;
import Helpers.Exceptions.RouteNotFoundException;
import Network.Network;
import RouteProviders.Interfaces.RouteProvider;

import java.util.List;

public class ApplicationFacade {

    private List<Network> networks;

    public List<Network> getNetworks() {
        return networks;
    }

    private static ApplicationFacade instance;
    private ApplicationFacade() {

    }

    public static ApplicationFacade getInstance() {
        if (instance==null)
            instance=new ApplicationFacade();
        return instance;
    }

    public Route getRouteByID(RouteProvider provider, int firstID, int secondID, Network network) throws RouteNotFoundException {
        return provider.getRouteByID(firstID, secondID, network);
    }

    public Route getRouteByIP(RouteProvider provider, IPAdress firstIP, IPAdress secondIP, Network network) throws RouteNotFoundException {
        return provider.getRouteByIP(firstIP, secondIP, network);
    }
}
