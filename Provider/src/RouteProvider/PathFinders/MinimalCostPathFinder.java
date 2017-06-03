package RouteProvider.PathFinders;

import Helpers.ConnectionData;
import Helpers.Route;
import Network.Network;
import PathElements.AbstractClasses.PathElement;

import java.util.*;

public class MinimalCostPathFinder extends PathFinder {

    Map<PathElement, Set<ConnectionData>> adj;
    Map<Integer, Boolean> usedMap;
    Map<Integer, Integer> dist;
    Map<Integer, Integer> pred;
    int INF = 10000;

    public MinimalCostPathFinder() {
        adj = new HashMap<>();
        usedMap = new HashMap<>();
        dist = new HashMap<>();
        pred = new HashMap<>();
        INF = 10000;
    }

    @Override
    public Route findPath(int first, int second, Network network) {
        System.out.println("зашел куда надо");

        PathElement startElement = null;

        for (PathElement element : network.pathElements) {
            dist.put(element.ID, INF);
            adj.put(element, element.connections);
            usedMap.put(element.ID, false);
        }

        dist.put(first, 0);
        for (Map.Entry<Integer, Boolean> entry : usedMap.entrySet())
            System.out.println(entry.getKey() + " -- " + entry.getValue());

        for (PathElement element : network.pathElements) {

            PathElement v = null;
            int distV = INF;
            //выбираем вершину, кратчайшее расстояние до которого еще не найдено
            for (PathElement pathElement : network.pathElements) {
                if (usedMap.get(pathElement.ID) == true) {
                    continue;
                }
                if (distV < dist.get(pathElement.ID)) {
                    continue;
                }
                v = pathElement;
                distV = dist.get(pathElement.ID);
            }
            //рассматриваем все дуги, исходящие из найденной вершины
            if (v != null) {
                for (ConnectionData connectionData : v.connections) {
                    int id = connectionData.pathElementID;
                    int weightU = (int) connectionData.cost;
                    //релаксация вершины
                    if (dist.get(v.ID) + weightU < dist.get(id)) {
                        dist.put(id, dist.get(v.ID) + weightU);
                        pred.put(id, v.ID);
                    }
                }
            }
            //помечаем вершину v просмотренной, до нее найдено кратчайшее расстояние
            usedMap.put(v.ID, true);
        }

        if (startElement != null) {
            for (ConnectionData connectionData : startElement.connections) {
                int data = connectionData.pathElementID;
                usedMap.put(data, false);
            }
        }
        printData(network);
        return null;
    }

    void printWay(int v) {
        if (!pred.containsKey(v)) {
            return;
        }
        printWay(pred.get(v));
        System.out.printf("%d ", v);
    }

    void printData(Network network) {
        for (PathElement v : network.pathElements) {
            if (dist.get(v.ID) != INF) {
                System.out.printf("%d ", dist.get(v.ID));
            } else {
                System.out.println("-1 ");
            }
        }
        System.out.println("\n");
        for (PathElement v : network.pathElements) {
            System.out.printf("%d: ", v.ID);
            if (dist.get(v.ID) != INF) {
                printWay(v.ID);
            }
            System.out.println("\n");
        }
    }

    @Override
    public Route findPath(String first, String second, Network network) {
        return null;
    }
}
