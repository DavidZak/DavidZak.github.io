package PathElements.Classes;

import Helpers.IPAddress;
import PathElements.AbstractClasses.PathElement;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "RouterElement")
public class Router extends PathElement {

    public Router(){

    }

    public Router(int ID, IPAddress IP) {
        super(ID, IP);
    }
}
