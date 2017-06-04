package RouteProvider.PathFinders;

import Helpers.*;
import Helpers.Exceptions.RouteNotFoundException;
import Network.Network;
import PathElements.AbstractClasses.PathElement;
import RouteProvider.RouteProvider;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

@XmlRootElement(name = "pathFinder")
public abstract class PathFinder {

    @XmlElement
    public String name;

    transient Map<PathElement, Set<ConnectionData>> adj;
    transient Map<Integer, Boolean> usedMap;
    transient Map<Integer, Integer> dist;
    transient Map<Integer, Integer> pred;
    transient int INF = ProjectFinalsContainer.INF;

    public PathFinder() {
        adj = new HashMap<>();
        usedMap = new HashMap<>();
        dist = new HashMap<>();
        pred = new HashMap<>();
        INF = ProjectFinalsContainer.INF;
    }

    public PathFinder(String name) {
        this();
        this.name = name;
    }

    public Route findPath(int first, int second, Network network) throws RouteNotFoundException {
        return null;
    }

    public Route findPath(String first, String second, Network network) throws RouteNotFoundException {
        return null;
    }

    public void printWay(int v) {
        if (!pred.containsKey(v)) {
            return;
        }
        printWay(pred.get(v));
        System.out.printf("%d ", v);
    }

    public void printData(Network network, int end) {
        for (PathElement v : network.pathElements) {
            if (dist.get(v.ID) != INF && v.ID == end) {
                System.out.printf("%d ", dist.get(v.ID));
            }
        }
        System.out.println("\n");
        for (PathElement v : network.pathElements) {
            if (v.ID!=end)
                continue;
            if (dist.get(v.ID) != INF) {
                System.out.printf("%d: ", v.ID);
                printWay(v.ID);
            }
            //System.out.println("\n");
        }
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
