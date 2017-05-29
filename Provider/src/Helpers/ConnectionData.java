package Helpers;

import PathElements.AbstractClasses.PathElement;

public class ConnectionData implements Comparable{
    PathElement pathElement;
    double cost;
    double timeDelay;

    public ConnectionData() {
        pathElement = null;
        cost = 0;
        timeDelay = 0;
    }

    public ConnectionData(PathElement pathElement){
        this.pathElement=pathElement;
        this.cost=0;
        this.timeDelay=0;
    }

    public ConnectionData(PathElement pathElement, double cost, double timeDelay) {
        this.pathElement = pathElement;
        this.cost = cost;
        this.timeDelay = timeDelay;
    }

    @Override
    public int compareTo(Object o) {
        ConnectionData element = (ConnectionData) o;
        return this.pathElement.compareTo(element.pathElement);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + pathElement.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ConnectionData other = (ConnectionData) obj;
        if (pathElement != other.pathElement)
            return false;
        return true;
    }
}
