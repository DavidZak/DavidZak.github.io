package ApplicationFacade;

import Helpers.Exceptions.RouteNotFoundException;
import Helpers.IPAddress;
import Helpers.Route;
import Network.Network;
import RouteProvider.RouteProvider;

public class ApplicationFacade {

    private Network network;
    private RouteProvider provider;
    private int firstID;
    private int secondID;
    private IPAddress firstIP;
    private IPAddress secondIP;

    public Network getNetwork() {
        return network;
    }

    public void setNetwork(Network network) {
        this.network = network;
    }

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

    public Route getRouteByID() throws RouteNotFoundException {
        return provider.getRoute(firstID, secondID, network);
    }

    public Route getRouteByIP() throws RouteNotFoundException {
        return provider.getRoute(firstIP, secondIP, network);
    }
}
