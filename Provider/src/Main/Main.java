package Main;

import Helpers.RouteNotFoundException;
import Network.Network;
import PathElements.Classes.Cable;
import PathElements.Classes.PC;
import PathElements.Classes.Router;
import PathElements.Classes.Switch;
import PathElements.Interfaces.PathElement;
import RouteProviders.IDRouteProvider;
import RouteProviders.RouteProvider;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        System.out.println("main");

        List<PathElement> elements=new ArrayList<>();

        PathElement switchElement1=new Switch();
        switchElement1.setID(1);

        PathElement switchElement2=new Switch();
        switchElement2.setID(2);

        PathElement switchElement3=new Switch();
        switchElement3.setID(3);

        PathElement switchElement4=new Switch();
        switchElement4.setID(1);

        PathElement switchElement5=new Switch();
        switchElement5.setID(1);

        PathElement switchElement6=new Switch();
        switchElement6.setID(1);

        List<PathElement> connections1=new ArrayList<>();
        connections1.add(switchElement2);
        connections1.add(switchElement3);
        connections1.add(switchElement4);
        switchElement1.setConnections(connections1);

        List<PathElement> connections2=new ArrayList<>();
        connections2.add(switchElement1);
        connections2.add(switchElement4);
        connections2.add(switchElement5);
        switchElement2.setConnections(connections2);

        List<PathElement> connections3=new ArrayList<>();
        connections3.add(switchElement1);
        switchElement3.setConnections(connections3);

        Network network=new Network("azaz",elements);
        List<PathElement> pathElements=new ArrayList<>();
        pathElements.add(switchElement1);
        pathElements.add(switchElement2);
        pathElements.add(switchElement3);
        network.setPathElements(pathElements);

        RouteProvider provider=new IDRouteProvider();
        try {
            provider.getRoutes(1,3,network);
        } catch (RouteNotFoundException e) {
            e.printStackTrace();
        }
    }
}
