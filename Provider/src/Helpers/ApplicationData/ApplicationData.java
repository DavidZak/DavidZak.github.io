package Helpers.ApplicationData;

import Network.Network;
import RouteProvider.RouteProvider;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.HashSet;
import java.util.Set;

@XmlRootElement(name = "Data")
@XmlType(propOrder = {"networks", "routeProviders"})
public class ApplicationData {

    @XmlElement(name="network")
    @XmlElementWrapper
    public Set<Network> networks;

    @XmlElement(name="provider")
    @XmlElementWrapper
    public Set<RouteProvider> routeProviders;

    public ApplicationData(Set<Network> networks, Set<RouteProvider> routeProviders) {
        this.networks = networks;
        this.routeProviders = routeProviders;
    }

    public ApplicationData() {
        this.networks = new HashSet<>();
        this.routeProviders = new HashSet<>();
    }

    @Override
    public String toString() {
       String string="@[ ApplicationData: ";
       for (Network network:networks){
           string+=network.toString();
       }
       string+=" ]@";
       return string;
    }
}
