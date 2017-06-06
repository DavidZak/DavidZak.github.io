package RouteProvider.PathFinders;

import Helpers.ConnectionData;
import Helpers.Exceptions.RouteNotFoundException;
import Helpers.ProjectFinalsContainer;
import Helpers.Route;
import Network.Network;
import PathElements.AbstractClasses.PathElement;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

@XmlRootElement(name = "pathFinder")
@XmlSeeAlso({MinimalCostPathFinder.class, MinimalCountPathFinder.class, MinimalTimePathFinder.class})
public class PathFinder {       //базовый поисковик пути

    @XmlElement
    public String name;

    transient Map<PathElement, Set<ConnectionData>> adj;    //список смежных элементов для данного элемента
    transient Map<Integer, Boolean> usedMap;    //маркер, показывающий просмотрен данный элемент или нет
    transient Map<Integer, Integer> dist;   //вес (cost или time)
    transient Map<Integer, Integer> pred;   //предыдущие элементы
    transient int INF = ProjectFinalsContainer.INF;     //бесконечность

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

    LinkedHashSet<Integer> integers = new LinkedHashSet<>();

    public void printWay(int v) {   //вывод пути
        if (!pred.containsKey(v)) {
            return;
        }
        printWay(pred.get(v));
        integers.add(pred.get(v));
        System.out.printf("%d ", v);
    }

    public LinkedHashSet<Integer> printData(Network network, int end) { //вывод
        for (PathElement v : network.pathElements) {
            if (dist.get(v.ID) != INF && v.ID == end) {
                System.out.printf("%d ", dist.get(v.ID));
            }
        }

        integers = new LinkedHashSet<>();

        System.out.println("\n");
        for (PathElement v : network.pathElements) {
            if (v.ID != end)
                continue;
            if (dist.get(v.ID) != INF) {
                System.out.printf("%d: ", v.ID);
                printWay(v.ID);
            }
        }
        return integers;
    }

    @Override
    public String toString() {
        return "PathFinder: name: " + name;
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
