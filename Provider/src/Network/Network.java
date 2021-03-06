package Network;
import PathElements.AbstractClasses.PathElement;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name="network")
@XmlType(propOrder = {"id","networkName","pathElements"})
public class Network {      //класс сеть, хранит список элементов

    @XmlElement(name = "id")
    public int id;

    @XmlElement(name = "networkName")
    public String networkName;

    @XmlElementWrapper(name = "networkElements")
    @XmlElement(name = "element")
    public List<PathElement> pathElements;

    public void setID(int id) {
        this.id = id;
    }

    public void setNetworkName(String networkName) {
        this.networkName = networkName;
    }

    public void setPathElements(List<PathElement> pathElements) {
        this.pathElements = pathElements;
    }

    public Network() {
        this.networkName = "";
        //System.out.println(this.networkName);
        this.pathElements = new ArrayList<>();
    }

    public Network(String networkName) {
        this.networkName = networkName;
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
        result = prime * result + (networkName == null ? 0 : networkName.hashCode());
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
        if (!networkName.equals(other.networkName))
            return false;
        return true;
    }

    @Override
    public String toString() {
        String result = "[Network: id:" + id + "\n name: " + networkName + "\n PathElements: ";
        for (PathElement element : pathElements) {
            result += " " + element.toString();
        }
        result += "]";
        return result;
    }

    public PathElement getElementByID(int ID) {         //получить элемент по ID
        for (PathElement element : pathElements) {
            if (element.ID == ID)
                return element;
        }
        return null;
    }

    public PathElement getElementByIP(String IP) {          //получить элемент по IP
        for (PathElement element : pathElements) {
            try {
                PathElement activeElement = element;
                if (activeElement.IP.ip.equals(IP))
                    return activeElement;
            } catch (ClassCastException e) {
                return null;
            }
        }
        return null;
    }
}
