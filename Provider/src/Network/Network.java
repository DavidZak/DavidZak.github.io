package Network;
import Helpers.ProjectValuesGenerator;
import PathElements.Interfaces.PathElement;
import java.util.ArrayList;
import java.util.List;

public class Network {

    private int id;
    private String networkName;
    private List<PathElement> pathElements;

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getNetworkName() {
        return networkName;
    }

    public void setNetworkName(String networkName) {
        this.networkName = networkName;
    }

    public List<PathElement> getPathElements() {
        return pathElements;
    }

    public void setPathElements(List<PathElement> pathElements) {
        this.pathElements = pathElements;
    }

    public Network() {
        this.networkName = ProjectValuesGenerator.generateString();
        System.out.println(this.networkName);
        this.pathElements = new ArrayList<>();
    }

    public Network(String networkName, List<PathElement> pathElements) {
        this.networkName = networkName;
        this.pathElements = pathElements;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + getID();
        result = prime * result + (getNetworkName() == null ? 0 : getNetworkName().hashCode());
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
        Network other = (Network) obj;
        if (getID() != other.getID() || getNetworkName() != other.networkName)
            return false;
        return true;
    }
}
