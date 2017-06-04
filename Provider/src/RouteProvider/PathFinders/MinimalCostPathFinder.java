package RouteProvider.PathFinders;

import Helpers.ApplicationData.ApplicationDataContainer;
import Helpers.ConnectionData;
import Helpers.Exceptions.RouteNotFoundException;
import Helpers.Route;
import Network.Network;
import PathElements.AbstractClasses.ActiveElement;
import PathElements.AbstractClasses.PathElement;

import java.util.*;

public class MinimalCostPathFinder extends PathFinder {

    public MinimalCostPathFinder() {
        super();
    }

    public MinimalCostPathFinder(String name){
        super(name);
    }

    @Override
    public Route findPath(int first, int second, Network network) throws RouteNotFoundException {
        System.out.println("зашел в MinimalCostPathFinder по ID");

        PathElement startElement = null;

        for (PathElement element : network.pathElements) {
            dist.put(element.ID, INF);
            adj.put(element, element.connections);
            usedMap.put(element.ID, false);
        }

        dist.put(first, 0);

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

        printData(network, second);
        return null;
    }

    @Override
    public Route findPath(String first, String second, Network network) throws RouteNotFoundException {
        return null;
    }
}
