package RouteProvider;

import Helpers.Exceptions.RouteNotFoundException;
import Helpers.IPAddress;
import Helpers.ProjectValuesGenerator;
import Helpers.Route;
import Network.Network;
import PathElements.AbstractClasses.PassiveElement;
import PathElements.AbstractClasses.PathElement;
import RouteProvider.PathFinders.PathFinder;

public class RouteProvider {

    private String providerName;
    private PathFinder pathFinder;

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public RouteProvider() {
        this.providerName = ProjectValuesGenerator.generateString();
        this.pathFinder = null;
        System.out.println(this.getProviderName());
    }

    public RouteProvider(String providerName, PathFinder pathFinder) {
        this.setProviderName(providerName);
        this.pathFinder = pathFinder;
    }

    public Route getRoute(int firstID, int secondID, Network network) throws RouteNotFoundException {
        return pathFinder.findPath(firstID, secondID, network);
    }

    public Route getRoute(IPAddress firstIP, IPAddress secondIP, Network network) throws RouteNotFoundException {
        return pathFinder.findPath(firstIP.getIp(), secondIP.getIp(), network);
    }

    @Override
    public String toString() {
        return getProviderName();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (getProviderName() == null ? 0 : getProviderName().hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        RouteProvider other = (RouteProvider) obj;
        if (!getProviderName().equals(other.getProviderName()))
            return false;
        return true;
    }

    public PathFinder getPathFinder() {
        return pathFinder;
    }

    public void setPathFinder(PathFinder pathFinder) {
        this.pathFinder = pathFinder;
    }
}
