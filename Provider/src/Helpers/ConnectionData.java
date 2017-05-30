package Helpers;

import PathElements.AbstractClasses.PathElement;

public class ConnectionData implements Comparable{

    private PathElement pathElement;
    private double cost;
    private double timeDelay;

    public PathElement getPathElement() {
        return pathElement;
    }

    public void setPathElement(PathElement pathElement) {
        this.pathElement = pathElement;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getTimeDelay() {
        return timeDelay;
    }

    public void setTimeDelay(double timeDelay) {
        this.timeDelay = timeDelay;
    }

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
