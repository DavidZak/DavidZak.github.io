package Main;

import ApplicationFacade.ApplicationFacade;
import Helpers.ApplicationData.ApplicationData;
import Helpers.ApplicationData.ApplicationDataContainer;
import Helpers.ConnectionData;
import Helpers.Exceptions.RouteNotFoundException;
import Network.Network;
import PathElements.AbstractClasses.PathElement;
import PathElements.Classes.Switch;
import RouteProvider.PathFinders.MinimalCostPathFinder;
import RouteProvider.PathFinders.PathFinder;
import RouteProvider.RouteProvider;
import UIFacade.CommandParser.CommandParser;
import UIFacade.CommandPattern.Command;
import UIFacade.CommandPattern.RouteByIDCommand;
import UIFacade.CommandPattern.RouteByIPCommand;
import UIFacade.UIFacade;

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

        pathElement1.ID=1;
        pathElement2.ID=2;
        pathElement3.ID=3;
        pathElement4.ID=4;
        pathElement5.ID=5;

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

        pathElement1.connections=pathElements1;
        pathElement2.connections=pathElements2;
        pathElement3.connections=pathElements3;
        pathElement4.connections=pathElements4;
        pathElement5.connections=pathElements5;

        //PathFinderHelper pathFinderHelper=new PathFinderHelper();
        //pathFinderHelper.findPathWithMinimalElementsCount(pathElement1,pathElement4,0);

        Network network=new Network("net");
        network.setID(1);

        network.pathElements.add(pathElement1);
        network.pathElements.add(pathElement2);
        network.pathElements.add(pathElement3);

        PathFinder pathFinder=new MinimalCostPathFinder();
        RouteProvider provider=new RouteProvider("pro",pathFinder);

        ApplicationFacade applicationFacade=
                new ApplicationFacade(network,provider,1,3);

        Command command=new RouteByIDCommand(applicationFacade);
        Command command1=new RouteByIPCommand(applicationFacade);

        UIFacade uiFacade=new UIFacade(command,command1);
        uiFacade.readInput();

        //ApplicationDataContainer container=ApplicationDataContainer.getInstance();
        //container.readData();
        //container.addNetwork(network);
        //container.addRouteProvider(provider);

    }
}
