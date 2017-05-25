package Network;
import Helpers.ProjectValuesGenerator;
import PathElements.Interfaces.PathElement;
import java.util.ArrayList;
import java.util.List;

public class Network {

    private int id;
    private String networkName;
    private List<PathElement> pathElements;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
}
