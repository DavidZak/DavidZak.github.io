package PathElements.Classes;

import PathElements.AbstractClasses.PathElement;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "HubElement")
public class Hub extends PathElement {

    public Hub(){

    }

    public Hub(int ID) {
        super(ID);
    }
}
