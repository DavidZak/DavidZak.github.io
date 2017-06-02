package RouteProvider;

import Helpers.Exceptions.RouteNotFoundException;
import Helpers.IPAddress;
import Helpers.ProjectValuesGenerator;
import Helpers.Route;
import Network.Network;
import RouteProvider.PathFinders.PathFinder;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="provider")
@XmlType(propOrder = {"providerName","pathFinder"})
public class RouteProvider {

    @XmlElement(name = "providerName")
    public String providerName;

    @XmlElement(name = "pathFinder")
    public PathFinder pathFinder;

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public RouteProvider() {
        this.providerName = ProjectValuesGenerator.generateString();
        this.pathFinder = null;
        System.out.println(this.providerName);
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
        return providerName;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (providerName == null ? 0 : providerName.hashCode());
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
        if (!providerName.equals(other.providerName))
            return false;
        return true;
    }

    public void setPathFinder(PathFinder pathFinder) {
        this.pathFinder = pathFinder;
    }
}
