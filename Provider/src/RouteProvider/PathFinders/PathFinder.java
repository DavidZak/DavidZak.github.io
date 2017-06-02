package RouteProvider.PathFinders;

import Helpers.IPAddress;
import Helpers.Route;
import Network.Network;
import PathElements.AbstractClasses.PathElement;
import RouteProvider.RouteProvider;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "pathFinder")
public abstract class PathFinder {

    @XmlElement
    public String name;

    public Route findPath(int first, int second, Network network) {
        return null;
    }

    public Route findPath(String first, String second, Network network) {
        return null;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (name == null ? 0 : name.hashCode());
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
        PathFinder other = (PathFinder) obj;
        if (!name.equals(other.name))
            return false;
        return true;
    }
}
