package RouteProviders;

import Helpers.RouteNotFoundException;
import Network.Network;
import PathElements.Interfaces.PathElement;

import java.util.List;

public interface RouteProvider {
    public List<PathElement> getRoute(int firstID, int secondID, Network network) throws RouteNotFoundException;
}
