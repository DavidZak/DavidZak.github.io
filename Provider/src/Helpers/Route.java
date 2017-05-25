package Helpers;

import PathElements.Interfaces.PathElement;

import java.util.LinkedList;

public class Route {
    private LinkedList<PathElement> pathElementsInRoute;

    public LinkedList<PathElement> getPathElementsInRoute() {
        return pathElementsInRoute;
    }

    public Route(){
        this.pathElementsInRoute = new LinkedList<>();
    }

    public Route(LinkedList<PathElement> pathElements){
        this.pathElementsInRoute = pathElements;
    }
}
