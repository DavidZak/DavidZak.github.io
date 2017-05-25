package Helpers;

import PathElements.AbstractClasses.PathElement;

import java.util.LinkedHashSet;
import java.util.Set;

public class Route {
    private Set<PathElement> pathElementsInRoute;

    public Set<PathElement> getPathElementsInRoute() {
        return pathElementsInRoute;
    }

    public Route(){
        this.pathElementsInRoute = new LinkedHashSet<>();
    }

    public Route(LinkedHashSet<PathElement> pathElements){
        this.pathElementsInRoute = pathElements;
    }
}
