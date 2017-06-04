package PathElements.Classes;

import Helpers.IPAddress;
import PathElements.AbstractClasses.PathElement;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "SwitchElement")
public class Switch extends PathElement {

    public Switch(){

    }

    public Switch(int ID, IPAddress IP) {
        super(ID, IP);
    }
}
