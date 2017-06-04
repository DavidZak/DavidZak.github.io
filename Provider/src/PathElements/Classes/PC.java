package PathElements.Classes;

import Helpers.IPAddress;
import PathElements.AbstractClasses.PathElement;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "PCElement")
public class PC extends PathElement {

    public PC(){

    }

    public PC(int ID, IPAddress IP) {
        super(ID, IP);
    }
}
