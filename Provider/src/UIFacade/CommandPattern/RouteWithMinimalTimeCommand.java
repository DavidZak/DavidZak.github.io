package UIFacade.CommandPattern;

import Helpers.Exceptions.RouteNotFoundException;
import Network.Network;
import RouteProviders.AbstractClass.RouteProvider;
import RouteProviders.Classes.MinimalCostRouteProvider;

public class RouteWithMinimalTimeCommand implements Command {
    private RouteProvider provider = new MinimalCostRouteProvider();
    private Network network = new Network();
    private int firstID;
    private int secondID;

    public RouteWithMinimalTimeCommand(String networkName, String providerName, String firstID, String secondID) {
        this.network.setNetworkName(networkName);
        this.provider.setProviderName(providerName);
        this.firstID = Integer.parseInt(firstID);
        this.secondID = Integer.parseInt(secondID);
    }

    @Override
    public void execute() throws RouteNotFoundException {

    }
}
