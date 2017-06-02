package Helpers;

import PathElements.AbstractClasses.PathElement;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "connection")
@XmlType(propOrder = {"pathElementID", "cost","timeDelay"})
public class ConnectionData implements Comparable{

    @XmlElement(name = "pathElementID")
    public int pathElementID;

    @XmlElement(name = "cost")
    public double cost;

    @XmlElement(name = "timeDelay")
    public double timeDelay;

    public void setPathElementID(int pathElementID) {
        this.pathElementID = pathElementID;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setTimeDelay(double timeDelay) {
        this.timeDelay = timeDelay;
    }

    public ConnectionData() {
        pathElementID=-1;
        cost = 0;
        timeDelay = 0;
    }

    public ConnectionData(PathElement pathElement){
        this.pathElementID=pathElement.ID;
        this.cost=0;
        this.timeDelay=0;
    }

    public ConnectionData(PathElement pathElement, double cost, double timeDelay) {
        this.pathElementID = pathElement.ID;
        this.cost = cost;
        this.timeDelay = timeDelay;
    }

    @Override
    public int compareTo(Object o) {
        ConnectionData element = (ConnectionData) o;
        return this.pathElementID=element.pathElementID;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + pathElementID;
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
        if (pathElementID != other.pathElementID)
            return false;
        return true;
    }
}
