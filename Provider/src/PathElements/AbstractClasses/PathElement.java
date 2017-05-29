package PathElements.AbstractClasses;

import Helpers.ConnectionData;

import java.util.List;

public abstract class PathElement implements Comparable {

    protected List<ConnectionData> connections;
    protected int ID;
    protected String description;

    public List<ConnectionData> getConnections() {
        return connections;
    }

    public void setConnections(List<ConnectionData> connections) {
        this.connections = connections;
    }

    public int getID() {
        return ID;
    }

    public void setID(int id) {
        this.ID = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int compareTo(Object o) {
        PathElement element = (PathElement) o;
        if (this.getID() > element.getID())
            return 1;
        if (this.getID() < element.getID())
            return -1;
        return 0;
    }

    @Override
    public String toString() {
        return "#" + getID();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + getID();
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
        if (getID() != other.getID())
            return false;
        return true;
    }
}
