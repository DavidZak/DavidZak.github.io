package Helpers;

import PathElements.AbstractClasses.PathElement;

import java.util.LinkedHashSet;
import java.util.Set;

public class Route {
    private Set<Integer> pathElementsInRoute;

    public Set<Integer> getPathElementsInRoute() {
        return pathElementsInRoute;
    }

    public Route(){
        this.pathElementsInRoute = new LinkedHashSet<>();
    }

    public Route(LinkedHashSet<Integer> pathElements){
        this.pathElementsInRoute = pathElements;
    }
}
