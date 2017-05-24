package PathElements.Interfaces;
import Helpers.IPAdress;

public class ActiveElement extends PathElement {

    protected IPAdress IP;

    public IPAdress getIP() {
        return IP;
    }

    public void setIP(IPAdress ip){
        IP=ip;
    }
}
