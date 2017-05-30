package RouteProviders.AbstractClass;

import Helpers.Exceptions.RouteNotFoundException;
import Helpers.IPAddress;
import Helpers.ProjectValuesGenerator;
import Helpers.Route;
import Network.Network;

public abstract class RouteProvider {

    private String providerName;

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public RouteProvider(){
        this.providerName = ProjectValuesGenerator.generateString();
        System.out.println(this.getProviderName());
    }

    protected RouteProvider(String providerName){
        this.setProviderName(providerName);
    }

    public Route getRoute(int firstID, int secondID, Network network) throws RouteNotFoundException{
        throw new RouteNotFoundException();
    }

    public Route getRoute(IPAddress firstIP, IPAddress secondIP, Network network) throws RouteNotFoundException{
        throw new RouteNotFoundException();
    }

    @Override
    public String toString() {
        return getProviderName();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (getProviderName() == null ? 0 : getProviderName().hashCode());
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
        RouteProvider other = (RouteProvider) obj;
        if (!getProviderName().equals(other.getProviderName()))
            return false;
        return true;
    }
}
