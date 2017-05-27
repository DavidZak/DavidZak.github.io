package Main;

import Helpers.Exceptions.RouteNotFoundException;
import Helpers.PathFinderHelper;
import Network.Network;
import PathElements.Classes.Switch;
import PathElements.AbstractClasses.PathElement;
import UIFacade.UIFacade;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws RouteNotFoundException {

        //UIFacade.getInstance().readInput();
        PathElement pathElement1=new Switch();
        PathElement pathElement2=new Switch();
        PathElement pathElement3=new Switch();
        PathElement pathElement4=new Switch();
        PathElement pathElement5=new Switch();

        pathElement1.setID(1);
        pathElement2.setID(2);
        pathElement3.setID(3);
        pathElement4.setID(4);
        pathElement5.setID(5);

        List<PathElement> pathElements1=new ArrayList<>();
        List<PathElement> pathElements2=new ArrayList<>();
        List<PathElement> pathElements3=new ArrayList<>();
        List<PathElement> pathElements4=new ArrayList<>();
        List<PathElement> pathElements5=new ArrayList<>();

        pathElements1.add(pathElement2);
        pathElements1.add(pathElement3);

        pathElements2.add(pathElement3);
        pathElements2.add(pathElement5);

        pathElements3.add(pathElement4);

        pathElements4.add(pathElement1);

        pathElements5.add(pathElement4);

        pathElement1.setConnections(pathElements1);
        pathElement2.setConnections(pathElements2);
        pathElement3.setConnections(pathElements3);
        pathElement4.setConnections(pathElements4);
        pathElement5.setConnections(pathElements5);

        PathFinderHelper pathFinderHelper=new PathFinderHelper();
        pathFinderHelper.findPathWithMinimalElementsCount(pathElement1,pathElement4,0);
    }
}
