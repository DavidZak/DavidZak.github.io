package Helpers;

import PathElements.Interfaces.PathElement;

import java.util.LinkedList;
import java.util.List;

public class Route {
    private List<PathElement> pathElementsInRoute;

    public List<PathElement> getPathElementsInRoute() {
        return pathElementsInRoute;
    }

    public Route(){
        this.pathElementsInRoute = new LinkedList<>();
    }

    public Route(List<PathElement> pathElements){
        this.pathElementsInRoute = pathElements;
    }
}
