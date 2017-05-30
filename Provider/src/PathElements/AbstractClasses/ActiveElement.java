package PathElements.AbstractClasses;
import Helpers.IPAddress;

public class ActiveElement extends PathElement {

    protected IPAddress IP;

    public IPAddress getIP() {
        return IP;
    }

    public void setIP(IPAddress ip){
        IP=ip;
    }
}
