package RouteProvider.PathFinders;

import Helpers.ApplicationData.ApplicationDataContainer;
import Helpers.ConnectionData;
import Helpers.Exceptions.RouteNotFoundException;
import Helpers.Route;
import Network.Network;
import PathElements.AbstractClasses.PathElement;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "MinimalTimePathFinder")
public class MinimalTimePathFinder extends PathFinder {

    public MinimalTimePathFinder(){
        super();
    }

    public MinimalTimePathFinder(String name){
        super(name);
    }

    @Override
    public Route findPath(int first, int second, Network network) throws RouteNotFoundException {
        System.out.println("зашел в Minimal Time Path Finder по ID");

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
                    int weightU = (int) connectionData.timeDelay;
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

        return new Route(printData(network, second));
    }

    @Override
    public Route findPath(String first, String second, Network network) throws RouteNotFoundException {
        System.out.println("Зашел в Minimal Time Path Finder по IP");

        PathElement element1 = network.getElementByIP(first);

        PathElement element2 = network.getElementByIP(second);

        return findPath(element1.ID, element2.ID, network);
    }
}
