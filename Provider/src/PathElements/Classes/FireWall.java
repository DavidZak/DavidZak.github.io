package PathElements.Classes;

import Helpers.IPAddress;
import PathElements.AbstractClasses.PathElement;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "FireWallElement")
public class FireWall extends PathElement {

    public FireWall(){

    }

    public FireWall(int ID, IPAddress IP) {
        super(ID, IP);
    }
}
