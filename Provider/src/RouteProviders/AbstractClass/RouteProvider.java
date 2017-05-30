package RouteProviders.AbstractClass;

import Helpers.IPAdress;
import Helpers.Route;
import Helpers.Exceptions.RouteNotFoundException;
import Network.Network;

public abstract class RouteProvider {

    private String providerName;

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    protected RouteProvider(String providerName){
        this.setProviderName(providerName);
    }

    public Route getRouteByID(int firstID, int secondID, Network network) throws RouteNotFoundException{
        throw new RouteNotFoundException();
    }

    public Route getRouteByIP(IPAdress firstIP, IPAdress secondIP, Network network) throws RouteNotFoundException{
        throw new RouteNotFoundException();
    }

}
