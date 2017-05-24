package RouteProviders;

import Helpers.IPAdress;
import Helpers.Route;
import Helpers.RouteNotFoundException;
import Network.Network;
import PathElements.Interfaces.PathElement;

import java.util.ArrayList;
import java.util.List;

public class IDRouteProvider implements RouteProvider {

    public List<PathElement> addPathElementToRoute(List<PathElement> elements, PathElement element){
        elements.add(element);
        return elements;
    }

    @Override
    public List<Route> getRoutes(int firstID, int secondID, Network network) throws RouteNotFoundException {

        Route route=new Route();

        PathElement tempElement = null;

        for (PathElement element: network.getPathElements()){
            if (element.getID()==firstID){
               tempElement=element;
               addPathElementToRoute(route.getPathElementsInRoute(),element);
               while(tempElement.getID()!=secondID){
                   //for (int i=0;i<tempElement.getConnections().size();i++){
                       tempElement=tempElement.getConnections().get(1);
                       System.out.println(route.getPathElementsInRoute().size());
                       addPathElementToRoute(route.getPathElementsInRoute(),tempElement);
                       System.out.println(tempElement.getID());
                   //}
               }
               return new ArrayList<>();
            }
        }
        return null;
    }
}
