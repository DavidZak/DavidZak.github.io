package Main;

import Helpers.RouteNotFoundException;
import Network.Network;
import PathElements.Classes.Switch;
import PathElements.Interfaces.PathElement;
import RouteProviders.IDRouteProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class Main {
    public static void main(String[] args) {

        List<PathElement> elements=new ArrayList<>();

        PathElement switchElement1=new Switch();
        switchElement1.setID(1);
        switchElement1.setDescription("switch1");

        PathElement switchElement2=new Switch();
        switchElement2.setID(2);
        switchElement1.setDescription("switch2");

        PathElement switchElement3=new Switch();
        switchElement3.setID(3);
        switchElement1.setDescription("switch3");

        PathElement switchElement4=new Switch();
        switchElement4.setID(4);

        PathElement switchElement5=new Switch();
        switchElement5.setID(5);

        PathElement switchElement6=new Switch();
        switchElement6.setID(1);

        List<PathElement> connections1=new ArrayList<>();
        connections1.add(switchElement2);
        connections1.add(switchElement4);
        switchElement1.setConnections(connections1);

        List<PathElement> connections2=new ArrayList<>();
        connections2.add(switchElement1);
        connections2.add(switchElement3);
        connections2.add(switchElement5);
        switchElement2.setConnections(connections2);

        List<PathElement> connections3=new ArrayList<>();
        connections3.add(switchElement5);
        switchElement3.setConnections(connections3);

        List<PathElement> connections4=new ArrayList<>();
        connections4.add(switchElement3);
        switchElement4.setConnections(connections4);

        Network network=new Network("azaz",elements);
        List<PathElement> pathElements=new ArrayList<>();
        pathElements.add(switchElement1);
        pathElements.add(switchElement2);
        pathElements.add(switchElement3);
        pathElements.add(switchElement4);
        network.setPathElements(pathElements);

        IDRouteProvider provider=new IDRouteProvider();
        try {

            Set<PathElement> elements1 = provider.bfs(1,3,network);
            Set<PathElement> elements2 = provider.dfs(1,3,network);
            if (elements1.size()<elements2.size())
                System.out.println(elements1);
            System.out.println(elements2);
        } catch (RouteNotFoundException e) {
            e.printStackTrace();
        }
    }
}
