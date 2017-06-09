package ApplicationFacade;

import Helpers.ApplicationData.ApplicationDataContainer;
import Helpers.Exceptions.RouteNotFoundException;
import Helpers.IPAddress;
import Helpers.Route;
import Network.Network;
import PathElements.AbstractClasses.PathElement;
import RouteProvider.PathFinders.PathFinder;
import RouteProvider.RouteProvider;

public class ApplicationFacade {

    private Network network;
    private RouteProvider provider;
    private int firstID;
    private int secondID;
    private IPAddress firstIP;
    private IPAddress secondIP;
    private PathElement element;
    private PathFinder pathFinder;

    public Network getNetwork() {
        return network;
    }

    public void setNetwork(Network network) {
        this.network = network;
    }

    //constructor for adding Network
    public ApplicationFacade(Network network) {
        this.network = network;
    }

    //for adding PathFinder
    public ApplicationFacade(RouteProvider provider, PathFinder pathFinder) {
        this.provider = provider;
        this.pathFinder = pathFinder;
    }

    //constructor for adding Provider
    public ApplicationFacade(RouteProvider provider) {
        this.provider = provider;
    }

    //constructor for adding PathElement
    public ApplicationFacade(Network network, PathElement element) {
        this.network = network;
        this.element = element;
    }

    //constructors for find route commands
    public ApplicationFacade(Network network, RouteProvider provider, int firstID, int secondID) {
        this.provider = provider;
        this.network = network;
        this.firstID = firstID;
        this.secondID = secondID;
    }

    public ApplicationFacade(Network network, RouteProvider provider, IPAddress firstIP, IPAddress secondIP) {
        this.provider = provider;
        this.network = network;
        this.firstIP = firstIP;
        this.secondIP = secondIP;
    }

    public Route getRouteByID() {
        Route route = null;
        try {
            route = provider.getRoute(firstID, secondID, network);
        } catch (RouteNotFoundException e) {
            e.getMessage();
        }
        return route;
    }

    public Route getRouteByIP() {
        Route route = null;
        try {
            route = provider.getRoute(firstIP, secondIP, network);
        } catch (RouteNotFoundException e) {
            e.getMessage();
        }
        return route;
    }
    //методы для манипуляции с данными
    public void addPathElement() {
        ApplicationDataContainer.getInstance().addPathElement(network, element);
    }

    public void removePathElement() {
        ApplicationDataContainer.getInstance().removePathElement(network, element);
    }

    public void addNetwork() {
        ApplicationDataContainer.getInstance().addNetwork(network);
    }

    public void addRouteProvider() {
        ApplicationDataContainer.getInstance().addRouteProvider(provider);
    }

    public Network getNetworkByName() {
        return ApplicationDataContainer.getInstance().getNetwork(network.networkName);
    }

    public RouteProvider getRouteProviderByName() {
        return ApplicationDataContainer.getInstance().getRouteProvider(provider.providerName);
    }

    public void removeNetwork() {
        ApplicationDataContainer.getInstance().removeNetwork(network);
    }

    public void removeRouteProvider() {
        ApplicationDataContainer.getInstance().removeRouteProvider(provider);
    }

    public void addPathFinder(){
        ApplicationDataContainer.getInstance().addPathFinder(provider, pathFinder);
    }
}
