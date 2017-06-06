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
public class ApplicationData {  //все данные приложения для хранения

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
       for (RouteProvider provider:routeProviders)
       {
           string+=provider.toString();
       }
       string+=" ]@";
       return string;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + networks.hashCode();
        result = prime * result + routeProviders.hashCode();
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
        ApplicationData other = (ApplicationData) obj;
        if (!networks.equals(other.networks) || !routeProviders.equals(other.routeProviders))
            return false;
        return true;
    }
}
