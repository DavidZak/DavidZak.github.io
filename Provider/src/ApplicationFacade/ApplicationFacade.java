package ApplicationFacade;

import Helpers.Exceptions.NetworkNotFoundException;
import Helpers.Exceptions.ProviderNotFoundException;
import Helpers.Exceptions.RouteNotFoundException;
import Helpers.IPAddress;
import Helpers.Route;
import Network.Network;
import RouteProviders.AbstractClass.RouteProvider;

import java.util.Set;

public class ApplicationFacade {

    private Set<Network> networks;
    private Set<RouteProvider> routeProviders;

    public Set<Network> getNetworks() {
        return networks;
    }

    public void setNetworks(Set<Network> networks) {
        this.networks = networks;
    }

    public Set<RouteProvider> getRouteProviders() {
        return routeProviders;
    }

    public void setRouteProviders(Set<RouteProvider> routeProviders) {
        this.routeProviders = routeProviders;
    }

    private static ApplicationFacade instance;

    private ApplicationFacade() {

    }

    public static ApplicationFacade getInstance() {
        if (instance == null)
            instance = new ApplicationFacade();
        return instance;
    }

    public Route getRoute(Network network, RouteProvider provider, int firstID, int secondID) throws RouteNotFoundException, NetworkNotFoundException, ProviderNotFoundException {
        if (!getNetworks().contains(network)){
            throw new NetworkNotFoundException();
        }
        if (!getRouteProviders().contains(provider)){
            throw new ProviderNotFoundException();
        }

        return provider.getRoute(firstID, secondID, network);
    }

    public Route getRoute(Network network, RouteProvider provider, IPAddress firstIP, IPAddress secondIP) throws RouteNotFoundException, ProviderNotFoundException, NetworkNotFoundException {
        if (!getNetworks().contains(network)){
            throw new NetworkNotFoundException();
        }
        if (!getRouteProviders().contains(provider)){
            throw new ProviderNotFoundException();
        }

        return provider.getRoute(firstIP, secondIP, network);
    }


}
