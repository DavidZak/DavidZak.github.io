package RouteProvider.PathFinders;

import Helpers.Route;
import Network.Network;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "MinimalCountPathFinder")
public class MinimalCountPathFinder extends PathFinder {

    public MinimalCountPathFinder(){
        super();
    }

    public MinimalCountPathFinder(String name){
        super(name);
    }

    @Override
    public Route findPath(int first, int second, Network network) {
        return null;
    }

    @Override
    public Route findPath(String first, String second, Network network) {
        return null;
    }
}
