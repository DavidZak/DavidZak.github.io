package PathElements.AbstractClasses;
import Helpers.IPAddress;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "activeElement")
public class ActiveElement extends PathElement {

    @XmlElement
    public IPAddress IP;

    public void setIP(IPAddress ip){
        IP=ip;
    }
}
