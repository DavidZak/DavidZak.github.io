package PathElements.Interfaces;

import java.util.List;

public abstract class PathElement {

    protected double timeDelay;
    protected double cost;
    protected List<PathElement> connections;
    protected int ID;
    protected String description;

    public double getTimeDelay() {
        return timeDelay;
    }

    public void setTimeDelay(double timeDelay){
        this.timeDelay=timeDelay;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost){
        this.cost=cost;
    }

    public List<PathElement> getConnections() {
        return connections;
    }

    public void setConnections(List<PathElement> connections){
        this.connections=connections;
    }

    public int getID() {
        return ID;
    }

    public void setID(int id){
        this.ID=id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description){
        this.description=description;
    }
}
