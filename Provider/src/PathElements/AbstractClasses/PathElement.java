package PathElements.AbstractClasses;

import Helpers.ConnectionData;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Set;

@XmlRootElement(name = "Element")
@XmlType(propOrder = {"ID", "connections"})
public abstract class PathElement implements Comparable {

    @XmlElement(name = "ID")
    public int ID;

    @XmlElementWrapper
    @XmlElement(name = "connection")
    public Set<ConnectionData> connections;

    @Override
    public int compareTo(Object o) {
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
