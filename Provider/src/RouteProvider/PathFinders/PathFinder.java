package RouteProvider.PathFinders;

import Helpers.IPAddress;
import Helpers.Route;
import Network.Network;
import PathElements.AbstractClasses.PathElement;

public interface PathFinder {

    Route findPath(int first, int second,Network network);
    Route findPath(String first,String second,Network network);
}
