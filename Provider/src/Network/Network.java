package Network;
import Helpers.ProjectValuesGenerator;
import PathElements.Interfaces.PathElement;
import java.util.ArrayList;
import java.util.List;

public class Network {

    private List<PathElement> pathElements;
    private String networkName;

    public List<PathElement> getPathElements() {
        return pathElements;
    }

    public void setPathElements(List<PathElement> pathElements) {
        this.pathElements = pathElements;
    }

    public String getNetworkName() {
        return networkName;
    }

    public void setNetworkName(String networkName) {
        this.networkName = networkName;
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
