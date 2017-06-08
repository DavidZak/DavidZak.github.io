package PathElements.AbstractClasses;

import Helpers.ConnectionData;
import Helpers.IPAddress;
import PathElements.Classes.*;

import javax.xml.bind.annotation.*;
import java.util.HashSet;
import java.util.Set;

@XmlRootElement(name = "Element")
@XmlType(propOrder = {"ID", "IP", "connections"})
@XmlSeeAlso({Cable.class, FireWall.class, Hub.class, PC.class, Router.class,Switch.class})
public class PathElement implements Comparable {        //базовый класс для всех элементов, содержит список связанных элементов

    @XmlElement(name = "ID")
    public int ID;

    @XmlElement(name = "IP")
    public IPAddress IP;

    @XmlElementWrapper
    @XmlElement(name = "connection")
    public Set<ConnectionData> connections;

    public PathElement() {
        this.ID = -1;
        this.IP = null;
        this.connections = new HashSet<>();
    }

    public PathElement(int ID, IPAddress IP) {
        this.ID = ID;
        this.IP = IP;
        this.connections = new HashSet<>();
    }

    public PathElement(int ID) {
        this.ID = ID;
        this.IP = null;
        this.connections = null;
    }

    public PathElement(IPAddress IP) {
        this.ID = -1;
        this.IP = IP;
        this.connections = null;
    }

    public PathElement(int ID, IPAddress IP, Set<ConnectionData> connections) {
        this.ID = ID;
        this.IP = IP;
        this.connections = connections;
    }

    @Override
    public int compareTo(Object o) {        //сравнение по ID
        PathElement element = (PathElement) o;
        if (this.ID > element.ID)
            return 1;
        if (this.ID < element.ID)
            return -1;
        return 0;
    }

    @Override
    public String toString() {
        return "#" + ID;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ID;
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
        PathElement other = (PathElement) obj;
        if (ID != other.ID)
            return false;
        return true;
    }
}
