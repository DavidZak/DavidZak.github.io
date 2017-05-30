package Main;

import Helpers.ConnectionData;
import Helpers.Exceptions.RouteNotFoundException;
import Helpers.PathFinderHelper;
import PathElements.AbstractClasses.PathElement;
import PathElements.Classes.Switch;

import java.util.HashSet;
import java.util.Set;


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

        Set<ConnectionData> pathElements1=new HashSet<>();
        Set<ConnectionData> pathElements2=new HashSet<>();
        Set<ConnectionData> pathElements3=new HashSet<>();
        Set<ConnectionData> pathElements4=new HashSet<>();
        Set<ConnectionData> pathElements5=new HashSet<>();

        pathElements1.add(new ConnectionData(pathElement2,0,0));
        pathElements1.add(new ConnectionData(pathElement3,0,0));

        pathElements2.add(new ConnectionData(pathElement3,0,0));
        pathElements2.add(new ConnectionData(pathElement5,0,0));

        pathElements3.add(new ConnectionData(pathElement4,0,0));

        pathElements4.add(new ConnectionData(pathElement1,0,0));

        pathElements5.add(new ConnectionData(pathElement4,0,0));

        pathElement1.setConnections(pathElements1);
        pathElement2.setConnections(pathElements2);
        pathElement3.setConnections(pathElements3);
        pathElement4.setConnections(pathElements4);
        pathElement5.setConnections(pathElements5);

        PathFinderHelper pathFinderHelper=new PathFinderHelper();
        pathFinderHelper.findPathWithMinimalElementsCount(pathElement1,pathElement4,0);


    }
}
